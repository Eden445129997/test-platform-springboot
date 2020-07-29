package com.platform.service;

import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestPlan;
import com.platform.form.TestPlanForm;

public interface TestPlanService {
    PageResult<TbTestPlan> queryTestPlanByKeyword(TestPlanForm testPlanForm);

    boolean addTestPlan(TestPlanForm testPlanForm);

    boolean updateTestPlanById(TestPlanForm testPlanForm);

    boolean logicalDeleteTestPlan(Integer id);
}
