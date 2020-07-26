package com.platform.service;

import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestCase;
import com.platform.form.TestCaseForm;

import java.util.List;

public interface TestCaseService {
    PageResult<TbTestCase> queryTestCaseByName(TestCaseForm testCaseForm);

    List<TbTestCase> queryTestCaseByPlanId(Integer planId);

    boolean addTestCase(TestCaseForm testCaseForm);

    boolean updateTestCase(TestCaseForm testCaseForm);

    boolean logicalDeleteTestCase(Integer id);
}
