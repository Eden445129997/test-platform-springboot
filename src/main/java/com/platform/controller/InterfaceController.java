package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.domain.TbInterface;
import com.platform.entity.vo.InterfaceVo;
import com.platform.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口
 */
@RestController
public class InterfaceController {

    @Autowired
    private InterfaceService interfaceService;

    /**
     * 根据关键字获取接口（projectId、busiId、apiName、method、path）
     * @param interfaceVo
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryInterfaceByKeyword")
    public Response<List<TbInterface>> queryInterfaceByKeyword(InterfaceVo interfaceVo){
        PageResult<TbInterface> result;
        result = interfaceService.queryInterfaceByKeyword(interfaceVo);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加接口数据
     * @param interfaceVo
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addInterface")
    public Response<TbInterface> addInterface(@RequestBody @Validated InterfaceVo interfaceVo) {
        return Response.success(ResStatus.SUCCESS.getMessage(),interfaceService.addInterface(interfaceVo));
    };

    /**
     * 根据id更新接口
     * @param interfaceVo
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateInterfaceById")
    public Response<TbInterface> updateInterfaceById(@RequestBody InterfaceVo interfaceVo) {
        if (interfaceVo.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),interfaceService.updateInterfaceById(interfaceVo));
    };

    /**
     * 逻辑删除接口
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value ="/logicalDeleteInterface")
    public Response<TbInterface> logicalDeleteInterface(@RequestParam Integer id) {
        return Response.success(ResStatus.SUCCESS.getMessage(),interfaceService.logicalDeleteInterface(id));
    };
}
