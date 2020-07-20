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
@TableName("tb_busi_model")
public class TbBusiModel extends BaseEntity implements Serializable {

    private String projectId;

    private String busiName;

    private Integer total;

    private String text;

    private Boolean status;

}