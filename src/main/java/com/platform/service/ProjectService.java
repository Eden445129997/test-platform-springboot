package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbProject;
import com.platform.form.ProjectForm;

public interface ProjectService extends IService<TbProject> {

    PageResult<TbProject> queryProjectByName(ProjectForm projectForm);

    boolean addProject(ProjectForm projectForm);

    boolean updateProject(ProjectForm projectForm);

    boolean logicalDeleteProject(Integer id);
}
