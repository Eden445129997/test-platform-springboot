package com.platform.entity;

import java.util.Date;

public class TbInterface {
    private Integer id;

    private String projectId;

    private String busiId;

    private String apiName;

    private String method;

    private String path;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private String defaultData;

    public TbInterface(Integer id, String projectId, String busiId, String apiName, String method, String path, String text, Boolean status, Date createTime, Date updateTime, String defaultData) {
        this.id = id;
        this.projectId = projectId;
        this.busiId = busiId;
        this.apiName = apiName;
        this.method = method;
        this.path = path;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.defaultData = defaultData;
    }

    public TbInterface() {
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

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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

    public String getDefaultData() {
        return defaultData;
    }

    public void setDefaultData(String defaultData) {
        this.defaultData = defaultData == null ? null : defaultData.trim();
    }
}