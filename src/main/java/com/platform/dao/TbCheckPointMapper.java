package com.platform.dao;

import com.platform.entity.TbCheckPoint;

public interface TbCheckPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCheckPoint record);

    int insertSelective(TbCheckPoint record);

    TbCheckPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCheckPoint record);

    int updateByPrimaryKeyWithBLOBs(TbCheckPoint record);

    int updateByPrimaryKey(TbCheckPoint record);
}