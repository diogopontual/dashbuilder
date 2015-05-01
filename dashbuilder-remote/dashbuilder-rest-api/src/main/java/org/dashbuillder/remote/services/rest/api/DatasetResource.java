package org.dashbuillder.remote.services.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by diogopontual on 30/04/15.
 */
@Path("/dataset")
public class DatasetResource {

    @GET
    public String get(){
        return "It is working!!! Great!!!";
    }
}
