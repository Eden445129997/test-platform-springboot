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
@TableName("tb_test_case_detail")
public class TbTestCaseDetail extends BaseEntity implements Serializable {

    private Integer caseId;

    private Integer interfaceId;

    private Integer reconnectionTimes;

    private Integer waitTime;

    private Boolean isMock;

    private String mockResponse;

    private Boolean isExpression;

    private String headers;

    private String parames;

    private String data;

    private String text;

    private Integer sort;
}
