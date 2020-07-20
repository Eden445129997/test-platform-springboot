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
@TableName("tb_interface")
public class TbInterface extends BaseEntity implements Serializable {

    private String projectId;

    private String busiId;

    private String apiName;

    private String method;

    private String path;

    private String text;

    private Boolean status;

    private String defaultData;

}