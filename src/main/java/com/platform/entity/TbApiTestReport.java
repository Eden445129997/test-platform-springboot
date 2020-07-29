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
@TableName("tb_api_test_report")
public class TbApiTestReport extends BaseEntity implements Serializable {

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