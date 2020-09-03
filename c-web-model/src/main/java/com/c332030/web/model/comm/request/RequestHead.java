package com.c332030.web.model.comm.request;

import lombok.Data;

import com.c332030.model.page.IPage;
import com.c332030.web.model.comm.CommHead;

/**
 * <p>
 * Description: RequestHead
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public class RequestHead extends CommHead implements IPage {

    private static final long serialVersionUID = 2347839652751266155L;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    /**
     * 排序
     */
    private String orderBy;
}
