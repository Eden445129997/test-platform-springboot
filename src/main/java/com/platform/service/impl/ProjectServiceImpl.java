package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbProjectMapper;
import com.platform.entity.domain.TbProject;
import com.platform.entity.vo.ProjectVo;
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
     * @param projectVo
     */
    @Override
    public PageResult<TbProject> queryProjectByKeyword(ProjectVo projectVo) {
        QueryWrapper<TbProject> queryWrapper = new QueryWrapper<>();
        if (projectVo.getProjectName() != null){
            queryWrapper.like("project_name", projectVo.getProjectName());
        }
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");
        IPage<TbProject> page = baseMapper.selectPage(new Page<>(projectVo.getPageIndex(), projectVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addProject(ProjectVo projectVo) {
        TbProject tbProject = new TbProject();
        BeanUtils.copyProperties(projectVo, tbProject);
        return this.save(tbProject);
    }

    @Override
    public boolean updateProjectById(ProjectVo projectVo) {
        TbProject tbProject = new TbProject();
        BeanUtils.copyProperties(projectVo, tbProject);
        return this.updateById(tbProject);
    }

    @Override
    public boolean logicalDeleteProject(Integer id) {
        TbProject tbProject = new TbProject();
        tbProject.setId(id);
        tbProject.setIsDelete(true);
        return this.updateById(tbProject);
    }
}
