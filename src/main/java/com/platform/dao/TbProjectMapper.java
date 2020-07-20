package com.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platform.entity.TbProject;

import java.util.List;

public interface TbProjectMapper extends BaseMapper<TbProject> {

    public List<TbProject> queryProjectByName(String name);
}
