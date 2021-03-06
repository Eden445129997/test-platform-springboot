package com.platform.common.dto.vo;

import com.platform.common.dto.page.BasePage;
import lombok.Data;

@Data
public class BaseVo extends BasePage {

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 是否启用，默认true（true：启用，false：不启用）
     */
    private boolean isStatus;

//    private boolean isDelete;
}
