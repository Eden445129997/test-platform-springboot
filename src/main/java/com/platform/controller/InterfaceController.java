package com.platform.controller;

import com.platform.common.Response;
import com.platform.common.dto.page.PageResult;
import com.platform.common.enums.ResStatus;
import com.platform.entity.TbInterface;
import com.platform.form.InterfaceForm;
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
     * 根据关键字获取接口（project_id、busi_id、api_name、method、path）
     * @param interfaceForm
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/queryInterfaceByKeyword")
    public Response<List<TbInterface>> queryInterfaceByKeyword(InterfaceForm interfaceForm){
        PageResult<TbInterface> result;
        result = interfaceService.queryInterfaceByKeyword(interfaceForm);
        return Response.success(ResStatus.SUCCESS.getMessage(),result.getResult(),result.getTotalElement());
    }

    /**
     * 添加接口数据
     * @param interfaceForm
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value ="/addInterface")
    public Response<TbInterface> addInterface(@RequestBody @Validated InterfaceForm interfaceForm) {
        return Response.success(ResStatus.SUCCESS.getMessage(),interfaceService.addInterface(interfaceForm));
    };

    /**
     * 根据id更新接口
     * @param interfaceForm
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/updateInterfaceById")
    public Response<TbInterface> updateInterfaceById(@RequestBody InterfaceForm interfaceForm) {
        if (interfaceForm.getId() == null) {
            return Response.error(ResStatus.PARAMETER_ERROR);
        }
        return Response.success(ResStatus.SUCCESS.getMessage(),interfaceService.updateInterfaceById(interfaceForm));
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
