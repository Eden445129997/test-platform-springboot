package com.platform.entity;

import java.util.Date;

public class TbTestCase {
    private Integer id;

    private String planId;

    private String caseName;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Integer sort;

    public TbTestCase(Integer id, String planId, String caseName, String text, Boolean status, Date createTime, Date updateTime, Integer sort) {
        this.id = id;
        this.planId = planId;
        this.caseName = caseName;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sort = sort;
    }

    public TbTestCase() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}