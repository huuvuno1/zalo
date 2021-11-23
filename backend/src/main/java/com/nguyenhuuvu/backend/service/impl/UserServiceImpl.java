package com.nguyenhuuvu.backend.service.impl;

import com.nguyenhuuvu.backend.config.exception.MyException;
import com.nguyenhuuvu.backend.document.User;
import com.nguyenhuuvu.backend.document.VerifyInfo;
import com.nguyenhuuvu.backend.dto.SearchQuery;
import com.nguyenhuuvu.backend.dto.UserDTO;
import com.nguyenhuuvu.backend.repository.UserRepository;
import com.nguyenhuuvu.backend.service.EmailService;
import com.nguyenhuuvu.backend.service.UserService;
import com.nguyenhuuvu.backend.utils.Constant;
import com.nguyenhuuvu.backend.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;
    final EmailService emailService;

    @Override
    public User updateUser(User user) {
        User userOld = userRepository.findFirstByEmail(user.getEmail());
        if (userOld != null && userOld.getVerifyInfo() != null) {
            if (userOld.isEnable()) {
                throw new MyException(Constant.UNVERIFIED_EMAIL, new UserDTO().builder()
                        .email(Constant.DUPLICATE_EMAIL)
                        .build());
            }
            // verified email
            if (userOld.getVerifyInfo().getStatus() == Constant.CODE_USED) {
                String password = passwordEncoder.encode(user.getPassword());
                userOld.setRoles(Stream.of("USER").collect(Collectors.toList()));
                userOld.setPassword(password);
                userOld.setEnable(true);
                userOld.setFullName(user.getFullName());
                return userRepository.save(userOld);
            }
        }
        else {
            throw new MyException(Constant.UNVERIFIED_EMAIL, new UserDTO().builder()
                    .email(Constant.UNVERIFIED_EMAIL)
                    .build());
        }
        return null;
    }

    @Override
    public String sendVerifyEmail(String email) {
        User user = userRepository.findFirstByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setEnable(false);
        }
        if (user.isEnable())
            throw new MyException(Constant.EMAIL_BEING_USED);
        Random random = new Random();
        String code = random.nextInt(899999) + 100000 + "";
        user.setVerifyInfo(new VerifyInfo().builder()
                .code(code)
                .status(0)
                .timeExpire(new Date(System.currentTimeMillis() + 3*60*60*1000) // 3 hour
            ).build());
        User finalUser = user;
        new Thread(() -> {
            emailService.sendSimpleMessage(finalUser.getEmail(), Constant.SUBJECT_MAIL,
                    "Mã xác minh của bạn là: " + code);
        }).start();
        userRepository.save(user);
        return code;
    }

    @Override
    public void verifyMail(String email, String code) {
        User user = userRepository.findFirstByEmail(email);
        if (user != null) {
            VerifyInfo verify = user.getVerifyInfo();
            if (verify.getStatus() == Constant.CODE_USED)
                throw new MyException(Constant.DUPLICATE_EMAIL);
            if (DateTimeUtil.isExpired(verify.getTimeExpire()))
                throw new MyException(Constant.CODE_EXPIRED);
            if (verify.getStatus() >= Constant.CODE_OVER_LIMIT) {
                throw new MyException(Constant.CODE_OVER_LIMIT_MESSAGE);
            }
            if (verify.getCode().equals(code)) {
                verify.setStatus(Constant.CODE_USED);
                user.setVerifyInfo(verify);
                userRepository.save(user);
            }
            else {
                verify.setStatus(verify.getStatus() + 1);
                user.setVerifyInfo(verify);
                userRepository.save(user);
                throw new MyException(Constant.CODE_OVER_LIMIT_WARNING);
            }
        }
    }

    @Override
    public List<UserDTO> find(SearchQuery<String> query) {
        // missing pagation
        List<User> users = userRepository.findUsersByEmailOrFullNameContains(query.getData(), query.getData());
        List<UserDTO> result = new ArrayList<>();
        users.forEach(user -> {
            UserDTO u = new UserDTO().builder()
                            .email(user.getEmail())
                            .fullName(user.getFullName())
                            .avatar(user.getAvatar())
                            .build();
            result.add(u);
        });
        return result;
    }


}
