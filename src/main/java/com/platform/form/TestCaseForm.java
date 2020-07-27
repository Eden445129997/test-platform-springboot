package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TestCaseForm extends BaseForm {

    @NotNull
    private Integer planId;

    @NotBlank(message="用例名称不能为空")
    @Size(max = 10, message = "用例名称不能超过10个字符")
    private String caseName;

    @Size(max = 100, message = "用例节点描述不能超过100个字符")
    private String text;

    // form中去除sort字段
}