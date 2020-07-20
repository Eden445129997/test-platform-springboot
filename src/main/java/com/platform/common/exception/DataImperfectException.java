package com.platform.common.exception;

import java.io.Serializable;

/**
 * 数据不完整（缺失）异常
 *
 * @author weiwenduo
 * @date 2020-3-14 12:10:56
 * @since 1.0.8
 */
public class DataImperfectException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -7638295612219012542L;
    private static final String DEFAULT_MESSAGE = "数据不完整或数据缺失";

    public DataImperfectException() {
        super(DEFAULT_MESSAGE);
    }

    public DataImperfectException(String message) {
        super(message);
    }

    public DataImperfectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataImperfectException(Throwable cause) {
        super(cause);
    }

    public DataImperfectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
