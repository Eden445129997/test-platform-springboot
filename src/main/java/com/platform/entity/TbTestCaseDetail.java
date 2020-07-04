package com.platform.entity;

import java.util.Date;

public class TbTestCaseDetail {
    private Integer id;

    private String caseId;

    private String interfaceId;

    private Integer reconnectionTimes;

    private Integer waitTime;

    private Boolean mockStatus;

    private String text;

    private Integer sort;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Boolean expressionStatus;

    public TbTestCaseDetail(Integer id, String caseId, String interfaceId, Integer reconnectionTimes, Integer waitTime, Boolean mockStatus, String text, Integer sort, Boolean status, Date createTime, Date updateTime, Boolean expressionStatus) {
        this.id = id;
        this.caseId = caseId;
        this.interfaceId = interfaceId;
        this.reconnectionTimes = reconnectionTimes;
        this.waitTime = waitTime;
        this.mockStatus = mockStatus;
        this.text = text;
        this.sort = sort;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expressionStatus = expressionStatus;
    }

    public TbTestCaseDetail() {
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

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId == null ? null : interfaceId.trim();
    }

    public Integer getReconnectionTimes() {
        return reconnectionTimes;
    }

    public void setReconnectionTimes(Integer reconnectionTimes) {
        this.reconnectionTimes = reconnectionTimes;
    }

    public Integer getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Integer waitTime) {
        this.waitTime = waitTime;
    }

    public Boolean getMockStatus() {
        return mockStatus;
    }

    public void setMockStatus(Boolean mockStatus) {
        this.mockStatus = mockStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Boolean getExpressionStatus() {
        return expressionStatus;
    }

    public void setExpressionStatus(Boolean expressionStatus) {
        this.expressionStatus = expressionStatus;
    }
}