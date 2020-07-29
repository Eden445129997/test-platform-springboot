package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbInterfaceMapper;
import com.platform.entity.TbInterface;
import com.platform.form.InterfaceForm;
import com.platform.service.InterfaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InterfaceServiceImpl extends ServiceImpl<TbInterfaceMapper, TbInterface> implements InterfaceService {
    @Override
    public PageResult<TbInterface> queryInterfaceByKeyword(InterfaceForm interfaceForm) {
        QueryWrapper<TbInterface> queryWrapper = new QueryWrapper<>();
        if (interfaceForm.getProjectId() != null){
            queryWrapper.eq("project_id",interfaceForm.getProjectId());
        }
        if (interfaceForm.getBusiId() != null){
            queryWrapper.eq("busi_id",interfaceForm.getBusiId());
        }
        if (interfaceForm.getApiName() != null){
            queryWrapper.like("api_name",interfaceForm.getApiName());
        }
        if (interfaceForm.getMethod() != null){
            queryWrapper.eq("method",interfaceForm.getMethod());
        }
        if (interfaceForm.getPath() != null){
            queryWrapper.like("path",interfaceForm.getPath());
        }
        queryWrapper.eq("is_delete",false).orderByDesc("id");
        IPage<TbInterface> page = baseMapper.selectPage(new Page<>(interfaceForm.getPageIndex(), interfaceForm.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addInterface(InterfaceForm interfaceForm) {
        TbInterface tbInterface = new TbInterface();
        BeanUtils.copyProperties(interfaceForm, tbInterface);
        return this.save(tbInterface);
    }

    @Override
    public boolean updateInterfaceById(InterfaceForm interfaceForm) {
        TbInterface tbInterface = new TbInterface();
        BeanUtils.copyProperties(interfaceForm, tbInterface);
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
