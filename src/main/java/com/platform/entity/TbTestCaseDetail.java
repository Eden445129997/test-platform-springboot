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

    private Boolean expressionStatus;

    private String headers;

    private String data;

    private String mockResponse;

    private Integer reconnectionTimes;

    private Integer waitTime;

    private Boolean mockStatus;

    private String text;

    private Integer sort;

    private Boolean status;
}