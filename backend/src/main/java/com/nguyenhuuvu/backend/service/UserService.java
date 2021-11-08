package com.nguyenhuuvu.backend.service;

import com.nguyenhuuvu.backend.document.User;

public interface UserService {
    User updateUser(User user);
    // return code
    String sendVerifyEmail(String email);
    void verifyMail(String email, String code);
}
