package com.platform.service.impl;

import com.platform.entity.domain.TbCheckPoint;
import com.platform.entity.domain.TbInterface;
import com.platform.entity.domain.TbTestCaseDetail;
import com.platform.entity.dto.TestCaseDto;
import com.platform.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TestSuitServiceImpl implements TestSuitService {

    @Autowired
    InterfaceService interfaceService;

    @Autowired
    TestCaseService testCaseService;

    @Autowired
    TestCaseDetailService testCaseDetailService;

    @Autowired
    CheckpointService checkpointService;

    /**
     * 根据测试计划id获取测试套件
     * @param planId
     * @return List<TestCaseDto>
     */
    @Override
    public List<TestCaseDto> getTestSuitByPlanId(Integer planId) {
        List<Integer> testSuitCaseOrderList;
        // 查询测试用例——套件执行顺序——caseId列表
        testSuitCaseOrderList = testCaseService.TestSuitCaseOrder(planId);
        return builTestSuit(testSuitCaseOrderList);
    }

    /**
     * 根据测试用例id获取测试套件
     * @param caseId
     * @return List<TestCaseDto>
     */
    @Override
    public List<TestCaseDto> getTestSuitByCaseId(Integer caseId) {
        List<Integer> testSuitCaseOrderList = new ArrayList<>();
        // 执行顺序列表
        testSuitCaseOrderList.add(caseId);
        return builTestSuit(testSuitCaseOrderList);
    }

    /**
     * 根据执行顺序创建测试套件
     * @param testSuitCaseOrderList
     * @return List<TestCaseDto>
     */
    @Override
    public List<TestCaseDto> builTestSuit(List<Integer> testSuitCaseOrderList) {
        List<TestCaseDto> testSuit = new ArrayList<>();;
        TestCaseDto testCaseDto;

        List<TbTestCaseDetail> testSuitCaseDetailOrder;
        List<TbCheckPoint> tbCheckPointList;
        TbInterface tbInterface;

        for (Integer caseId : testSuitCaseOrderList ) {
            // 查询测试用例节点——套件顺序——caseDetail列表
            testSuitCaseDetailOrder = testCaseDetailService.TestSuitCaseDetailOrder(caseId);
            for (TbTestCaseDetail tbTestCaseDetail : testSuitCaseDetailOrder ) {
                testCaseDto = new TestCaseDto();
                // 根据节点id查询所有检查点
                tbCheckPointList = checkpointService.queryCheckpointByCaseDetailId(tbTestCaseDetail.getId());
                // 根据接口id查询接口信息
                tbInterface = interfaceService.getById(tbTestCaseDetail.getInterfaceId());

                // 复制属性
                BeanUtils.copyProperties(tbTestCaseDetail, testCaseDto);
                testCaseDto.setTbCheckPointList(tbCheckPointList);
                BeanUtils.copyProperties(tbInterface, testCaseDto);

                //添加测试套件
                testSuit.add(testCaseDto);
            }
        }
        return testSuit;
    }
}
