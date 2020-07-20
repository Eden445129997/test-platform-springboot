package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbProjectMapper;
import com.platform.entity.TbProject;
import com.platform.form.ProjectForm;
import com.platform.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.annotation.Resource;

@Service
@Transactional
public class ProjectServiceImpl extends ServiceImpl<TbProjectMapper,TbProject> implements ProjectService {

//    @Resource
//    TbProjectMapper tbProjectMapper;

    /**
     * 根据项目名称分页模糊查询
     *
     * @param projectForm
     */
    @Override
    public PageResult<TbProject> queryProjectByName(ProjectForm projectForm) {
        QueryWrapper<TbProject> queryWrapper = new QueryWrapper<>();
        if (projectForm.getProjectName() != null){
            queryWrapper.like("project_name",projectForm.getProjectName());
        }
        queryWrapper.eq("status",true);
        IPage<TbProject> page = baseMapper.selectPage(new Page<>(projectForm.getPageIndex(), projectForm.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addProject(ProjectForm projectForm) {
        TbProject tbProject = new TbProject();
        BeanUtils.copyProperties(projectForm, tbProject);
        return this.save(tbProject);
    }

    @Override
    public boolean updateProject(ProjectForm projectForm) {
        TbProject tbProject = new TbProject();
        BeanUtils.copyProperties(projectForm, tbProject);
        return this.updateById(tbProject);
    }

    @Override
    public boolean logicalDeleteProject(Integer id) {
        TbProject tbProject = new TbProject();
        tbProject.setId(id);
        tbProject.setStatus(false);
        return this.updateById(tbProject);
    }
}
