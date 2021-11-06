package com.nguyenhuuvu.backend.api;

import com.nguyenhuuvu.backend.document.User;
import com.nguyenhuuvu.backend.dto.BaseResponse;
import com.nguyenhuuvu.backend.dto.JwtRequest;
import com.nguyenhuuvu.backend.service.EmailService;
import com.nguyenhuuvu.backend.service.UserService;
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
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class AuthController {
    final UserService userService;
    final JwtTokenUtil jwtTokenUtil;
    final EmailService emailService;
    final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @NotNull(message = "not null") @RequestBody User user, HttpServletResponse response) {
        User userSave =  userService.save(user);
        return new ResponseEntity<>(
            new BaseResponse<User>().builder()
                .status(200)
                .message("Success!")
                .data(userSave)
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

    @PostMapping("/mail")
    public String test() {
        emailService.sendSimpleMessage("nguyenhuuvuno1@gmail.com", "heelo", "send from spring");
        return "oke";
    }
}
