package com.platform.common.exception;

import com.platform.common.enums.ResStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "用户未登录")
public class UnauthenticatedException extends BaseException implements Serializable {

    private static final long serialVersionUID = 4275854746721990508L;


    public UnauthenticatedException(ResStatus status) {
        super(status);
    }

    public UnauthenticatedException(Integer code, String message) {
        super(code, message);
    }

}