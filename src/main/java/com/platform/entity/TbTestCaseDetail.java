package com.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.platform.common.dto.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_test_case_detail")
public class TbTestCaseDetail extends BaseEntity implements Serializable {

    /**
     * 关联的用例id
     */
    private Integer caseId;

    /**
     * 关联的接口id
     */
    private Integer interfaceId;

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
    private String parames;

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
}
