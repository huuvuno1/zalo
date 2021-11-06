package com.nguyenhuuvu.backend.service.impl;

import com.nguyenhuuvu.backend.document.User;
import com.nguyenhuuvu.backend.repository.UserRepository;
import com.nguyenhuuvu.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        user.setRoles(Stream.of("USER").collect(Collectors.toList()));
        // hard code
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setEnable(true);
        return userRepository.save(user);
    }
}
