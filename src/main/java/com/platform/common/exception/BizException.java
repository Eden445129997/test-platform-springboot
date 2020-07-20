package com.platform.common.exception;

import com.platform.common.enums.IResponseEnum;
import com.platform.common.enums.ResStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 业务异常
 */
@Getter
@Setter
public class BizException extends BaseException implements Serializable {

    private static final long serialVersionUID = -3549155011652257889L;

    private String detail;

    public BizException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    public BizException(IResponseEnum responseEnum, String detail) {
        super(responseEnum);
        this.detail = detail;
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(String message) {
        super(ResStatus.BIZ_ERROR.getCode(),message);
    }

}