package com.c332030.web.util.test;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

import com.c332030.web.util.HttpUtils;

/**
 * <p>
 * Description: ServletUtilsTest
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Slf4j
public class HttpUtilsTest {

    @Test
    public void urlEncodeTest() {

        String url = "http://work.c332030.com/PETOOLS.iso";
        String urlEncoded = HttpUtils.urlEncode(url);

        log.info("urlEncoded: {}", urlEncoded);
    }

    @Test
    public void urlDecodeTest() {

        String urlEncoded = "http%3A%2F%2Fwork.c332030.com%2FPETOOLS.iso";
        String urlDecoded = HttpUtils.urlDecode(urlEncoded);

        log.info("urlDecoded: {}", urlDecoded);
    }
}
