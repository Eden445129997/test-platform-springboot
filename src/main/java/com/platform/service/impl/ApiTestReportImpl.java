package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbApiTestReportMapper;
import com.platform.entity.domain.TbApiTestReport;
import com.platform.entity.vo.ApiTestReportVo;
import com.platform.service.ApiTestReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiTestReportImpl extends ServiceImpl<TbApiTestReportMapper, TbApiTestReport> implements ApiTestReportService {
    @Override
    public PageResult<TbApiTestReport> queryApiTestReportKeyword(ApiTestReportVo apiTestReportVo) {
        QueryWrapper<TbApiTestReport> queryWrapper = new QueryWrapper<>();
        if (apiTestReportVo.getTaskStatus() != null){
            queryWrapper.eq("task_status", apiTestReportVo.getTaskStatus());
        }
        queryWrapper.eq("is_delete", false);
        queryWrapper.orderByDesc("id");
        IPage<TbApiTestReport> page = baseMapper.selectPage(new Page<>(apiTestReportVo.getPageIndex(), apiTestReportVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public TbApiTestReport queryApiTestReportByReportId(Integer reportId) {
        QueryWrapper<TbApiTestReport> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("report_id", reportId);
        queryWrapper.eq("is_delete", false);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean addApiTestReport(TbApiTestReport tbApiTestReport) {
        return this.save(tbApiTestReport);
    }

    @Override
    public boolean updateApiTestReportById(TbApiTestReport tbApiTestReport) {
        return this.updateById(tbApiTestReport);
    }

    @Override
    public boolean logicalDeleteApiTestReport(Integer id) {
        TbApiTestReport tbApiTestReport = new TbApiTestReport();
        tbApiTestReport.setId(id);
        tbApiTestReport.setIsDelete(true);
        return this.updateById(tbApiTestReport);
    }


}
