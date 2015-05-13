package org.dashbuillder.remote.services.rest;

import org.jboss.resteasy.core.request.ServerDrivenNegotiation;

import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A parent class to all Rest Resources. It instrumentalizes the Resources with standardized methods to read and write the http headers...
 */
public abstract class BaseRestService {
    public static final String[] MEDIA_TYPES = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON};


    /**
     * Creates and returns a response with http code 200.
     *
     * @param body
     * @return
     */
    protected Response createSuccessResponse(Object body, HttpHeaders headers) throws NoSuitableContentTypeException{
        List<String> accept = headers.getRequestHeader(HttpHeaders.ACCEPT);
        for (String s : accept) {
            System.out.println(s);
        }
        return Response.ok(body).header("Content-Type", RestUtils.chooseResponseContentType(headers, MEDIA_TYPES)).build();
    }
}
