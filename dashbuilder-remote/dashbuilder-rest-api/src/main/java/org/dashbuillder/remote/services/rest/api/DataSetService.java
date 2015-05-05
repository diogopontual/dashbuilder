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


    /**
     * Fetchs an returns the dataset metadata.
     *
     * @param uuid The uuid of the target dataset.
     */
    @Produces("application/json")
    @Path("/{uuid}/metadata")
    @GET
    public Map<String, Object> getMetadata(@PathParam("uuid") String uuid) {
        DataSetMetadata metadata = dataSetManager.getDataSetMetadata(uuid);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("uuid", uuid);
        response.put("columns", metadata.getNumberOfColumns());
        response.put("rows", metadata.getNumberOfRows());
        return response;
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
    public Integer getRowsCount(@PathParam("uuid") String uuid) {
        DataSetMetadata metadata = dataSetManager.getDataSetMetadata(uuid);
        return metadata.getNumberOfRows();
    }

    /**
     * Returns the rows count of a dataset.
     *
     * @param uuid The uuid of the target dataset.
     * @return The size of the dataset in rows.
     */
    @Produces("application/json")
    @Path("/{uuid}/columns/{columnName}")
    @GET
    public Integer getColumnValues(@PathParam("uuid") String uuid, @PathParam("columnName") String columName, @QueryParam("op") String operation) {
        DataSet result = dataSetManager.lookupDataSet(
                DataSetFactory.newDataSetLookupBuilder()
                        .dataset(uuid)
                        .column(columName, AggregateFunctionType.valueOf(operation))
                        .buildLookup());
        return (Integer) result.getValueAt(0, 0);
    }


}
