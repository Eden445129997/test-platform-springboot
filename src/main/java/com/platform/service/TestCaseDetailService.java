package com.platform.service;

import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestCaseDetail;
import com.platform.form.TestCaseDetailForm;

public interface TestCaseDetailService {

    PageResult<TbTestCaseDetail> queryTestCaseDetailByCaseId(Integer caseId);

    boolean addTestCaseDetail(TestCaseDetailForm testCaseDetailForm);

    boolean updateTestCaseDetail(TestCaseDetailForm testCaseDetailForm);

    boolean logicalDeleteTestCaseDetail(Integer id);
}
