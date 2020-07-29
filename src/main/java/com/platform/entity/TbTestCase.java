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
@TableName("tb_test_case")
public class TbTestCase extends BaseEntity implements Serializable {

    /**
     * 关联的计划id
     */
    private Integer planId;

    /**
     * 用例名称
     */
    private String caseName;

    /**
     * 测试用例描述
     */
    private String text;

    /**
     * 测试套件中用例的执行顺序
     */
    private Integer sort;
}