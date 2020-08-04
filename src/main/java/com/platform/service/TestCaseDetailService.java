package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbTestCaseDetail;
import com.platform.entity.vo.TestCaseDetailVo;

import java.util.List;

public interface TestCaseDetailService extends IService<TbTestCaseDetail> {

    PageResult<TbTestCaseDetail> queryTestCaseDetailByCaseId(Integer caseId);

    List<TbTestCaseDetail> TestSuitCaseDetailOrder(Integer caseId);

    boolean addTestCaseDetail(TestCaseDetailVo testCaseDetailVo);

    boolean updateTestCaseDetailById(TestCaseDetailVo testCaseDetailVo);

    boolean logicalDeleteTestCaseDetail(Integer id);
}
