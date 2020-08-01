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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestPlanServiceImpl extends ServiceImpl<TbTestPlanMapper, TbTestPlan> implements TestPlanService {

    /**
     * 根据关键字查询测试计划
     * @param testPlanForm
     * @return
     */
    @Override
    public PageResult<TbTestPlan> queryTestPlanByKeyword(TestPlanForm testPlanForm) {
        QueryWrapper<TbTestPlan> queryWrapper = new QueryWrapper<>();
        if (testPlanForm.getProjectId() != null){
            queryWrapper.eq("project_id",testPlanForm.getProjectId());
        }
        if (testPlanForm.getPlanName() != null){
            queryWrapper.like("plan_name",testPlanForm.getPlanName());
        }
        queryWrapper.eq("is_delete",false).orderByDesc("id");
        IPage<TbTestPlan> page = baseMapper.selectPage(new Page<>(testPlanForm.getPageIndex(), testPlanForm.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    /**
     * 添加测试计划
     * @param testPlanForm
     * @return
     */
    @Override
    public boolean addTestPlan(TestPlanForm testPlanForm) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanForm, tbTestPlan);
        return this.save(tbTestPlan);
    }

    /**
     * 根据id更新测试计划
     * @param testPlanForm
     * @return
     */
    @Override
    public boolean updateTestPlanById(TestPlanForm testPlanForm) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanForm, tbTestPlan);
        return this.updateById(tbTestPlan);
    }

    /**
     * 逻辑删除测试计划
     * @param id
     * @return
     */
    @Override
    public boolean logicalDeleteTestPlan(Integer id) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        tbTestPlan.setId(id);
        tbTestPlan.setIsDelete(true);
        return this.updateById(tbTestPlan);
    }
}
