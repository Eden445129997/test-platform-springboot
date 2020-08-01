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
@TableName("tb_test_plan")
public class TbTestPlan extends BaseEntity implements Serializable {

    /**
     * 关联的项目id
     */
    private Integer projectId;

    /**
     * 测试计划名称
     */
    private String planName;

    /**
     * 测试计划描述
     */
    private String text;
}