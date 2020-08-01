package com.platform.entity.domain;

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

    /**
     * 用例id
     */
    private Integer caseId;

    /**
     * 关联的报告id
     */
    private Integer reportId;

    /**
     * 接口名
     */
    private String apiName;

    /**
     * 请求的url
     */
    private String url;

    /**
     * 请求头
     */
    private String header;

    /**
     * 请求体
     */
    private String data;

    /**
     * 响应体
     */
    private String response;

    /**
     * 错误日志
     */
    private String errorRecord;

    /**
     * 是否mock
     */
    private Boolean isMock;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String stopTime;

    /**
     * 执行时长
     */
    private String timeTaken;

    /**
     * 失败次数
     */
    private Integer failTimes;

}