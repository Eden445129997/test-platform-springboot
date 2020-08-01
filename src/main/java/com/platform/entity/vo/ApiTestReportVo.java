package com.platform.entity.vo;

import com.platform.common.dto.vo.BaseVo;
import lombok.Data;

@Data
public class ApiTestReportVo extends BaseVo {
    /**
     * 测试执行者
     */
    private String executor;

    /**
     * 通过用例数
     */
    private Integer passTotal;

    /**
     * 失败用例数
     */
    private Integer falseTotal;

    /**
     * 执行用例总数
     */
    private Integer total;

    /**
     * 报告状态
     */
    private String taskStatus;

    /**
     * 执行时长
     */
    private String timeTaken;

    /**
     * 访问的域名
     */
    private String host;
}
