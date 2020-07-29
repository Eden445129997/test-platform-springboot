package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TestCaseForm extends BaseForm {

    /**
     * 依赖的测试计划id
     * @required
     */
    @NotNull
    private Integer planId;

    /**
     * 测试用例名称
     * @required
     */
    @NotBlank(message="用例名称不能为空")
    @Size(max = 10, message = "用例名称不能超过10个字符")
    private String caseName;

    /**
     * 测试用例描述
     */
    @Size(max = 100, message = "用例描述不能超过100个字符")
    private String text;

    // form中去除sort字段
}