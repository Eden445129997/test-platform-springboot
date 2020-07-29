package com.platform.form;

import com.platform.common.dto.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class InterfaceForm extends BaseForm {

    /**
     * 关联的项目id，非必填
     */
    private Integer projectId;

    /**
     * 关联的业务id，非必填
     */
    private Integer busiId;

    /**
     * 接口名称
     * @required
     */
    @NotBlank(message="接口名称不能为空")
    @Size(max = 10, message = "接口名称不能超过10个字符")
    private String apiName;

    /**
     * 请求方式
     * @required
     */
    @NotBlank(message = "请求方法不能为空")
    @Size(max = 10, message = "请求方法不能超过10个字符")
    private String method;

    /**
     * 请求资源路径
     * @required
     */
    @NotBlank(message = "请求资源路径不能为空")
    private String path;

    /**
     * 接口描述
     */
    @Size(max = 100, message = "接口描述不能超过100个字符")
    private String text;

    /**
     * 默认参数模版（看情况保留或者删除掉）
     */
    private String defaultData;
}
