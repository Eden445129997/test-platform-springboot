package com.platform.common.exception;

import com.platform.common.enums.ResStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "No such data")
public class RepeatNameException extends BaseException implements Serializable {


    private static final long serialVersionUID = 2648505926324562549L;

    public RepeatNameException(ResStatus status) {
        super(status);
    }

    public RepeatNameException(Integer code, String message) {
        super(code, message);
    }

    public RepeatNameException(String message) {
        super(ResStatus.REPEAT_NAME_ERROR.getCode(),message);
    }
}

