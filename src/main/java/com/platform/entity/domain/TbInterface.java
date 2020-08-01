package com.platform.entity.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.platform.common.dto.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_interface")
public class TbInterface extends BaseEntity implements Serializable {

    /**
     * 关联的项目id
     */
    private Integer projectId;

    /**
     * 关联的业务id
     */
    private Integer busiId;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 接口描述
     */
    private String text;

    /**
     * 默认值（以后看情况可能保留或者删除）
     */
    private String defaultData;
}