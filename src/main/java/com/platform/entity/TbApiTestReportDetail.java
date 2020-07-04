package com.platform.entity;

import java.util.Date;

public class TbApiTestReportDetail {
    private Integer id;

    private String caseId;

    private String reportId;

    private Boolean isMock;

    private Integer sort;

    private String startTime;

    private String stopTime;

    private String timeTaken;

    private Date createTime;

    private Date updateTime;

    private Integer failTimes;

    private String apiName;

    private String url;

    public TbApiTestReportDetail(Integer id, String caseId, String reportId, Boolean isMock, Integer sort, String startTime, String stopTime, String timeTaken, Date createTime, Date updateTime, Integer failTimes, String apiName, String url) {
        this.id = id;
        this.caseId = caseId;
        this.reportId = reportId;
        this.isMock = isMock;
        this.sort = sort;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.timeTaken = timeTaken;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.failTimes = failTimes;
        this.apiName = apiName;
        this.url = url;
    }

    public TbApiTestReportDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public Boolean getIsMock() {
        return isMock;
    }

    public void setIsMock(Boolean isMock) {
        this.isMock = isMock;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime == null ? null : stopTime.trim();
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken == null ? null : timeTaken.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}