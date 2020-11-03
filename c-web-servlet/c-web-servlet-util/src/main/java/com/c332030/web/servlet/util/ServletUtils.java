package com.c332030.web.servlet.util;

import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;

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
        request.getHeaderNames().asIterator()
            .forEachRemaining((headerName) -> setHeader(request, connection, headerName));
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

        Arrays.stream(httpHeaders)
            .forEach(httpHeader -> setHeader(request, connection, httpHeader));
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

        if(StringUtils.isEmpty(httpHeaderName)) {
            return;
        }

        String value = request.getHeader(httpHeaderName);
        if(StringUtils.isEmpty(value)) {
            if(StringUtils.isEmpty(defaultValue)) {
                return;
            }
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
        connection.getHeaderFields()
            .forEach((key, value) -> {
                if(StringUtils.isEmpty(key) || CollectionUtils.isEmpty(value)) {
                    return;
                }
                response.setHeader(key, StringUtils.join(value, ';'));
            });
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

        Arrays.stream(httpHeaders).forEach(httpHeader -> {
            if(StringUtils.isEmpty(httpHeader)) {
                return;
            }
            String value = connection.getHeaderField(httpHeader);
            if(StringUtils.isEmpty(value)) {
                return;
            }

            response.setHeader(httpHeader, value);
        });
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
        if(StringUtils.isEmpty(httpHeaderName)) {
            return;
        }
        String value = connection.getHeaderField(httpHeaderName);
        if(StringUtils.isEmpty(value)) {
            if(StringUtils.isEmpty(defaultValue)) {
                return;
            }
            value = defaultValue;
        }
        response.setHeader(httpHeaderName, value);
    }
}
