package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbTestCase;
import com.platform.entity.domain.TbTestCaseDetail;
import com.platform.entity.vo.TestCaseDetailVo;
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
     * @param testCaseDetailVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/addTestCaseDetail")
    public Response<List<TbTestCaseDetail>> addTestCaseDetail(@RequestBody @Validated TestCaseDetailVo testCaseDetailVo) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.addTestCaseDetail(testCaseDetailVo));
    }

    /**
     * 根据id更新测试节点
     * @param testCaseDetailVo
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCaseDetailById")
    public Response<List<TbTestCaseDetail>> updateTestCaseDetailById(@RequestBody TestCaseDetailVo testCaseDetailVo) {
        if (testCaseDetailVo.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseDetailService.updateTestCaseDetailById(testCaseDetailVo));
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
