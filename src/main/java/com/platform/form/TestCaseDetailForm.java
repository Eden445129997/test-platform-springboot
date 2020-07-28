package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TestCaseDetailForm extends BaseForm {

    @NotNull
    private Integer caseId;

    @NotNull
    private Integer interfaceId;

    //默认值写再service层里
    private Integer reconnectionTimes;

    //默认值写再service层里
    private Integer waitTime;

    //默认值写再service层里
    private Boolean isMock;

    //默认值写再service层里
    private String mockResponse;

    //默认值写再service层里
    private Boolean isExpression;

    //默认值写在service层里
    private String headers;

    //默认值写在service层里
    private String parames;

    //默认值写在service层里
    private String data;

    @Size(max = 100, message = "用例节点描述不能超过100个字符")
    private String text;

    // form中去除sort字段，默认值写在service层里
}
