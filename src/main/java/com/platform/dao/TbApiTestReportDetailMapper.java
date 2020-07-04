package com.platform.dao;

import com.platform.entity.TbApiTestReportDetail;
import com.platform.entity.TbApiTestReportDetailWithBLOBs;

public interface TbApiTestReportDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbApiTestReportDetailWithBLOBs record);

    int insertSelective(TbApiTestReportDetailWithBLOBs record);

    TbApiTestReportDetailWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbApiTestReportDetailWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TbApiTestReportDetailWithBLOBs record);

    int updateByPrimaryKey(TbApiTestReportDetail record);
}