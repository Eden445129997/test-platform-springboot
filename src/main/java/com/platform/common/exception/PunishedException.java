package com.platform.common.exception;

import com.platform.common.enums.ResStatus;

import java.io.Serializable;

/**
 * 处罚异常
 */
public class PunishedException extends BaseException implements Serializable {

    private static final long serialVersionUID = 7858320956270247551L;

    public PunishedException(ResStatus status) {
        super(status);
    }

    public PunishedException(Integer code, String message) {
        super(code, message);
    }

}