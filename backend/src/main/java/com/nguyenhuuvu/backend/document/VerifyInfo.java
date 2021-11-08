package com.nguyenhuuvu.backend.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyInfo {
    private String code;
    private int status;
    private Date timeExpire;
}
