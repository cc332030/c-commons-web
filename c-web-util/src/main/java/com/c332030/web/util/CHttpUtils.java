package com.c332030.web.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.commons.collections4.MapUtils;

import com.c332030.util.asserts.CAssert;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: HttpUtils
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CHttpUtils {

    public static final String MARK_QUESTION = "?";

    public static final String MARK_AND = "&";

    public static final String MARK_EQUALS = "=";

    /**
     * <p>
     * Description: 链接加上时间戳避免缓存
     * </p>
     *
     * @param url 链接
     * @return 带时间戳的链接
     * @author c332030
     */
    public static String getUrlWithTimestamp(String url) {

        CAssert.notNull(url);

        var mills = System.currentTimeMillis();

        if(url.contains(MARK_QUESTION)) {
            return url + MARK_AND + mills + MARK_EQUALS;
        }

        return url + MARK_QUESTION + mills + MARK_EQUALS;
    }

    /**
     * <p>
     * Description: 获取带参数的链接
     * </p>
     *
     * @param url 链接
     * @param key 键
     * @param value 值
     * @return 带参数的链接
     * @author c332030
     */
    public static String getUrl(String url, String key, String value){
        return url + MARK_QUESTION + key + MARK_EQUALS + urlEncode(value) ;
    }

    /**
     * <p>
     * Description: 获取带参数的链接
     * </p>
     *
     * @param url 链接
     * @param params 参数集合
     * @return 带参数的链接
     * @author c332030
     */
    public static String getUrl(String url, Map<String, String> params){

        if(MapUtils.isEmpty(params)) {
            return url;
        }

        var entrySet = params.entrySet();

        var iterator =  entrySet.iterator();

        var urlBuilder = new StringBuilder(url);

        var first = iterator.next();
        urlBuilder.append(MARK_QUESTION);
        urlBuilder.append(first.getKey());
        urlBuilder.append(MARK_EQUALS);
        urlBuilder.append(urlEncode(first.getValue()));

        while (iterator.hasNext()) {

            var entry = iterator.next();
            urlBuilder.append(MARK_AND);
            urlBuilder.append(entry.getKey());
            urlBuilder.append(MARK_EQUALS);
            urlBuilder.append(urlEncode(entry.getValue()));
        }

        return urlBuilder.toString();
    }

    /**
     * <p>
     * Description: 链接转码
     * </p>
     *
     * @param str 链接
     * @return 转码后的链接
     * @author c332030
     */
    public static String urlEncode(String str){
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    /**
     * <p>
     * Description: 链接解码
     * </p>
     *
     * @param str 链接
     * @return 解码后的链接
     * @author c332030
     */
    public static String urlDecode(String str){
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

}
