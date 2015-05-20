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
        HttpHeaders headers = new HttpHeaders();
        headers.putRequestHeader(javax.ws.rs.core.HttpHeaders.ACCEPT, MediaType.APPLICATION_XML);
        headers.putRequestHeader(javax.ws.rs.core.HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
        String[] MEDIA_TYPES = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON};
        try {
            String chosenType = RestUtils.chooseResponseContentType(headers, MEDIA_TYPES);
            assertEquals("The type should be ", chosenType, MediaType.APPLICATION_XML);
        } catch (NoSuitableContentTypeException nsctex) {
            nsctex.printStackTrace();
        }
    }
}