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

/**
 * 测试计划
 */
@RestController
//@RequestMapping("/project")
public class TestPlanController {

    @Autowired
    private TestPlanService testPlanService;

    /**
     * 根据（ 关联的项目id、测试计划名称 ）查询测试计划
     * @param testPlanForm
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryTestPlanByKeyword")
    public Response<List<TbTestPlan>> queryTestPlanByName(TestPlanForm testPlanForm){
        PageResult<TbTestPlan> result;
        result = testPlanService.queryTestPlanByKeyword(testPlanForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加测试计划
     * @param testPlanForm
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addTestPlan")
    public Response<TbTestPlan> addTestPlan(@RequestBody @Validated TestPlanForm testPlanForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.addTestPlan(testPlanForm));
    };

    /**
     * 根据id更新测试计划
     * @param testPlanForm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestPlanById")
    public Response<TbTestPlan> updateTestPlanById(@RequestBody TestPlanForm testPlanForm) {
        if (testPlanForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.updateTestPlanById(testPlanForm));
    };

    /**
     * 逻辑删除测试计划
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestPlan")
    public Response<TbTestPlan> logicalDeleteTestPlan(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testPlanService.logicalDeleteTestPlan(id));
    };
}
