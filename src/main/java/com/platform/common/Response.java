package com.platform.common;

import com.platform.common.enums.ResStatus;
import com.platform.common.exception.BaseException;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用的 API 接口封装
 */
@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1195704693201139227L;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 元素总数量
     */
    private Long totalElement;

    public Response() {
        super();
    }

    public Response(ResStatus resStatus, T data) {
        this.code = resStatus.getCode();
        this.message = resStatus.getMessage();
        this.data = data;
        this.totalElement = 0L;
    }

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalElement = 0L;
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        this.totalElement = 0L;
    }

    public Response(Integer code, String message, T data, Long totalElement) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalElement = totalElement;
    }

    public static com.platform.common.Response success() {
        return new com.platform.common.Response(ResStatus.SUCCESS.getCode(), ResStatus.SUCCESS.getMessage(), null);
    }

    public static com.platform.common.Response success(String msg) {
        return new com.platform.common.Response(ResStatus.SUCCESS.getCode(), msg, "");
    }

    public static com.platform.common.Response success(String msg, Object data) {
        return new com.platform.common.Response(ResStatus.SUCCESS.getCode(), msg, data);
    }

    public static com.platform.common.Response success(String msg, Object data, Long totalElement) {
        return new com.platform.common.Response(ResStatus.SUCCESS.getCode(), msg, data, totalElement);
    }

    public static com.platform.common.Response error() {
        return new com.platform.common.Response(ResStatus.SERVER_ERROR.getCode(), ResStatus.SERVER_ERROR.getMessage(), null);
    }

    public static com.platform.common.Response error(String msg) {
        return new com.platform.common.Response(ResStatus.SERVER_ERROR.getCode(), msg, null);
    }

    public static com.platform.common.Response error(String msg, Object data) {
        return new com.platform.common.Response(ResStatus.SERVER_ERROR.getCode(), msg, data);
    }

    public static com.platform.common.Response error(ResStatus status) {
        return new com.platform.common.Response(status.getCode(), status.getMessage(), null);
    }

    /**
     * 构造一个异常的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> com.platform.common.Response customException(T t) {
        return customException(t, null);
    }

    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t    异常
     * @param data 返回数据
     * @param <T>  {@link BaseException} 的子类
     * @return Response
     */
    public static <T extends BaseException> com.platform.common.Response customException(T t, Object data) {
        return new com.platform.common.Response(t.getCode(), t.getMessage(), data);
    }

    /**
     * 是否成功
     *
     * @param response
     * @return boolean
     * @author lingyuwang
     * @date 2019/12/17 18:49
     */
    public static boolean isSuccess(com.platform.common.Response response) {
        return response != null && ResStatus.SUCCESS.getCode().equals(response.getCode());
    }

    /**
     * 是否失败
     *
     * @param response
     * @return boolean
     * @author lingyuwang
     * @date 2019/12/17 18:50
     */
    public static boolean isFailure(com.platform.common.Response response) {
        return response == null || !ResStatus.SUCCESS.getCode().equals(response.getCode());
    }

    /**
     * data是否不为空
     *
     * @author xly
     * @since 2019-12-25
     */
    public static <T> Boolean nonNull(com.platform.common.Response<T> response) {
        return response != null &&
                response.getData() != null &&
                ResStatus.SUCCESS.getCode().equals(response.getCode());
    }

    /**
     * 判断data是否为空
     *
     * @return Boolean
     * @author yangqiao
     * @date 2020-07-11 14:28
     * @since 1.1.3.0
     */
    public static <T> Boolean isNull(com.platform.common.Response<T> response) {
        return response == null ||
                !ResStatus.SUCCESS.getCode().equals(response.getCode()) ||
                response.getData() == null;
    }

}
