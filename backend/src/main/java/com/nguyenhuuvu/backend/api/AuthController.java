package com.nguyenhuuvu.backend.api;

import com.nguyenhuuvu.backend.document.User;
import com.nguyenhuuvu.backend.dto.BaseResponse;
import com.nguyenhuuvu.backend.dto.JwtRequest;
import com.nguyenhuuvu.backend.service.UserService;
import com.nguyenhuuvu.backend.utils.Constant;
import com.nguyenhuuvu.backend.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4000", allowCredentials = "true")
public class AuthController {
    final UserService userService;
    final JwtTokenUtil jwtTokenUtil;
    final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @NotNull(message = "not null") @RequestBody User user, HttpServletResponse response) {
        User userSave =  userService.updateUser(user);
        return new ResponseEntity<>(
            new BaseResponse<User>().builder()
                .status(200)
                .message("Success!")
                .data(Constant.SUCCESS)
                .build(), HttpStatus.OK
        );
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequest user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword()
        );
        Authentication authentication = null;
        try {
            authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        }
        catch (DisabledException e) {
            e.printStackTrace();
            throw e;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(authentication);
        return new ResponseEntity<>(
            new BaseResponse<String>().builder()
                    .status(HttpStatus.OK.value())
                    .message("Success!")
                    .data(token)
                    .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("/verification")
    public ResponseEntity<?> verifyMail(@Valid @NotBlank @RequestBody Map<String, String> body) {
        String code = userService.sendVerifyEmail(body.get("email"));
        return new ResponseEntity<>(new BaseResponse<Map<String, String>>().builder()
                .status(HttpStatus.OK.value())
                .message(Constant.SUCCESS)
                .build(),
            HttpStatus.OK);
    }

    @PostMapping("/verification/code")
    public ResponseEntity<?> verifyCode(@Valid @NotNull @RequestBody Map<String, String> body) {
        // method verifyMail will handle all cases
        userService.verifyMail(body.get("email"), body.get("code"));
        return new ResponseEntity<>(new BaseResponse<Map<String, String>>().builder()
                .status(HttpStatus.OK.value())
                .message(Constant.SUCCESS)
                .timeStamp(new Date())
                .build(),
                HttpStatus.OK);
    }
}
