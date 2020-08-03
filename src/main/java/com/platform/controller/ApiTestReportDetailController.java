package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbApiTestReportDetail;
import com.platform.service.ApiTestReportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiTestReportDetailController {

    @Autowired
    ApiTestReportDetailService apiTestReportDetailService;

    /**
     * 根据报告id查询测试报告内容
     * @param reportId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryApiTestReportDetailKeyword")
    public Response<List<TbApiTestReportDetail>> queryApiTestReportDetailKeyword(@RequestParam Integer reportId){
        List<TbApiTestReportDetail> result;
        result = apiTestReportDetailService.queryApiTestReportDetailKeyword(reportId);
        return Response.success(ResStatus.SUCCESS.getMessage(),result);
    }
}
