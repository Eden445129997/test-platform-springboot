package com.platform.entity;

import java.util.Date;

public class TbApiTestReport {
    private Integer id;

    private String executor;

    private Integer passTotal;

    private Integer falseTotal;

    private Integer total;

    private String taskStatus;

    private Date createTime;

    private Date updateTime;

    private String timeTaken;

    private String host;

    public TbApiTestReport(Integer id, String executor, Integer passTotal, Integer falseTotal, Integer total, String taskStatus, Date createTime, Date updateTime, String timeTaken, String host) {
        this.id = id;
        this.executor = executor;
        this.passTotal = passTotal;
        this.falseTotal = falseTotal;
        this.total = total;
        this.taskStatus = taskStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.timeTaken = timeTaken;
        this.host = host;
    }

    public TbApiTestReport() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor == null ? null : executor.trim();
    }

    public Integer getPassTotal() {
        return passTotal;
    }

    public void setPassTotal(Integer passTotal) {
        this.passTotal = passTotal;
    }

    public Integer getFalseTotal() {
        return falseTotal;
    }

    public void setFalseTotal(Integer falseTotal) {
        this.falseTotal = falseTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
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

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken == null ? null : timeTaken.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }
}