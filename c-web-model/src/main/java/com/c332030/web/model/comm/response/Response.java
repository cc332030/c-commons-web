package com.c332030.web.model.comm.response;

import lombok.Data;

import com.c332030.web.model.comm.Comm;

/**
 * <p>
 * Description: Response
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public class Response<Body> extends Comm<ResponseHead, Body> {

    private static final long serialVersionUID = -5073797024036401566L;
}
