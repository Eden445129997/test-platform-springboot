package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.BasePage;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestCaseDetailMapper;
import com.platform.entity.TbTestCaseDetail;
import com.platform.form.TestCaseDetailForm;
import com.platform.service.TestCaseDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestCaseDetailServiceImpl extends ServiceImpl<TbTestCaseDetailMapper, TbTestCaseDetail> implements TestCaseDetailService {

    @Override
    public PageResult<TbTestCaseDetail> queryTestCaseDetailByCaseId(Integer caseId) {
        QueryWrapper<TbTestCaseDetail> queryWrapper = new QueryWrapper<>();
        BasePage basePage = new BasePage();
        queryWrapper.eq("case_id", caseId).eq("is_delete", false).eq("is_status", true);
        queryWrapper.orderByDesc("sort").orderByAsc("id");
        IPage<TbTestCaseDetail> page = baseMapper.selectPage(new Page<>(basePage.getPageIndex(), basePage.getPageSize()), queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addTestCaseDetail(TestCaseDetailForm testCaseDetailForm) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        // 插入数据的默认值
        if (testCaseDetailForm.getReconnectionTimes() == null) {
            testCaseDetailForm.setReconnectionTimes(3);
        }
        if (testCaseDetailForm.getWaitTime() == null) {
            testCaseDetailForm.setWaitTime(10);
        }
        if (testCaseDetailForm.getIsMock() == null) {
            testCaseDetailForm.setIsMock(false);
        }
        if (testCaseDetailForm.getMockResponse() == null) {
            testCaseDetailForm.setMockResponse("{}");
        }
        if (testCaseDetailForm.getIsExpression() == null) {
            testCaseDetailForm.setIsExpression(false);
        }
        if (testCaseDetailForm.getHeaders() == null) {
            testCaseDetailForm.setHeaders("{}");
        }
        if (testCaseDetailForm.getParames() == null) {
            testCaseDetailForm.setParames("{}");
        }
        if (testCaseDetailForm.getData() == null) {
            testCaseDetailForm.setData("{}");
        }
        BeanUtils.copyProperties(testCaseDetailForm, tbTestCaseDetail);
        tbTestCaseDetail.setSort(0);
        return this.save(tbTestCaseDetail);
    }

    @Override
    public boolean updateTestCaseDetail(TestCaseDetailForm testCaseDetailForm) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        BeanUtils.copyProperties(testCaseDetailForm, tbTestCaseDetail);
        return this.updateById(tbTestCaseDetail);
    }

    @Override
    public boolean logicalDeleteTestCaseDetail(Integer id) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        tbTestCaseDetail.setId(id);
        tbTestCaseDetail.setIsDelete(true);
        return this.updateById(tbTestCaseDetail);    }
}
