package com.nguyenhuuvu.backend.config.exception;

import com.nguyenhuuvu.backend.dto.UserDTO;
import lombok.Getter;

@Getter
public class MyException extends RuntimeException{
    private UserDTO user;
    public MyException(String message) {
        super(message);
    }
    public MyException(String message, UserDTO data) {
        super(message);
        this.user = data;
    }
}
