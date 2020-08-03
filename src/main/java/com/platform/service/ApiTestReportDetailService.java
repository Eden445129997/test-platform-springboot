package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.entity.domain.TbApiTestReportDetail;

import java.util.List;

public interface ApiTestReportDetailService extends IService<TbApiTestReportDetail> {
    List<TbApiTestReportDetail> queryApiTestReportDetailKeyword(Integer reportId);

    boolean addApiTestReportDetail(TbApiTestReportDetail tbApiTestReportDetail);
}
