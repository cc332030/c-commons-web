package com.c332030.web.model.comm.response;

import lombok.Data;

import com.c332030.web.model.comm.CommHead;

/**
 * <p>
 * Description: ResponseHead
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public class ResponseHead extends CommHead {

    private static final long serialVersionUID = 331615153926437324L;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回码
     */
    private String msg;
}
