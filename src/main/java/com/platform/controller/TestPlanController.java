package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.TbTestPlan;
import com.platform.form.TestPlanForm;
import com.platform.service.TestPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/project")
public class TestPlanController {

    @Autowired
    private TestPlanService testPlanService;

    @RequestMapping(method = RequestMethod.GET,value = "/queryTestPlanByName")
    public Response<List<TbTestPlan>> queryTestPlanByName(TestPlanForm testPlanForm){
        PageResult<TbTestPlan> result;
        result = testPlanService.queryTestPlanByName(testPlanForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    @RequestMapping(method = RequestMethod.POST, value ="/addTestPlan")
    public Response<TbTestPlan> addTestPlan(@RequestBody @Validated TestPlanForm testPlanForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.addTestPlan(testPlanForm));
    };

    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestPlan")
    public Response<TbTestPlan> updateTestPlan(@RequestBody TestPlanForm testPlanForm) {
        if (testPlanForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.updateTestPlan(testPlanForm));
    };

    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestPlan")
    public Response<TbTestPlan> logicalDeleteTestPlan(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.logicalDeleteTestPlan(id));
    };
}
