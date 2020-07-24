package com.platform.entity;

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

    private Integer projectId;

    private String planName;

    private String creater;

    private String text;

    private Boolean status;

}