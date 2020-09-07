package com.c332030.web.servlet.util;

import javax.annotation.Nonnull;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Description: Cookies
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
public abstract class CookieUtils {

    /**
     * <p>
     * Description: 获取 Cookie
     * </p>
     *
     * @param request 请求
     * @param key 键
     * @return Cookie
     * @author c332030
     */
    public static Cookie getCookie(@Nonnull HttpServletRequest request, @Nonnull String key) {

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies) {
            if(key.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

    /**
     * <p>
     * Description: 获取 cookie 值
     * </p>
     *
     * @param request 请求
     * @param key 键
     * @return Cookie 值
     * @author c332030
     */
    public static String getCookieValue(@Nonnull HttpServletRequest request, @Nonnull String key) {
        Cookie cookie = getCookie(request, key);
        return null == cookie ? null : cookie.getValue();
    }

}
