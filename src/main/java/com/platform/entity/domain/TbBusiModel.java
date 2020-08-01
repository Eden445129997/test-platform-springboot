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
@TableName("tb_busi_model")
public class TbBusiModel extends BaseEntity implements Serializable {

    /**
     * 关联的项目id
     */
    private Integer projectId;

    /**
     * 业务名称
     */
    private String busiName;

    /**
     * 业务描述
     */
    private String text;
}