package com.platform.service;

import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestCase;
import com.platform.form.TestCaseForm;

public interface TestCaseService {
    PageResult<TbTestCase> queryTestCaseByName(TestCaseForm testCaseForm);

    boolean addTestCase(TestCaseForm testCaseForm);

    boolean updateTestCase(TestCaseForm testCaseForm);

    boolean logicalDeleteTestCase(Integer id);
}
