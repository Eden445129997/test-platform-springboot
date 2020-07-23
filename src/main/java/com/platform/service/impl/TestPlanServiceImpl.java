package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestPlanMapper;
import com.platform.entity.TbTestPlan;
import com.platform.form.TestPlanForm;
import com.platform.service.TestPlanService;
import org.springframework.beans.BeanUtils;

public class TestPlanServiceImpl extends ServiceImpl<TbTestPlanMapper, TbTestPlan> implements TestPlanService {
    @Override
    public PageResult<TbTestPlan> queryTestPlanByName(TestPlanForm testPlanForm) {
        QueryWrapper<TbTestPlan> queryWrapper = new QueryWrapper<>();
        if (testPlanForm.getPlanName() != null){
            queryWrapper.like("plan_name",testPlanForm.getPlanName());
        }
        queryWrapper.eq("status",true);
        IPage<TbTestPlan> page = baseMapper.selectPage(new Page<>(testPlanForm.getPageIndex(), testPlanForm.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    @Override
    public boolean addTestPlan(TestPlanForm testPlanForm) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanForm, tbTestPlan);
        return this.save(tbTestPlan);
    }

    @Override
    public boolean updateTestPlan(TestPlanForm testPlanForm) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanForm, tbTestPlan);
        return this.updateById(tbTestPlan);
    }

    @Override
    public boolean logicalDeleteTestPlan(Integer id) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        tbTestPlan.setId(id);
        tbTestPlan.setStatus(false);
        return this.updateById(tbTestPlan);
    }
}
