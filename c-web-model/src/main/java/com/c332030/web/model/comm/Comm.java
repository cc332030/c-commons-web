package com.c332030.web.model.comm;

import lombok.Data;

/**
 * <p>
 * Description: Comm
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public abstract class Comm<Head, Body> implements BaseComm {

    private static final long serialVersionUID = 8974401959929037178L;

    /**
     * 报文头
     */
    private Head head;

    /**
     * 报文体
     */
    private Body body;
}
