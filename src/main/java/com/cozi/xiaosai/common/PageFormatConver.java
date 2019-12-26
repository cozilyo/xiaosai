package com.cozi.xiaosai.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author xiaosai
 * @version 1.0
 * @date 2019-12-24 15:43
 * @describe
 */

public class PageFormatConver {

    private PageInfo<?> pageInfo;

    private Page<?> page;

    public PageFormatConver(PageInfo<?> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public PageFormatConver(Page<?> page) {
        this.page = page;
    }

    public PageFormatConver(PageInfo<?> pageInfo, Page<?> page) {
        this.pageInfo = pageInfo;
        this.page = page;
    }

    public R isOK(){
        return R.isOk().data(pageInfo.getList()).count(pageInfo.getTotal());
    }
}
