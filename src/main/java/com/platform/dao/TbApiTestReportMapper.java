package com.platform.dao;

import com.platform.entity.TbApiTestReport;

public interface TbApiTestReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbApiTestReport record);

    int insertSelective(TbApiTestReport record);

    TbApiTestReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbApiTestReport record);

    int updateByPrimaryKey(TbApiTestReport record);
}