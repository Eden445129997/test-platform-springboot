package com.platform;

import com.power.common.enums.HttpCodeEnum;
import com.power.common.util.DateTimeUtil;
import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.builder.HtmlApiDocBuilder;
import com.power.doc.constants.DocGlobalConstants;
import com.power.doc.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class smartDoc {

    /**
     * 访问地址：
     * 生成后可以通过浏览器打开src/main/resources/static/doc/api.htmlHTML页面
     * 或者是启动Spring Boot服务访问http://localhost:8080/doc/api.html 接口文档
     * 如果采用AllInOne模式生成的文档，则访问http://localhost:8080/doc/index.html
     * 修改服务配置：
     * 如果Spring Boot服务配置了spring.resources.add-mappings=false
     * 那么服务器将不会处理静态资源， smart-doc生成的html静态api文档也就不能访问，此时只需要将配置改为true即可。
     * 当然这种配置最好放入配置中心， 真正的生产服务器如果不希望暴露接口文档可以直接设置为false关闭文档。
     */
    @Test
    public void testBuilderControllersApi() {
        ApiConfig config = new ApiConfig();
        config.setServerUrl("http://localhost:8080");

        //设置为严格模式，Smart-doc将降至要求每个Controller暴露的接口写上标准文档注释
        config.setStrict(false);

        //当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);

        //HTML5文档，建议直接放到src/main/resources/static/doc下，Smart-doc提供一个配置常量HTML_DOC_OUT_PATH
        config.setOutPath(DocGlobalConstants.HTML_DOC_OUT_PATH);

        // 设置接口包扫描路径过滤，如果不配置则Smart-doc默认扫描所有的接口类
        // 配置多个报名有英文逗号隔开
        config.setPackageFilters("com.platform.controller");

        //设置公共请求头.如果不需要请求头，则无需设置
//        config.setRequestHeaders(
//                ApiReqHeader.header().setName("access_token").setType("string")
//                        .setDesc("Basic auth credentials").setRequired(true).setSince("v1.1.0"),
//                ApiReqHeader.header().setName("user_uuid").setType("string").setDesc("User Uuid key")
//        );

        //设置错误错列表，遍历自己的错误码设置给Smart-doc即可
        List<ApiErrorCode> errorCodeList = new ArrayList<>();
        for (HttpCodeEnum codeEnum : HttpCodeEnum.values()) {
            ApiErrorCode errorCode = new ApiErrorCode();
            errorCode.setValue(codeEnum.getCode()).setDesc(codeEnum.getMessage());
            errorCodeList.add(errorCode);
        }
        //不需要显示错误码,则可以不用设置错误码。
        config.setErrorCodes(errorCodeList);

        //1.7.9 优化了错误码处理，用于下面替代遍历枚举设置错误码
        //不需在文档中展示错误码则可以不设置。
        config.setErrorCodeDictionaries(
                ApiErrorCodeDictionary.dict().setEnumClass(HttpCodeEnum.class)
                        .setCodeField("code") //错误码值字段名
                        .setDescField("desc")//错误码描述
        );



        //设置文档变更记录，没有需要可以不设置
//        config.setRevisionLogs(
//                RevisionLog.getLog().setRevisionTime("2018/12/15").setAuthor("chen").setRemarks("test").setStatus("create").setVersion("V1.0"),
//                RevisionLog.getLog().setRevisionTime("2018/12/16").setAuthor("chen2").setRemarks("test2").setStatus("update").setVersion("V2.0")
//        );

        long start = System.currentTimeMillis();
        //生成HTML5文件
        HtmlApiDocBuilder.buildApiDoc(config);
        //since 1.8.1版本开始入口方法有变更
        HtmlApiDocBuilder.buildApiDoc(config);
        long end = System.currentTimeMillis();
        DateTimeUtil.printRunTime(end, start);
    }
}
