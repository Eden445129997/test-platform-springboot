package com.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platform.common.dto.page.PageResult;
import com.platform.dao.TbCheckpointMapper;
import com.platform.entity.domain.TbCheckPoint;
import com.platform.entity.vo.CheckpointVo;
import com.platform.service.CheckpointService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CheckpointServiceImpl extends ServiceImpl<TbCheckpointMapper, TbCheckPoint> implements CheckpointService {

    /**
     * 根据关键字查询校验点（用例节点id、校验方法）
     * @param checkpointVo
     * @return
     */
    @Override
    public PageResult<TbCheckPoint> queryCheckpointByCaseKeyword(CheckpointVo checkpointVo) {
        QueryWrapper<TbCheckPoint> queryWrapper = new QueryWrapper<>();
        if (checkpointVo.getCaseDetailId() != null){
            queryWrapper.eq("case_detail_id", checkpointVo.getCaseDetailId());
        }
        if (checkpointVo.getCheckMethod() != null){
            queryWrapper.eq("check_method", checkpointVo.getCheckMethod());
        }
        queryWrapper.eq("is_delete", false);
        IPage<TbCheckPoint> page = baseMapper.selectPage(new Page<>(checkpointVo.getPageIndex(), checkpointVo.getPageSize()),queryWrapper);
        return new PageResult().setResult(page.getRecords()).setTotalElement(page.getTotal());
    }

    /**
     * 查询所有校验点
     * @param caseDetailId
     * @return
     */
    @Override
    public List<TbCheckPoint> queryCheckpointByCaseDetailId(Integer caseDetailId) {
        QueryWrapper<TbCheckPoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("case_detail_id", caseDetailId).eq("is_delete", false).eq("is_status",true);
        List<TbCheckPoint> tbCheckPointList = baseMapper.selectList(queryWrapper);
        return tbCheckPointList;
    }

    @Override
    public boolean addCheckpoint(CheckpointVo checkpointVo) {
        TbCheckPoint tbCheckPoint = new TbCheckPoint();
        BeanUtils.copyProperties(checkpointVo, tbCheckPoint);
        return this.save(tbCheckPoint);
    }

    @Override
    public boolean updateCheckpointById(CheckpointVo checkpointVo) {
        TbCheckPoint tbCheckPoint = new TbCheckPoint();
        BeanUtils.copyProperties(checkpointVo, tbCheckPoint);
        return this.updateById(tbCheckPoint);
    }

    @Override
    public boolean logicalDeleteCheckpoint(Integer id) {
        TbCheckPoint tbCheckPoint = new TbCheckPoint();
        tbCheckPoint.setId(id);
        tbCheckPoint.setIsDelete(true);
        return this.updateById(tbCheckPoint);
    }
}
