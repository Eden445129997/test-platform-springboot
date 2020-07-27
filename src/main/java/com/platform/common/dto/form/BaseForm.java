package com.platform.common.dto.form;

import com.platform.common.dto.page.BasePage;
import lombok.Data;

@Data
public class BaseForm extends BasePage {

    private Integer id;

    private boolean isStatus;

//    private boolean isDelete;
}
