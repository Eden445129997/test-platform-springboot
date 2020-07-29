package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.TbTestCase;
import com.platform.form.TestCaseForm;
import com.platform.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试用例
 */
@RestController
//@RequestMapping("/project")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    /**
     * 根据（测试计划id、测试用例名称）查询测试用例
     * @param testCaseForm
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryTestCasebyKeyword")
    public Response<List<TbTestCase>> queryTestCasebyKeyword(TestCaseForm testCaseForm){
        PageResult<TbTestCase> result;
        result = testCaseService.queryTestCasebyKeyword(testCaseForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加测试用例
     * @param testCaseForm
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addTestCase")
    public Response<TbTestCase> addTestCase(@RequestBody @Validated TestCaseForm testCaseForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.addTestCase(testCaseForm));
    };

    /**
     * 根据id更新测试用例
     * @param testCaseFormm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCaseById")
    public Response<TbTestCase> updateTestCaseById(@RequestBody TestCaseForm testCaseFormm) {
        if (testCaseFormm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.updateTestCaseById(testCaseFormm));
    };

    /**
     * 逻辑删除测试用例
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestCase")
    public Response<TbTestCase> logicalDeleteTestCase(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.logicalDeleteTestCase(id));
    };
}
