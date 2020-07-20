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
@TableName("tb_check_point")
public class TbCheckPoint extends BaseEntity implements Serializable {

    private String caseDetailId;

    private String checkObject;

    private String checkMethod;

    private String text;

    private Boolean status;

    private String checkValue;

}