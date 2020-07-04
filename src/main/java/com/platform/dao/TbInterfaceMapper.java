package com.platform.dao;

import com.platform.entity.TbInterface;

public interface TbInterfaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbInterface record);

    int insertSelective(TbInterface record);

    TbInterface selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbInterface record);

    int updateByPrimaryKeyWithBLOBs(TbInterface record);

    int updateByPrimaryKey(TbInterface record);
}