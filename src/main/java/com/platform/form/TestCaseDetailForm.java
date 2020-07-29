package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TestCaseDetailForm extends BaseForm {

    /**
     * 依赖的用例id
     * @required
     */
    @NotNull
    private Integer caseId;

    /**
     * 依赖的接口id
     * @required
     */
    @NotNull
    private Integer interfaceId;

    /**
     * 重连次数
     * 默认3次
     */
    //默认值写再service层里
    private Integer reconnectionTimes;

    /**
     * 默认最长等待时间
     * 默认10秒
     */
    //默认值写再service层里
    private Integer waitTime;

    /**
     * 是否使用mock
     * 默认false
     */
    //默认值写再service层里
    private Boolean isMock;

    /**
     * mock的响应结果
     * 执行测试时，当isMock为true则跳过请求并使用mockResponse的响应参数
     */
    //默认值写再service层里
    private String mockResponse;

    /**
     * 是否使用参数化
     * 默认false
     * 执行测试时，当isExpression为true，则对参数中符合表达式的进行参数化
     */
    //默认值写再service层里
    private Boolean isExpression;

    /**
     * 请求头
     * 默认"{}"
     */
    //默认值写在service层里
    private String headers;

    /**
     * url上携带的参数
     * 默认"{}"
     */
    //默认值写在service层里
    private String parames;

    /**
     * 请求体里携带的参数
     * 默认"{}"
     */
    //默认值写在service层里
    private String data;

    /**
     * 用例节点描述
     */
    @Size(max = 100, message = "用例节点描述不能超过100个字符")
    private String text;

    // form中去除sort字段，默认值写在service层里
}
