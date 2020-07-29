package com.platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.platform.common.dto.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Accessors(chain = true)
@TableName("tb_project")
public class TbProject extends BaseEntity implements Serializable {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目描述
     */
    private String text;

    /**
     * 项目负责人
     */
    private String projectLeader;
}