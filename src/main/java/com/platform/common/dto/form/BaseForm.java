package com.platform.common.dto.form;

import com.platform.common.dto.page.BasePage;
import lombok.Data;

import java.util.Date;

@Data
public class BaseForm extends BasePage {

    private Integer id;

    private boolean status = true;

}
