package com.nguyenhuuvu.backend.service;

import com.nguyenhuuvu.backend.document.User;
import com.nguyenhuuvu.backend.dto.SearchQuery;
import com.nguyenhuuvu.backend.dto.UserDTO;

import java.util.List;

public interface UserService {
    User updateUser(User user);
    // return code
    String sendVerifyEmail(String email);
    void verifyMail(String email, String code);

    List<UserDTO> find(SearchQuery<String> query);
}
