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
     * <p>Apply the following rules to choose which of the enabledContentTypes should be used to respond:</p>
     * <ol>
     * <li>URL suffix (xml or json);</li>
     * <li>Request ACCEPT header;</li>
     * <li>_contentType queryString parameter;</li>
     * </ol>
     */
    public static String chooseResponseContentType(HttpHeaders headers,String[] enabledContentTypes) throws NoSuitableContentTypeException{
        List<String> acceptHeader = headers.getRequestHeader(HttpHeaders.ACCEPT);
        for (String acceptHeaderLine : acceptHeader) {
            String[] splitted = StringUtils.split(acceptHeaderLine, ',');
            for(String entry : splitted){
                for(String enabled : enabledContentTypes) {
                    if (entry.trim().toLowerCase().indexOf(enabled) == 0){
                        return entry;
                    }
                }
            }
        }
        throw new NoSuitableContentTypeException();
    }
}
