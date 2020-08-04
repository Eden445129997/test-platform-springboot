package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbTestCaseMapper;
import com.platform.entity.domain.TbTestCase;
import com.platform.entity.vo.TestCaseVo;
import com.platform.service.TestCaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TestCaseServiceImpl extends ServiceImpl<TbTestCaseMapper, TbTestCase> implements TestCaseService {

    /**
     * 测试套件执行排序规则(sort倒序，id生序)
     * @param queryWrapper
     * @return
     */
    public void Collation(QueryWrapper<TbTestCase> queryWrapper) {
        queryWrapper.orderByDesc("sort").orderByAsc("id");
    }

    /**
     * 根据计划名称获取测试用例
     * 分页：selectPage
     * 排序：创建时间倒序排序
     */
    @Override
    public PageResult<TbTestCase> queryTestCasebyKeyword(TestCaseVo testCaseVo) {
        QueryWrapper<TbTestCase> queryWrapper = new QueryWrapper<>();
        if (testCaseVo.getPlanId() != null) {
            queryWrapper.eq("plan_id", testCaseVo.getPlanId());
        }
        if (testCaseVo.getCaseName() != null){
            queryWrapper.like("case_name", testCaseVo.getCaseName());
        }
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("id");
        IPage<TbTestCase> page = baseMapper.selectPage(new Page<>(testCaseVo.getPageIndex(), testCaseVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    /**
     * 根据计划id获取所有测试用例
     * 排序：根据sort倒序排序，id正序排序
     */
    @Override
    public List<Integer> TestSuitCaseOrder(Integer planId) {
        QueryWrapper<TbTestCase> queryWrapper = new QueryWrapper<>();
        List<Integer> orderTestCaseIdListOrder = new ArrayList();
        // 查询id
        queryWrapper.select("id");
        queryWrapper.eq("plan_id", planId).eq("is_delete", false).eq("is_status", true);
        this.Collation(queryWrapper);
        List<TbTestCase> tbTestCaseList = baseMapper.selectList(queryWrapper);
        // 装进list
        for (TbTestCase tbTestCase : tbTestCaseList ) {
            orderTestCaseIdListOrder.add(tbTestCase.getId());
        }
        return orderTestCaseIdListOrder;
    }

    @Override
    public boolean addTestCase(TestCaseVo testCaseVo) {
        TbTestCase tbTestCase = new TbTestCase();
        BeanUtils.copyProperties(testCaseVo, tbTestCase);
        tbTestCase.setSort(0);
        return this.save(tbTestCase);
    }

    @Override
    public boolean updateTestCaseById(TestCaseVo testCaseVo) {
        TbTestCase tbTestCase = new TbTestCase();
        BeanUtils.copyProperties(testCaseVo, tbTestCase);
        return this.updateById(tbTestCase);
    }

    @Override
    public boolean logicalDeleteTestCase(Integer id) {
        TbTestCase tbTestCase = new TbTestCase();
        tbTestCase.setId(id);
        tbTestCase.setIsDelete(true);
        return this.updateById(tbTestCase);
    }
}
