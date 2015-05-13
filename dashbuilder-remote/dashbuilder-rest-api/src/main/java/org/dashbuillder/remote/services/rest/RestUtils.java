package org.dashbuillder.remote.services.rest;

import org.apache.commons.lang3.StringUtils;
import org.restlet.engine.header.ContentType;
import org.restlet.engine.header.ContentTypeReader;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by diogopontual on 11/05/15.
 */
public abstract class RestUtils {

    /**
     * Apply the following rules to choose which of the availableMediaTypes should be user to respond:
     * <ol>
     * <li>URL suffix (xml or json);</li>
     * <li>_contentType queryString parameter;</li>
     * <li>Request ACCEPT header;</li>
     * </ol>
     *
     */
    public static void chooseResponseContentType(String url, Map<String,String> queryStringParams, HttpHeaders headers,String[] availableMediaTypes) {
        List<String> acceptHeader = headers.getRequestHeader(HttpHeaders.ACCEPT);
        for (String acceptHeaderLine : acceptHeader) {
            String[] splitted = StringUtils.split(acceptHeaderLine, ',');
            for(String entry : splitted){
                System.out.println(entry);
            }
        }

    }
}
