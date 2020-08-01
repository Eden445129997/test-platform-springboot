package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestCase;
import com.platform.form.TestCaseForm;

import java.util.List;

public interface TestCaseService extends IService<TbTestCase> {
    PageResult<TbTestCase> queryTestCasebyKeyword(TestCaseForm testCaseForm);

    List<Integer> TestSuitCaseOrder(Integer planId);

    boolean addTestCase(TestCaseForm testCaseForm);

    boolean updateTestCaseById(TestCaseForm testCaseForm);

    boolean logicalDeleteTestCase(Integer id);
}
