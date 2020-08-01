package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbTestCase;
import com.platform.entity.vo.TestCaseVo;

import java.util.List;

public interface TestCaseService extends IService<TbTestCase> {
    PageResult<TbTestCase> queryTestCasebyKeyword(TestCaseVo testCaseVo);

    List<Integer> TestSuitCaseOrder(Integer planId);

    boolean addTestCase(TestCaseVo testCaseVo);

    boolean updateTestCaseById(TestCaseVo testCaseVo);

    boolean logicalDeleteTestCase(Integer id);
}
