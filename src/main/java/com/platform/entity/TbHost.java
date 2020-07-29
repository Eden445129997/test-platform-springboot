package com.platform.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_host")
public class TbHost {

    /**
     * 关联的项目id
     */
    private Integer projectId;

    /**
     * 域名昵称
     */
    private String hostName;

    /**
     * 域名
     */
    private String host;

    /**
     * 域名描述
     */
    private String text;

}