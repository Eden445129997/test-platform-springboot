package com.platform.service;

import com.platform.entity.dto.TestCaseDto;

import java.util.List;

public interface TestSuitService {
    public List<TestCaseDto> getTestSuitByPlanId(Integer planId);

    public List<TestCaseDto> getTestSuitByCaseId(Integer caseId);

    public List<TestCaseDto> builTestSuit(List<Integer> testSuitCaseOrderList);
}
