package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbInterfaceMapper;
import com.platform.entity.domain.TbInterface;
import com.platform.entity.vo.InterfaceVo;
import com.platform.service.InterfaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InterfaceServiceImpl extends ServiceImpl<TbInterfaceMapper, TbInterface> implements InterfaceService {
    @Override
    public PageResult<TbInterface> queryInterfaceByKeyword(InterfaceVo interfaceVo) {
        QueryWrapper<TbInterface> queryWrapper = new QueryWrapper<>();
        if (interfaceVo.getProjectId() != null){
            queryWrapper.eq("project_id", interfaceVo.getProjectId());
        }
        if (interfaceVo.getBusiId() != null){
            queryWrapper.eq("busi_id", interfaceVo.getBusiId());
        }
        if (interfaceVo.getApiName() != null){
            queryWrapper.like("api_name", interfaceVo.getApiName());
        }
        if (interfaceVo.getMethod() != null){
            queryWrapper.eq("method", interfaceVo.getMethod());
        }
        if (interfaceVo.getPath() != null){
            queryWrapper.like("path", interfaceVo.getPath());
        }
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");
        IPage<TbInterface> page = baseMapper.selectPage(new Page<>(interfaceVo.getPageIndex(), interfaceVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addInterface(InterfaceVo interfaceVo) {
        TbInterface tbInterface = new TbInterface();
        BeanUtils.copyProperties(interfaceVo, tbInterface);
        return this.save(tbInterface);
    }

    @Override
    public boolean updateInterfaceById(InterfaceVo interfaceVo) {
        TbInterface tbInterface = new TbInterface();
        BeanUtils.copyProperties(interfaceVo, tbInterface);
        return this.updateById(tbInterface);
    }

    @Override
    public boolean logicalDeleteInterface(Integer id) {
        TbInterface tbInterface = new TbInterface();
        tbInterface.setId(id);
        tbInterface.setIsDelete(true);
        return this.updateById(tbInterface);
    }
}
