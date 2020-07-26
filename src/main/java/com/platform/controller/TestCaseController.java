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

@RestController
//@RequestMapping("/project")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @RequestMapping(method = RequestMethod.GET,value = "/queryTestCaseByName")
    public Response<List<TbTestCase>> queryTestCaseByName(TestCaseForm testCaseForm){
        PageResult<TbTestCase> result;
        result = testCaseService.queryTestCaseByName(testCaseForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    @RequestMapping(method = RequestMethod.POST, value ="/addTestCase")
    public Response<TbTestCase> addTestCase(@RequestBody @Validated TestCaseForm testCaseForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.addTestCase(testCaseForm));
    };

    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCase")
    public Response<TbTestCase> updateTestCase(@RequestBody TestCaseForm testCaseFormm) {
        if (testCaseFormm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.updateTestCase(testCaseFormm));
    };

    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestCase")
    public Response<TbTestCase> logicalDeleteTestCase(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.logicalDeleteTestCase(id));
    };
}
