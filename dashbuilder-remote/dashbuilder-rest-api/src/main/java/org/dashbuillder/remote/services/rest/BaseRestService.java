package org.dashbuillder.remote.services.rest;oi

import org.jboss.resteasy.core.request.ServerDrivenNegotiation;

import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A parent class to all Rest Resources. It instrumentalizes the Resources with standartized methods to read and write the http headers...
 */
public abstract class BaseRestService {

    /**
     * Creates and returns a response with http code 200.
     * @param body
     * @return
     */
    protected Response createSuccessResponse(Object body, HttpHeaders headers){
        return Response.ok(body).header("Content-Type","application/json").build();
    }
}
