package com.platform.common.exception;

import com.platform.common.enums.IResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * ApiServiceException
 *
 * @author weiwenduo
 * @date 2020-3-19 13:12:04
 * @since 1.0.8
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApiServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Integer DEFAULT_CODE = 500;
    private static final String DEFAULT_MESSAGE = "Server Error";

    private Integer code;
    private String message;

    public ApiServiceException() {
        this.code = DEFAULT_CODE;
        this.message = DEFAULT_MESSAGE;
    }

    public ApiServiceException(String message) {
        this.code = DEFAULT_CODE;
        this.message = message;
    }

    public ApiServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiServiceException(IResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

}