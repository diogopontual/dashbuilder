package org.dashbuillder.remote.services.rest.api;


import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.DataSetFactory;
import org.dashbuilder.dataset.DataSetManager;
import org.dashbuilder.dataset.DataSetMetadata;
import org.dashbuilder.dataset.group.AggregateFunctionType;
import org.dashbuillder.remote.services.rest.BaseRestService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/datasets")
public class DataSetService extends BaseRestService {

    @Context
    private HttpHeaders headers;

    @Inject
    DataSetManager dataSetManager;


    @GET
    public String verifier() {
        return "Its working!";
    }

    /**
     * Returns the rows count of a dataset.
     *
     * @param uuid The uuid of the target dataset.
     * @return The size of the dataset in rows.
     */
    @Path("/{uuid}/rows/size")
    @GET
    public Response getCountOfRows(@PathParam("uuid") String uuid) throws Exception {
        DataSetMetadata metadata = dataSetManager.getDataSetMetadata(uuid);
        Integer value = metadata.getNumberOfRows();
        return createSuccessResponse(value,headers);
    }

    /**
     * Runs an aggregate function against a column of a dataset and returns the result.
     *
     * @param uuid                  The uuid of a target dataset
     * @param columName             The column on which the aggregate function will be executed
     * @param aggregateFunctionName The function to perform (sum, average...)
     * @return
     */
    @Path("/{uuid}/columns/{columnName}")
    @GET
    public Object getComputedValuesOfColumn(@PathParam("uuid") String uuid, @PathParam("columnName") String columName, @QueryParam("op") String aggregateFunctionName) throws Exception{
        AggregateFunctionType fn = AggregateFunctionType.getByName(aggregateFunctionName);
        if (fn == null) {
            //todo throws and exception saying that the function does not exist.
        }
        DataSet result = dataSetManager.lookupDataSet(
                DataSetFactory.newDataSetLookupBuilder()
                        .dataset(uuid)
                        .column(columName, fn)
                        .buildLookup());
        //todo talk to David about the return - learn the api.
        return createSuccessResponse(result.getValueAt(0, 0), headers);
    }


}
