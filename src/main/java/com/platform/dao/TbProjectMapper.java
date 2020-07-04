package com.platform.dao;

import com.platform.entity.TbProject;

public interface TbProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbProject record);

    int insertSelective(TbProject record);

    TbProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbProject record);

    int updateByPrimaryKey(TbProject record);
}