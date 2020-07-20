package com.platform;

import com.platform.dao.TbProjectMapper;
import com.platform.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.platform.entity.TbProject;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class daoTest {

    @Resource
    TbProjectMapper tbProjectMapper;

    @Autowired
    ProjectService projectService;

    @Test
    public void getTbProjectMapper() {
        List<TbProject> result;
        result =  tbProjectMapper.selectList(null);
        System.out.println(result);
    }
}
