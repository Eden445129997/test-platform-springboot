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

/**
 * 测试用例节点
 */
@RestController
//@RequestMapping("/testCaseDetail")
public class TestCaseDetailController {

    @Autowired
    private TestCaseDetailService testCaseDetailService;

    /**
     * 根据测试用例id查询节点
     * @param caseId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryTestCaseDetailByCaseId")
    public Response<List<TbTestCaseDetail>> queryTestCaseDetailByCaseId(@RequestParam Integer caseId){
        PageResult<TbTestCaseDetail> result;
        result = testCaseDetailService.queryTestCaseDetailByCaseId(caseId);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加测试节点
     * @param testCaseDetailForm
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/addTestCaseDetail")
    public Response<List<TbTestCaseDetail>> addTestCaseDetail(@RequestBody @Validated TestCaseDetailForm testCaseDetailForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.addTestCaseDetail(testCaseDetailForm));
    }

    /**
     * 根据id更新测试节点
     * @param testCaseDetailForm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCaseDetailById")
    public Response<List<TbTestCaseDetail>> updateTestCaseDetailById(@RequestBody TestCaseDetailForm testCaseDetailForm) {
        if (testCaseDetailForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.updateTestCaseDetailById(testCaseDetailForm));
    }

    /**
     * 逻辑删除测试节点
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteTestCaseDetail")
    public Response<TbTestCase> logicalDeleteTestCaseDetail(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.logicalDeleteTestCaseDetail(id));
    };
}
