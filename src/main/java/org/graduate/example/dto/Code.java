package org.graduate.example.dto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public enum Code {
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权限"),
    LOGIN_ERROR(400, "用户名密码错误"),
    TOKEN_EXPIRED(403, "过期请重新登录"),
    UNAUTHORIZED(401, "未登录");

    public static final int ERROR = 400;
    private final int code;
    private final String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
