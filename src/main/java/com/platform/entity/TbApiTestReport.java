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
@TableName("tb_api_test_report")
public class TbApiTestReport extends BaseEntity implements Serializable {

    private String executor;

    private Integer passTotal;

    private Integer falseTotal;

    private Integer total;

    private String taskStatus;

    private String timeTaken;

    private String host;
}