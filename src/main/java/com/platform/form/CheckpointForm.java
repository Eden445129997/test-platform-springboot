package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CheckpointForm extends BaseForm {

    /**
     * 关联的测试节点id
     */
    @NotNull
    private Integer caseDetailId;

    /**
     * 校验对象（jsonpath表达式）
     */
    @NotBlank(message="校验对象不能为空")
    @Size(max = 100, message = "校验对象不能超过100个字符")
    private String checkObject;

    /**
     * 校验方法
     */
    @NotBlank(message="校验方法不能为空")
    @Size(max = 100, message = "校验对象不能超过100个字符")
    private String checkMethod;

    /**
     * 校验点描述
     */
    @NotBlank(message="校验点描述不能为空")
    @Size(max = 100, message = "校验点描述不能超过100个字符")
    private String text;

    /**
     * 校验点的比对值
     */
    @NotBlank(message="校验点比对值")
    @Size(max = 100, message = "校验点比对值不能超过100个字符")
    private String checkValue;
}
