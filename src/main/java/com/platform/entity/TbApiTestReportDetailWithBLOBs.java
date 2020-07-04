package com.platform.entity;

import java.util.Date;

public class TbApiTestReportDetailWithBLOBs extends TbApiTestReportDetail {
    private String header;

    private String data;

    private String response;

    private String errorRecord;

    public TbApiTestReportDetailWithBLOBs(Integer id, String caseId, String reportId, Boolean isMock, Integer sort, String startTime, String stopTime, String timeTaken, Date createTime, Date updateTime, Integer failTimes, String apiName, String url, String header, String data, String response, String errorRecord) {
        super(id, caseId, reportId, isMock, sort, startTime, stopTime, timeTaken, createTime, updateTime, failTimes, apiName, url);
        this.header = header;
        this.data = data;
        this.response = response;
        this.errorRecord = errorRecord;
    }

    public TbApiTestReportDetailWithBLOBs() {
        super();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getErrorRecord() {
        return errorRecord;
    }

    public void setErrorRecord(String errorRecord) {
        this.errorRecord = errorRecord == null ? null : errorRecord.trim();
    }
}