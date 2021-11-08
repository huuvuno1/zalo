package com.nguyenhuuvu.backend.utils;

import java.util.Date;

public class DateTimeUtil {
    public static boolean isExpired(Date date) {
        return new Date().after(date);
    }
}
