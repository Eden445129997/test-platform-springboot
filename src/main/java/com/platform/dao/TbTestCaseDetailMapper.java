package com.platform.dao;

import com.platform.entity.TbTestCaseDetail;
import com.platform.entity.TbTestCaseDetailWithBLOBs;

public interface TbTestCaseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbTestCaseDetailWithBLOBs record);

    int insertSelective(TbTestCaseDetailWithBLOBs record);

    TbTestCaseDetailWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbTestCaseDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbTestCaseDetailWithBLOBs record);

    int updateByPrimaryKey(TbTestCaseDetail record);
}