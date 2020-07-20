package com.platform.common.dto.page;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: 分页结果
 * @author: 赵云
 * @create: 2019-08-10
 */
@Data
@Accessors(chain = true)
public class PageResult<R> {

    private Long totalElement;

    private R result;

}
