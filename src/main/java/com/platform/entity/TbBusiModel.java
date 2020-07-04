package com.platform.entity;

import java.util.Date;

public class TbBusiModel {
    private Integer id;

    private String projectId;

    private String busiName;

    private Integer total;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public TbBusiModel(Integer id, String projectId, String busiName, Integer total, String text, Boolean status, Date createTime, Date updateTime) {
        this.id = id;
        this.projectId = projectId;
        this.busiName = busiName;
        this.total = total;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbBusiModel() {
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

    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName == null ? null : busiName.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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