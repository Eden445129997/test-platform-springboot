package com.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestPlanMapper;
import com.platform.entity.TbTestPlan;
import com.platform.service.TestPlanService;

public class TestPlanServiceImpl extends ServiceImpl<TbTestPlanMapper, TbTestPlan> implements TestPlanService {
    @Override
    public PageResult<TbTestPlan> queryTestPlanByName() {
        return null;
    }

    @Override
    public boolean addTestPlan() {
        return false;
    }

    @Override
    public boolean updateTestPlan() {
        return false;
    }

    @Override
    public boolean logicalDeleteTestPlan(Integer id) {
        return false;
    }
}
