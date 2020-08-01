package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbTestCase;
import com.platform.entity.vo.TestCaseVo;
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
     * @param testCaseVo
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryTestCasebyKeyword")
    public Response<List<TbTestCase>> queryTestCasebyKeyword(TestCaseVo testCaseVo){
        PageResult<TbTestCase> result;
        result = testCaseService.queryTestCasebyKeyword(testCaseVo);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加测试用例
     * @param testCaseVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addTestCase")
    public Response<TbTestCase> addTestCase(@RequestBody @Validated TestCaseVo testCaseVo) {
        return Response.success(ResStatus.SUCCESS.getMessage(),testCaseService.addTestCase(testCaseVo));
    };

    /**
     * 根据id更新测试用例
     * @param testCaseFormm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateTestCaseById")
    public Response<TbTestCase> updateTestCaseById(@RequestBody TestCaseVo testCaseFormm) {
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
