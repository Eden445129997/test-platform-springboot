package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbProject;
import com.platform.entity.vo.ProjectVo;

public interface ProjectService extends IService<TbProject> {

    PageResult<TbProject> queryProjectByKeyword(ProjectVo projectVo);

    boolean addProject(ProjectVo projectVo);

    boolean updateProjectById(ProjectVo projectVo);

    boolean logicalDeleteProject(Integer id);
}
