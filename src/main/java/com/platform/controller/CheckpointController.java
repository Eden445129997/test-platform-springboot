package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbCheckPoint;
import com.platform.entity.vo.CheckpointVo;
import com.platform.service.CheckpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 校验点
 */
@RestController
public class CheckpointController {

    @Autowired
    private CheckpointService checkpointService;

    /**
     * 根据关键字查询校验点（用例节点id、校验方法）
     * @param checkpointVo
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryCheckpointByCaseKeyword")
    public Response<List<TbCheckPoint>> queryCheckpointByCaseKeyword(CheckpointVo checkpointVo){
        PageResult<TbCheckPoint> result;
        result = checkpointService.queryCheckpointByCaseKeyword(checkpointVo);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加检查点
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addCheckpoint")
    public Response<TbCheckPoint> addCheckpoint(@RequestBody @Validated CheckpointVo checkpointVo) {
        return Response.success(ResStatus.SUCCESS.getMessage(),checkpointService.addCheckpoint(checkpointVo));
    };

    /**
     * 根据id修改检查点
     * @param checkpointVo
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateCheckpointById")
    public Response<TbCheckPoint> updateCheckpointById(@RequestBody CheckpointVo checkpointVo) {
        if (checkpointVo.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),checkpointService.updateCheckpointById(checkpointVo));
    };

    /**
     * 逻辑删除校验点
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteCheckpoint")
    public Response<TbCheckPoint> logicalDeleteCheckpoint(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),checkpointService.logicalDeleteCheckpoint(id));
    };
}
