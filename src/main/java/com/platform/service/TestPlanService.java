package com.platform.service;

import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestPlan;

public interface TestPlanService {
    PageResult<TbTestPlan> queryTestPlanByName();

    boolean addTestPlan();

    boolean updateTestPlan();

    boolean logicalDeleteTestPlan(Integer id);
}
