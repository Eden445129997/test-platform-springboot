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

@RestController
//@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET,value = "/queryProjectByName")
    public Response<List<TbProject>> queryProjectByName(ProjectForm projectForm){
        PageResult<TbProject> result;
        result = projectService.queryProjectByName(projectForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    @RequestMapping(method = RequestMethod.POST, value ="/addProject")
    public Response<TbProject> addProject(@RequestBody @Validated ProjectForm projectForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.addProject(projectForm));
    };

    @RequestMapping(method = RequestMethod.PUT, value ="/updateProject")
    public Response<TbProject> updateProject(@RequestBody ProjectForm projectForm) {
        if (projectForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.updateProject(projectForm));
    };

    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteProject")
    public Response<TbProject> logicalDeleteProject(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),projectService.logicalDeleteProject(id));
    };
}
