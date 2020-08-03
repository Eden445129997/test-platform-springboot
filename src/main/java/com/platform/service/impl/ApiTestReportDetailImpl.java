package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.dao.TbApiTestReportDetailMapper;
import com.platform.entity.domain.TbApiTestReportDetail;
import com.platform.service.ApiTestReportDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApiTestReportDetailImpl extends ServiceImpl<TbApiTestReportDetailMapper, TbApiTestReportDetail> implements ApiTestReportDetailService {
    @Override
    public List<TbApiTestReportDetail> queryApiTestReportDetailKeyword(Integer reportId) {
        QueryWrapper<TbApiTestReportDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete", false);
        queryWrapper.orderByAsc("id");
        List<TbApiTestReportDetail> tbApiTestReportDetails = baseMapper.selectList(queryWrapper);
        return tbApiTestReportDetails;
    }

    @Override
    public boolean addApiTestReportDetail(TbApiTestReportDetail tbApiTestReportDetail) {
        return this.save(tbApiTestReportDetail);
    }
}
