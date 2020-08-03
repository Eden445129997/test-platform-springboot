package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbApiTestReport;
import com.platform.entity.vo.ApiTestReportVo;

public interface ApiTestReportService extends IService<TbApiTestReport> {
    PageResult<TbApiTestReport> queryApiTestReportKeyword(ApiTestReportVo apiTestReportVo);

    TbApiTestReport queryApiTestReportByReportId(Integer reportId);

    boolean addApiTestReport(TbApiTestReport tbApiTestReport);

    boolean updateApiTestReportById(TbApiTestReport tbApiTestReport);

    boolean logicalDeleteApiTestReport(Integer id);
}
