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
// @ConfigurationProperties(prefix = "filter.cors")
public class CORSConfig {

    /**
     * 空配置
     */
    public static final CORSConfig EMPTY = new CORSConfig() {
        @Override
        public void setOrigins(List<String> origins) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setMethods(String methods) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setHeaders(String headers) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setCredentials(Boolean credentials) {
            throw new UnsupportedOperationException();
        }
    };

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
