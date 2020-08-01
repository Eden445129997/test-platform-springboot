package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.domain.TbCheckPoint;
import com.platform.entity.vo.CheckpointVo;

import java.util.List;

public interface CheckpointService extends IService<TbCheckPoint> {

    PageResult<TbCheckPoint> queryCheckpointByCaseKeyword(CheckpointVo checkpointVo);

    List<TbCheckPoint> queryCheckpointByCaseDetailId(Integer caseDetailId);

    boolean addCheckpoint(CheckpointVo checkpointVo);

    boolean updateCheckpointById(CheckpointVo checkpointVo);

    boolean logicalDeleteCheckpoint(Integer id);
}
