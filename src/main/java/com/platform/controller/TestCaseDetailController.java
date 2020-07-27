package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.TbTestCase;
import com.platform.entity.TbTestCaseDetail;
import com.platform.form.TestCaseDetailForm;
import com.platform.service.TestCaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/testCaseDetail")
public class TestCaseDetailController {

    @Autowired
    private TestCaseDetailService testCaseDetailService;

    @RequestMapping(method = RequestMethod.GET,value = "/queryTestCaseDetailByCaseId")
    public Response<List<TbTestCaseDetail>> queryTestCaseDetailByCaseId(@RequestParam Integer caseId){
        PageResult<TbTestCaseDetail> result;
        result = testCaseDetailService.queryTestCaseDetailByCaseId(caseId);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addTestCaseDetail")
    public Response<List<TbTestCaseDetail>> addTestCaseDetail(@RequestBody @Validated TestCaseDetailForm testCaseDetailForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.addTestCaseDetail(testCaseDetailForm));
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCaseDetail")
    public Response<List<TbTestCaseDetail>> updateTestCaseDetail(@RequestBody @Validated TestCaseDetailForm testCaseDetailForm) {
        if (testCaseDetailForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.updateTestCaseDetail(testCaseDetailForm));
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestCaseDetail")
    public Response<TbTestCase> logicalDeleteTestCase(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.logicalDeleteTestCaseDetail(id));
    };
}
