package org.dashbuillder.remote.services.rest;

import org.apache.commons.lang3.StringUtils;
import org.restlet.engine.header.ContentType;
import org.restlet.engine.header.ContentTypeReader;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by diogopontual on 11/05/15.
 */
public abstract class RestUtils {
    public static final String[] MEDIA_TYPES = {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON};


    /**
     * Apply the following rules to choose the right response content type:
     * <ol>
     * <li>URL suffix (xml or json);</li>
     * <li>_contentType queryString parameter;</li>
     * <li>Request ACCEPT header;</li>
     * </ol>
     *
     * @param headers
     */
    public void chooseResponseContentType(HttpHeaders headers) {
        List<String> acceptHeader = headers.getRequestHeader(HttpHeaders.ACCEPT);
        for (String acceptHeaderLine : acceptHeader) {
            String[] splitted = StringUtils.split(acceptHeaderLine, ',');
            for(String entry : splitted){

            }
        }

    }
}
