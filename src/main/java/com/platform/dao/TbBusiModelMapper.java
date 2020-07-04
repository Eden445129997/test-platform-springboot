package com.platform.dao;

import com.platform.entity.TbBusiModel;

public interface TbBusiModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbBusiModel record);

    int insertSelective(TbBusiModel record);

    TbBusiModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbBusiModel record);

    int updateByPrimaryKey(TbBusiModel record);
}