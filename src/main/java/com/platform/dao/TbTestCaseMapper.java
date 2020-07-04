package com.platform.dao;

import com.platform.entity.TbTestCase;

public interface TbTestCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTestCase record);

    int insertSelective(TbTestCase record);

    TbTestCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbTestCase record);

    int updateByPrimaryKey(TbTestCase record);
}