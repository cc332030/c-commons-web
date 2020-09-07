package com.c332030.web.servlet.util;

import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.ImmutableList;

import com.c332030.util.collection.ArrayUtils;
import com.c332030.util.data.StringUtils;

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
    public static String getWebRoot(@Nonnull HttpServletRequest request) {

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
     * @author c332030
     */
    public static void setHeaders(
        @Nonnull HttpServletRequest request,
        @Nonnull URLConnection connection
    ) {
        request.getHeaderNames().asIterator().forEachRemaining((String headerName) ->
            setHeader(request, connection, headerName));
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
    public static void setHeaders(
        @Nonnull HttpServletRequest request,
        @Nonnull URLConnection connection,
        @Nonnull String... httpHeaders
    ) {
        if(ArrayUtils.isEmpty(httpHeaders)) {
            return;
        }

        for(String str: httpHeaders) {
            setHeader(request, connection, str);
        }
    }

    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param request 请求
     * @param connection 连接
     * @param httpHeaderName 请求头名称
     * @author c332030
     */
    public static void setHeader(
        @Nonnull HttpServletRequest request,
        @Nonnull URLConnection connection,
        @Nonnull String httpHeaderName
    ) {
        setHeader(request, connection, httpHeaderName, null);
    }

    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param request 请求
     * @param connection 连接
     * @param httpHeaderName 请求头名称
     * @param defaultValue 默认值
     * @author c332030
     */
    public static void setHeader(
        @Nonnull HttpServletRequest request,
        @Nonnull URLConnection connection,
        @Nonnull String httpHeaderName,
        String defaultValue
    ) {
        String value = request.getHeader(defaultValue);
        if(StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        connection.setRequestProperty(httpHeaderName, value);
    }


    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param connection 连接
     * @param response 响应
     * @author c332030
     */
    public static void setHeaders(
        @Nonnull URLConnection connection,
        @Nonnull HttpServletResponse response
    ) {
        Map<String, List<String>> map = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            response.setHeader(entry.getKey(), StringUtils.join(entry.getValue(), ';'));
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
    public static void setHeaders(
        @Nonnull URLConnection connection,
        @Nonnull HttpServletResponse response,
        @Nonnull String... httpHeaders
    ) {
        if(ArrayUtils.isEmpty(httpHeaders)) {
            return;
        }

        for(String str: httpHeaders) {
            response.setHeader(str, connection.getHeaderField(str));
        }
    }


    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param connection 连接
     * @param response 响应
     * @param httpHeaderName 请求头名称
     * @author c332030
     */
    public static void setHeader(
        @Nonnull URLConnection connection,
        @Nonnull HttpServletResponse response,
        @Nonnull String httpHeaderName
    ) {
        setHeader(connection, response, httpHeaderName, null);
    }

    /**
     * <p>
     * Description: 设置请求头
     * </p>
     *
     * @param connection 连接
     * @param response 响应
     * @param httpHeaderName 请求头名称
     * @param defaultValue 默认值
     * @author c332030
     */
    public static void setHeader(
        @Nonnull URLConnection connection,
        @Nonnull HttpServletResponse response,
        @Nonnull String httpHeaderName,
        String defaultValue
    ) {
        String value = connection.getHeaderField(defaultValue);
        if(StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        response.setHeader(httpHeaderName, value);
    }
}
