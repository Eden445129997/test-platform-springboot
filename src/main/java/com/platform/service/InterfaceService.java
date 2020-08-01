package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbInterface;
import com.platform.entity.vo.InterfaceVo;

public interface InterfaceService  extends IService<TbInterface> {

    PageResult<TbInterface> queryInterfaceByKeyword(InterfaceVo interfaceVo);

    boolean addInterface(InterfaceVo interfaceVo);

    boolean updateInterfaceById(InterfaceVo interfaceVo);

    boolean logicalDeleteInterface(Integer id);
}
