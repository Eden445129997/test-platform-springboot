package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestPlanMapper;
import com.platform.entity.domain.TbTestPlan;
import com.platform.entity.vo.TestPlanVo;
import com.platform.service.TestPlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestPlanServiceImpl extends ServiceImpl<TbTestPlanMapper, TbTestPlan> implements TestPlanService {

    /**
     * 根据关键字查询测试计划
     * @param testPlanVo
     * @return
     */
    @Override
    public PageResult<TbTestPlan> queryTestPlanByKeyword(TestPlanVo testPlanVo) {
        QueryWrapper<TbTestPlan> queryWrapper = new QueryWrapper<>();
        if (testPlanVo.getProjectId() != null){
            queryWrapper.eq("project_id", testPlanVo.getProjectId());
        }
        if (testPlanVo.getPlanName() != null){
            queryWrapper.like("plan_name", testPlanVo.getPlanName());
        }
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");
        IPage<TbTestPlan> page = baseMapper.selectPage(new Page<>(testPlanVo.getPageIndex(), testPlanVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    /**
     * 添加测试计划
     * @param testPlanVo
     * @return
     */
    @Override
    public boolean addTestPlan(TestPlanVo testPlanVo) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanVo, tbTestPlan);
        return this.save(tbTestPlan);
    }

    /**
     * 根据id更新测试计划
     * @param testPlanVo
     * @return
     */
    @Override
    public boolean updateTestPlanById(TestPlanVo testPlanVo) {
        TbTestPlan tbTestPlan = new TbTestPlan();
        BeanUtils.copyProperties(testPlanVo, tbTestPlan);
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
