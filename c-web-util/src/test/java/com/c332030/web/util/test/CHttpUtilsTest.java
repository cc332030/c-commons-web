package com.c332030.web.util.test;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

import com.c332030.web.util.CHttpUtils;

/**
 * <p>
 * Description: ServletUtilsTest
 * </p>
 *
 * @author c332030
 * @version 1.0
 */
@Slf4j
public class CHttpUtilsTest {

    @Test
    public void urlEncodeTest() {

        var url = "http://work.c332030.com/PETOOLS.iso";
        var urlEncoded = CHttpUtils.urlEncode(url);

        log.info("urlEncoded: {}", urlEncoded);
    }

    @Test
    public void urlDecodeTest() {

        var urlEncoded = "http%3A%2F%2Fwork.c332030.com%2FPETOOLS.iso";
        var urlDecoded = CHttpUtils.urlDecode(urlEncoded);

        log.info("urlDecoded: {}", urlDecoded);
    }
}
