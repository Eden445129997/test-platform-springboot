package com.platform;

import com.platform.dao.TbProjectMapper;
import com.platform.service.ProjectService;
import com.platform.service.TestCaseDetailService;
import com.platform.service.TestCaseService;
import com.platform.service.TestSuitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.platform.entity.domain.TbProject;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class serviceTest {

    @Resource
    TbProjectMapper tbProjectMapper;

    @Autowired
    ProjectService projectService;

    @Autowired
    TestCaseService testCaseService;

    @Autowired
    TestCaseDetailService testCaseDetailService;

    @Autowired
    TestSuitService testSuitService;

    @Test
    public void getTbProjectMapper() {
        List<TbProject> result;
        result =  tbProjectMapper.selectList(null);
        System.out.println(result);
    }

    /**
     * 打印测试套件中测试用例id的执行顺序
     */
    @Test
    public void queryTestCaseByPlanId() {
        List<Integer> orderList = testCaseService.TestSuitCaseOrder(1);
        System.out.println(orderList);
    }

    @Test
    public void getTestSuitByPlanId() {
        testSuitService.getTestSuitByPlanId(1);
    }

    @Test
    public void getTestSuitByCaseId() {
        testSuitService.getTestSuitByCaseId(1);
    }
}
