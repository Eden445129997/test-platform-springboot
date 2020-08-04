package com.platform.entity.dto;

import com.platform.entity.domain.TbCheckPoint;
import lombok.Data;

import java.util.List;

@Data
public class TestCaseDto {
    /**
     * 关联的用例id
     */
    private Integer caseId;

    /**
     * 关联的接口id
     */
    private Integer interfaceId;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 资源路径
     */
    private String path;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 重联次数
     */
    private Integer reconnectionTimes;

    /**
     * 最长等待时长
     */
    private Integer waitTime;

    /**
     * 是否使用mock
     */
    private Boolean isMock;

    /**
     * 使用mock时的响应
     */
    private String mockResponse;

    /**
     * 是否使用参数化
     */
    private Boolean isExpression;

    /**
     * 请求头
     */
    private String headers;

    /**
     * url后的请求参数
     */
    private String params;

    /**
     * 请求体
     */
    private String data;

    /**
     * 测试节点描述
     */
    private String text;

    /**
     * 用例中节点的执行顺序
     */
    private Integer sort;

    /**
     * 检查点
     */
    private List<TbCheckPoint> tbCheckPointList;
}
