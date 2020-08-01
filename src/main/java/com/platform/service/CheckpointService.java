package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.dto.page.PageResult;
import com.platform.entity.TbCheckPoint;
import com.platform.form.CheckpointForm;

import java.util.List;

public interface CheckpointService extends IService<TbCheckPoint> {

    PageResult<TbCheckPoint> queryCheckpointByCaseKeyword(CheckpointForm checkpointForm);

    List<TbCheckPoint> queryCheckpointByCaseDetailId(Integer caseDetailId);

    boolean addCheckpoint(CheckpointForm checkpointForm);

    boolean updateCheckpointById(CheckpointForm checkpointForm);

    boolean logicalDeleteCheckpoint(Integer id);
}
