package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestCaseMapper;
import com.platform.entity.TbTestCase;
import com.platform.form.TestCaseForm;
import com.platform.service.TestCaseService;
import org.springframework.beans.BeanUtils;

public class TestCaseServiceImpl extends ServiceImpl<TbTestCaseMapper, TbTestCase> implements TestCaseService {
    @Override
    public PageResult<TbTestCase> queryTestCaseByName(TestCaseForm testCaseForm) {
        QueryWrapper<TbTestCase> queryWrapper = new QueryWrapper<>();
        if (testCaseForm.getCaseName() != null){
            queryWrapper.like("case_name",testCaseForm.getCaseName());
        }
        queryWrapper.eq("status",true);
        IPage<TbTestCase> page = baseMapper.selectPage(new Page<>(testCaseForm.getPageIndex(), testCaseForm.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());    }

    @Override
    public boolean addTestCase(TestCaseForm testCaseForm) {
        TbTestCase tbTestCase = new TbTestCase();
        BeanUtils.copyProperties(testCaseForm, tbTestCase);
        return this.save(tbTestCase);
    }

    @Override
    public boolean updateTestCase(TestCaseForm testCaseForm) {
        TbTestCase tbTestCase = new TbTestCase();
        BeanUtils.copyProperties(testCaseForm, tbTestCase);
        return this.updateById(tbTestCase);
    }

    @Override
    public boolean logicalDeleteTestCase(Integer id) {
        return false;
    }
}
