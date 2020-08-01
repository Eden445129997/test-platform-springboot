package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.BasePage;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestCaseDetailMapper;
import com.platform.entity.domain.TbTestCaseDetail;
import com.platform.entity.vo.TestCaseDetailVo;
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
        queryWrapper.eq("case_id", caseId).eq("is_delete", false);
        queryWrapper.orderByDesc("sort").orderByAsc("id");
        IPage<TbTestCaseDetail> page = baseMapper.selectPage(new Page<>(basePage.getPageIndex(), basePage.getPageSize()), queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addTestCaseDetail(TestCaseDetailVo testCaseDetailVo) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        // 插入数据的默认值
        if (testCaseDetailVo.getReconnectionTimes() == null) {
            testCaseDetailVo.setReconnectionTimes(3);
        }
        if (testCaseDetailVo.getWaitTime() == null) {
            testCaseDetailVo.setWaitTime(10);
        }
        if (testCaseDetailVo.getIsMock() == null) {
            testCaseDetailVo.setIsMock(false);
        }
        if (testCaseDetailVo.getMockResponse() == null) {
            testCaseDetailVo.setMockResponse("{}");
        }
        if (testCaseDetailVo.getIsExpression() == null) {
            testCaseDetailVo.setIsExpression(false);
        }
        if (testCaseDetailVo.getHeaders() == null) {
            testCaseDetailVo.setHeaders("{}");
        }
        if (testCaseDetailVo.getParames() == null) {
            testCaseDetailVo.setParames("{}");
        }
        if (testCaseDetailVo.getData() == null) {
            testCaseDetailVo.setData("{}");
        }
        BeanUtils.copyProperties(testCaseDetailVo, tbTestCaseDetail);
        tbTestCaseDetail.setSort(0);
        return this.save(tbTestCaseDetail);
    }

    @Override
    public boolean updateTestCaseDetailById(TestCaseDetailVo testCaseDetailVo) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        BeanUtils.copyProperties(testCaseDetailVo, tbTestCaseDetail);
        return this.updateById(tbTestCaseDetail);
    }

    @Override
    public boolean logicalDeleteTestCaseDetail(Integer id) {
        TbTestCaseDetail tbTestCaseDetail = new TbTestCaseDetail();
        tbTestCaseDetail.setId(id);
        tbTestCaseDetail.setIsDelete(true);
        return this.updateById(tbTestCaseDetail);    }
}
