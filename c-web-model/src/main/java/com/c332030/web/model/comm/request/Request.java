package com.c332030.web.model.comm.request;

import lombok.Data;

import com.c332030.web.model.comm.Comm;

/**
 * <p>
 * Description: Request
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public class Request<Body> extends Comm<RequestHead, Body> {

    private static final long serialVersionUID = -7748216950992508438L;
}
