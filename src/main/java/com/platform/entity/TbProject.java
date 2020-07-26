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

    private String projectName;

    private String text;

    private String projectLeader;

}