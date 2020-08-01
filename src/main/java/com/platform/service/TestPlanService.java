package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbTestPlan;
import com.platform.entity.vo.TestPlanVo;

public interface TestPlanService extends IService<TbTestPlan> {
    PageResult<TbTestPlan> queryTestPlanByKeyword(TestPlanVo testPlanVo);

    boolean addTestPlan(TestPlanVo testPlanVo);

    boolean updateTestPlanById(TestPlanVo testPlanVo);

    boolean logicalDeleteTestPlan(Integer id);
}
