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

    private String projectId;

    private String hostName;

    private String host;

    private String text;

    private Boolean status;
}