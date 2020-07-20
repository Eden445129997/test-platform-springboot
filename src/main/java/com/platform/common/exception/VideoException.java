package com.platform.common.exception;

import com.platform.common.enums.IResponseEnum;

public class VideoException extends BizException {

    public VideoException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    public VideoException(IResponseEnum responseEnum, String detail) {
        super(responseEnum, detail);
    }

    public VideoException(Integer code, String message) {
        super(code, message);
    }

    public VideoException(String message) {
        super(message);
    }
}
