package org.dashbuillder.remote.services.rest.api;

import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.DataSetFactory;
import org.dashbuilder.dataset.DataSetManager;
import org.dashbuilder.dataset.DataSetMetadata;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.group.AggregateFunction;
import org.dashbuilder.dataset.group.AggregateFunctionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by diogopontual on 30/04/15.
 */
@ApplicationScoped
@Path("/datasets")
public class DataSetService {

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
    @Produces("application/json")
    @Path("/{uuid}/rows/size")
    @GET
    public Integer getCountOfRows(@PathParam("uuid") String uuid) {
        DataSetMetadata metadata = dataSetManager.getDataSetMetadata(uuid);
        return metadata.getNumberOfRows();
    }

    /**
     * Runs an aggregate function against a column of a dataset and returns the result.
     *
     * @param uuid      The uuid of a target dataset
     * @param columName The column on which the aggregate function will be executed
     * @param aggregateFunctionName The function to perform (sum, average...)
     * @return
     */
    @Produces("application/json")
    @Path("/{uuid}/columns/{columnName}")
    @GET
    public Object getComputedValuesOfColumn(@PathParam("uuid") String uuid, @PathParam("columnName") String columName, @QueryParam("op") String aggregateFunctionName) {
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
        return result.getValueAt(0, 0);
    }


}
