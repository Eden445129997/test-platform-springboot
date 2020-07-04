package com.platform.entity;

import java.util.Date;

public class TbCheckPoint {
    private Integer id;

    private String caseDetailId;

    private String checkObject;

    private String checkMethod;

    private String text;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private String checkValue;

    public TbCheckPoint(Integer id, String caseDetailId, String checkObject, String checkMethod, String text, Boolean status, Date createTime, Date updateTime, String checkValue) {
        this.id = id;
        this.caseDetailId = caseDetailId;
        this.checkObject = checkObject;
        this.checkMethod = checkMethod;
        this.text = text;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.checkValue = checkValue;
    }

    public TbCheckPoint() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseDetailId() {
        return caseDetailId;
    }

    public void setCaseDetailId(String caseDetailId) {
        this.caseDetailId = caseDetailId == null ? null : caseDetailId.trim();
    }

    public String getCheckObject() {
        return checkObject;
    }

    public void setCheckObject(String checkObject) {
        this.checkObject = checkObject == null ? null : checkObject.trim();
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod == null ? null : checkMethod.trim();
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

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue == null ? null : checkValue.trim();
    }
}