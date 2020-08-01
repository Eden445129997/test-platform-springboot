package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbTestCaseDetail;
import com.platform.form.TestCaseDetailForm;

public interface TestCaseDetailService extends IService<TbTestCaseDetail> {

    PageResult<TbTestCaseDetail> queryTestCaseDetailByCaseId(Integer caseId);

    boolean addTestCaseDetail(TestCaseDetailForm testCaseDetailForm);

    boolean updateTestCaseDetailById(TestCaseDetailForm testCaseDetailForm);

    boolean logicalDeleteTestCaseDetail(Integer id);
}
