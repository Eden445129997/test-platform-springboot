package com.platform.common.utils;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;

/**
 * 驼峰法和下划线 工具类
 *
 * @author lingyuwang
 * @date 2020-01-16 11:59
 * @since 1.0.4
 */
@Slf4j
public class CamelUnderlineUtils {

    private CamelUnderlineUtils() {}

    /**
     * 下划线转驼峰
     *
     * @param underline
     * @return java.lang.String
     * @author lingyuwang
     * @date 2020-01-16 12:02
     * @since 1.0.4
     */
    public static String underlineConvertToCamel(String underline){
        if (underline == null) {
            return null;
        }

        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, underline);
    }

    /**
     * 驼峰转下划线
     *
     * @param camel
     * @return java.lang.String
     * @author lingyuwang
     * @date 2020-01-16 12:03
     * @since 1.0.4
     */
    public static String camelConvertToUnderline(String camel){
        if (camel == null) {
            return null;
        }

        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, camel);
    }

}