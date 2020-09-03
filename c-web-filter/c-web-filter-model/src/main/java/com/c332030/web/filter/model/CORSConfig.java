package com.c332030.web.filter.model;

import java.util.List;

import lombok.Data;

/**
 * <p>
 * Description: CORSConfig
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Data
public class CORSConfig {

    /**
     * origin 请求源
     */
    private List<String> origins;

    /**
     * origin 请求方式
     */
    private String methods;

    /**
     * origin 请求头
     */
    private String headers;

    /**
     * origin cookies 支持
     */
    private Boolean credentials;
}
