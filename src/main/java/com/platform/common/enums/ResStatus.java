package com.platform.common.enums;

import lombok.Getter;

/**
 * 状态码封装
 */
@Getter
public enum ResStatus implements IResponseEnum{
    /**
     * 业务异常
     */
    BIZ_ERROR(101, "操作异常！"),

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 参数异常
     */
    PARAMETER_ERROR(400, "请求参数异常"),

    /**
     * 用户未登录
     */
    NOT_LOGIN_ERROR(401, "用户未登录"),
    /**
     * 在其他地方登录
     */
    LOGIN_OTHER(401100, "用户在其他地方登录"),

    /**
     * 请求超时
     */
    REQUEST_TIMEOUT(408, "访问超时，请重试"),

    /**
     * 名称重复
     */
    REPEAT_NAME_ERROR(409, "名称重复！"),

    /**
     * 验证码错误
     */
    ERROR_SMS_ERROR(400100, "验证码错误,请重新输入"),

    /**
     * 用户已存在
     */
    USER_EXISTENT(400300, "用户已存在,请返回登录"),

    /**
     * 用户已被封禁
     */
    USER_BLOCKED(400301, "用户已在封禁中，无法封禁"),

    /**
     * 报警消息状态异常
     */
    ALARM_MESSAGE_HANDLED_ERROR(400400, "该报警消息已处理，不需再上传视频"),

    /**
     * 服务器异常
     */
    SERVER_ERROR(500, "服务器开小差了，请稍后重试~"),

    /**
     * 未知异常
     */
    UNKONW_ERROR(500100, "未知异常"),

    /**
     * 封禁中
     */
    PUNISH_ERROR(600, "账号已封禁，请去个人主页申请解封"),

    /**
     * 拉黑状态
     */
    BLACK_LIST(400500, "拉黑状态"),

    /**
     * 版本异常
     */
    VERSION_ERROR(400600, "请求版本异常"),

    /**
     * 活动未开始
     */
    ACTIVITY_WAIT_START(400701, "活动未开始"),

    /**
     * 活动已结束
     */
    ACTIVITY_ENDED(400702, "活动已结束"),

    /**
     * app端二维码名片功能
     * @author xly
     * @date 2020-01-17 15:04
     * @since 1.0.4
     */
    UNSUPPORTED_QRCODE(700, "不支持的二维码"),

    /**
     * 数据不存在
     * @author yangqiao
     * @date 2020-04-14 15:35
     * @since 1.0.4
     */
    DATA_NOT_EXIST(900, "数据不存在"),

    /**
    * 数据异常
    *
    * @return
    * @author 赵云
    * @date 2020/6/18
    *
    */
    DATA_ERROR(901,"数据异常")

    ;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 内容
     */
    private String message;

    ResStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
