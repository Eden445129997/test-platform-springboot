package com.platform.entity;

import java.util.Date;

public class TbTestPlan {
    private Integer id;

    private String projectId;

    private String planName;

    private String creater;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public TbTestPlan(Integer id, String projectId, String planName, String creater, String text, Boolean status, Date createTime, Date updateTime) {
        this.id = id;
        this.projectId = projectId;
        this.planName = planName;
        this.creater = creater;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbTestPlan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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
}