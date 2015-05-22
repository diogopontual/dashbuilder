package org.dashbuillder.remote.services.rest;

import org.dashbuilder.dataset.DataColumn;
import org.dashbuilder.dataset.DataSet;
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

    public Object toArray(DataSet dataSet){
        int rowsCount =  dataSet.getRowCount();
        List<DataColumn> columns = dataSet.getColumns();
        Object[][] result = new Object[rowsCount][columns.size()];
        for(int r = 0; r < rowsCount; r++){
            for(int c = 0; c < columns.size(); c++){
                result[r][c] = dataSet.getValueAt(r,c);
            }

        }
        return result;
    }
}
