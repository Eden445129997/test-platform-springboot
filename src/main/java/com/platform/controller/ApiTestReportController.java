package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbApiTestReport;
import com.platform.entity.vo.ApiTestReportVo;
import com.platform.service.ApiTestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiTestReportController {

    @Autowired
    ApiTestReportService apiTestReportService;

    /**
     * 查询测试报告列表（taskStatus）
     * @param apiTestReportVo
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryApiTestReportKeyword")
    public Response<List<TbApiTestReport>> queryApiTestReportKeyword(ApiTestReportVo apiTestReportVo){
        PageResult<TbApiTestReport> result;
        result = apiTestReportService.queryApiTestReportKeyword(apiTestReportVo);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 根据报告id逻辑删除测试报告
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE,value = "/logicalDeleteApiTestReport")
    public Response<TbApiTestReport> logicalDeleteApiTestReport(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),apiTestReportService.logicalDeleteApiTestReport(id));
    };
}
