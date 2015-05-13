package org.dashbuillder.remote.services.rest;

import org.junit.Test;


import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;

/**
 * Created by diogopontual on 12/05/15.
 */
public class RestUtilsTest {

    @Test
    public void testChooseResponseContentType() throws Exception {
        String url = "someResouce.xml?_contentType=xml";
        HttpHeaders headers = new HttpHeaders();
        headers.putRequestHeader(javax.ws.rs.core.HttpHeaders.ACCEPT, MediaType.APPLICATION_XML);
        headers.putRequestHeader(javax.ws.rs.core.HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        String[] MEDIA_TYPES = {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON};
        RestUtils.chooseResponseContentType(url,null,headers,MEDIA_TYPES);
    }
}