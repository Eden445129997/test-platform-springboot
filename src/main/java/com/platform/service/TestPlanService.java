package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestPlan;
import com.platform.form.TestPlanForm;

public interface TestPlanService extends IService<TbTestPlan> {
    PageResult<TbTestPlan> queryTestPlanByKeyword(TestPlanForm testPlanForm);

    boolean addTestPlan(TestPlanForm testPlanForm);

    boolean updateTestPlanById(TestPlanForm testPlanForm);

    boolean logicalDeleteTestPlan(Integer id);
}
