package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbInterface;
import com.platform.form.InterfaceForm;

public interface InterfaceService  extends IService<TbInterface> {

    PageResult<TbInterface> queryInterfaceByKeyword(InterfaceForm interfaceForm);

    boolean addInterface(InterfaceForm interfaceForm);

    boolean updateInterfaceById(InterfaceForm interfaceForm);

    boolean logicalDeleteInterface(Integer id);
}
