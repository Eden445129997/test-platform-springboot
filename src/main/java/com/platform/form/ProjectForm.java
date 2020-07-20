package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProjectForm extends BaseForm {

    @NotBlank(message="项目名称不能为空")
    @Size(max = 10, message = "项目名称不能超过10个字符")
    private String projectName;

    @Size(max = 100, message = "项目描述不能超过100个字符")
    private String text;

    @NotBlank(message="负责人不能为空")
    @Size(max = 10, message = "项目负责人不能超过10个字符")
    private String projectLeader;
}
