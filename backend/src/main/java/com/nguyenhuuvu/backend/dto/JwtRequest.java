package com.nguyenhuuvu.backend.dto;

import com.nguyenhuuvu.backend.utils.Constant;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class JwtRequest {
    @NotBlank(message = Constant.NOT_BLANK)
    private String email;
    @NotBlank(message = Constant.NOT_BLANK)
    private String password;
}
