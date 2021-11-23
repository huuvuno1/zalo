package com.nguyenhuuvu.backend.utils;

public class Constant {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000;
    public static final String NOT_BLANK = "Vui lòng điền thông tin!";
    public static final String LENGTH_NOT_ALLOWED = "Phải chứa từ 5 đên 30 ký tự!";
    public static final String SUBJECT_MAIL = "Mã xác minh tài khoản Zalo";
    public static final String SUCCESS = "Success!";
    public static final String UNVERIFIED_EMAIL = "Email chưa được xác minh!";
    public static final int CODE_USED = -1;
    public static final int CODE_OVER_LIMIT = 5;
    public static final String CODE_OVER_LIMIT_MESSAGE = "Đã nhập sai quá 5 lần!";
    public static final String NOT_ACCEPT = "Mã code không hợp lệ";
    public static final String EMAIL_BEING_USED = "Email này đã được sử dụng!";
    public static final String CODE_EXPIRED = "Mã code đã hết hạn, hãy yêu cầu mã mới!";
    public static final String CODE_OVER_LIMIT_WARNING = "Code không hợp lệ!";
    public static final String DUPLICATE_EMAIL = "Email đã được sử dụng!";
    public static final String AUTH_FAIL = "Tài khoản hoặc mật khẩu sai";
    public static final String VALIDATE_EXCEPTION = "Vui lòng nhập đủ thông tin!";
}
