package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class InterfaceForm extends BaseForm {

    private Integer projectId;

    private Integer busiId;

    @NotBlank(message="接口名称不能为空")
    @Size(max = 10, message = "接口名称不能超过10个字符")
    private String apiName;

    @NotBlank(message = "请求方法不能为空")
    @Size(max = 10, message = "请求方法不能超过10个字符")
    private String method;

    @NotBlank(message = "请求资源路径不能为空")
    private String path;

    @Size(max = 100, message = "接口描述不能超过100个字符")
    private String text;

    private String defaultData;
}
