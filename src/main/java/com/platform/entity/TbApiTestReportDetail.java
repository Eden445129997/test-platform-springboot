package com.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_api_test_report_detail")
public class TbApiTestReportDetail implements Serializable {

    private Integer caseId;

    private Integer reportId;

    private String apiName;

    private String url;

    private String header;

    private String data;

    private String response;

    private String errorRecord;

    private Boolean isMock;

    private Integer sort;

    private String startTime;

    private String stopTime;

    private String timeTaken;

    private Integer failTimes;

}