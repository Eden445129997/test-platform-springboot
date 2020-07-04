package com.platform.entity;

import java.util.Date;

public class TbHost {
    private Integer id;

    private String projectId;

    private String hostName;

    private String host;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    public TbHost(Integer id, String projectId, String hostName, String host, String text, Boolean status, Date createTime, Date updateTime) {
        this.id = id;
        this.projectId = projectId;
        this.hostName = hostName;
        this.host = host;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbHost() {
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
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