package com.platform.common.exception;

import com.platform.common.enums.ResStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Api 版本异常（只是back-http服务用到）
 */
@Getter
@Setter
public class ApiVersionException extends BaseException implements Serializable {

    private static final long serialVersionUID = -3549155011652257889L;

    private ApiVersionException() {
        super(ResStatus.VERSION_ERROR);
    }

    public static ApiVersionException build() {
        return new ApiVersionException();
    }

}