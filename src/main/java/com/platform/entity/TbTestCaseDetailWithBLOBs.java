package com.platform.entity;

import java.util.Date;

public class TbTestCaseDetailWithBLOBs extends TbTestCaseDetail {
    private String headers;

    private String data;

    private String mockResponse;

    public TbTestCaseDetailWithBLOBs(Integer id, String caseId, String interfaceId, Integer reconnectionTimes, Integer waitTime, Boolean mockStatus, String text, Integer sort, Boolean status, Date createTime, Date updateTime, Boolean expressionStatus, String headers, String data, String mockResponse) {
        super(id, caseId, interfaceId, reconnectionTimes, waitTime, mockStatus, text, sort, status, createTime, updateTime, expressionStatus);
        this.headers = headers;
        this.data = data;
        this.mockResponse = mockResponse;
    }

    public TbTestCaseDetailWithBLOBs() {
        super();
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers == null ? null : headers.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getMockResponse() {
        return mockResponse;
    }

    public void setMockResponse(String mockResponse) {
        this.mockResponse = mockResponse == null ? null : mockResponse.trim();
    }
}