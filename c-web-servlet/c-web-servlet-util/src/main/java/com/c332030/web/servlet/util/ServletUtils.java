package com.c332030.web.servlet.util;

import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.ImmutableList;

import com.c332030.util.collection.ArrayUtils;

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

    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param request 请求
     * @param connection 连接
     * @param httpHeaders 请求头集合
     * @author c332030
     */
    public static void setHeader(
        HttpServletRequest request,
        URLConnection connection,
        String... httpHeaders
    ) {
        if(ArrayUtils.isEmpty(httpHeaders)) {
            return;
        }

        for(String str: httpHeaders) {
            connection.setRequestProperty(str, request.getHeader(str));
        }
    }

    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param connection 连接
     * @param response 响应
     * @param httpHeaders 请求头集合
     * @author c332030
     */
    public static void setHeader(
        URLConnection connection,
        HttpServletResponse response,
        String... httpHeaders
    ) {
        if(ArrayUtils.isEmpty(httpHeaders)) {
            return;
        }

        for(String str: httpHeaders) {
            response.setHeader(str, connection.getHeaderField(str));
        }
    }
}
