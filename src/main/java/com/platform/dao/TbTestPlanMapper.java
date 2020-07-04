package com.platform.dao;

import com.platform.entity.TbTestPlan;

public interface TbTestPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTestPlan record);

    int insertSelective(TbTestPlan record);

    TbTestPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbTestPlan record);

    int updateByPrimaryKey(TbTestPlan record);
}