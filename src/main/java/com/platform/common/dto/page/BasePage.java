package com.platform.common.dto.page;

import com.platform.common.utils.CamelUnderlineUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 分页基类
 */
public class BasePage {

    public final static Integer DEFAULT_PAGE_INDEX = 1;
    public final static Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 页码，默认是 1（pageIndex为负数则自动转为1）
     */
    private Integer pageIndex = DEFAULT_PAGE_INDEX;
    /**
     * 每页条数，默认是 10（pageSize为负数则不分页）
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 排序字段名
     * @ignore
     */
    private String sortName;
    /**
     * 排序类型（asc 或 desc）
     * @ignore
     */
    private String sortType;

    public void setPageIndex(Integer pageIndex) {
        if (null == pageIndex) {
            this.pageIndex = DEFAULT_PAGE_INDEX;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    public void setPageSize(Integer pageSize) {
        if (null == pageSize) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }
    /**
     * 设置不分页
     */
    public void setNoPage() {
        this.pageIndex = -1;
        this.pageSize = -1;
    }

    /**
     * 是否分页
     */
    public boolean isNoPage() {
        return this.pageIndex != null && this.pageIndex == -1
                && this.pageSize != null && this.pageSize == -1;
    }

    public void setSortName(String sortName) {
        // 驼峰转下划线
        if (StringUtils.isNotBlank(sortName)) {
            this.sortName = CamelUnderlineUtils.camelConvertToUnderline(sortName);
            return;
        }

        this.sortName = sortName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

}
