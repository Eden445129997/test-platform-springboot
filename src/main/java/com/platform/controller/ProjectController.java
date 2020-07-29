package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.TbProject;
import com.platform.form.ProjectForm;
import com.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目
 */
@RestController
//@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * 根据（ 项目名、负责人 ）分页模糊查询
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryProjectByKeyword")
    public Response<List<TbProject>> queryProjectByKeyword(ProjectForm projectForm){
        PageResult<TbProject> result;
        result = projectService.queryProjectByKeyword(projectForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加项目
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addProject")
    public Response<TbProject> addProject(@RequestBody @Validated ProjectForm projectForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.addProject(projectForm));
    };

    /**
     * 根据id更新项目
     * @param projectForm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateProjectById")
    public Response<TbProject> updateProjectById(@RequestBody ProjectForm projectForm) {
        if (projectForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.updateProjectById(projectForm));
    };

    /**
     * 逻辑删除项目
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteProject")
    public Response<TbProject> logicalDeleteProject(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.logicalDeleteProject(id));
    };
}
