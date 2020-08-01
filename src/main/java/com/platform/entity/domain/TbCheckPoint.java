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
@TableName("tb_check_point")
public class TbCheckPoint extends BaseEntity implements Serializable {

    /**
     * 关联的测试节点id
     */
    private Integer caseDetailId;

    /**
     * 校验对象（jsonpath表达式）
     */
    private String checkObject;

    /**
     * 校验方法
     */
    private String checkMethod;

    /**
     * 校验点描述
     */
    private String text;

    /**
     * 校验点的比对值
     */
    private String checkValue;
}