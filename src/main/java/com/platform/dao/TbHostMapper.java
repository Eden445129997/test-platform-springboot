package com.platform.dao;

import com.platform.entity.TbHost;

public interface TbHostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbHost record);

    int insertSelective(TbHost record);

    TbHost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbHost record);

    int updateByPrimaryKey(TbHost record);
}