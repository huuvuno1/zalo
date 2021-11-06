package com.nguyenhuuvu.backend.document;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VerifyInfo {
    private int code;
    private Date timeExpire;
}
