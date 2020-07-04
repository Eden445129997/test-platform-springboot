package com.platform.entity;

import java.util.Date;

public class TbProject {
    private Integer id;

    private String projectName;

    private String text;

    private String projectLeader;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public TbProject(Integer id, String projectName, String text, String projectLeader, Boolean status, Date createTime, Date updateTime) {
        this.id = id;
        this.projectName = projectName;
        this.text = text;
        this.projectLeader = projectLeader;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbProject() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
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