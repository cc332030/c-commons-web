package com.c332030.web.servlet.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.ImmutableList;

/**
 * <p>
 * Description: ServletUtils
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public abstract class ServletUtils {

    private static final List<Integer> HTTP_PORTS = ImmutableList.of(80, 443);

    /**
     * 获取 网站路径
     * @param request HttpServletRequest
     * @return 网站路径
     */
    public static String getWebRoot(HttpServletRequest request) {

        StringBuilder ab = new StringBuilder(request.getScheme());

        ab.append("://");
        ab.append(request.getServerName());

        int port = request.getServerPort();
        if(!HTTP_PORTS.contains(port)) {
            ab.append(":");
            ab.append(request.getServerPort());
        }

        ab.append(request.getContextPath());

        return ab.toString();
    }
}
