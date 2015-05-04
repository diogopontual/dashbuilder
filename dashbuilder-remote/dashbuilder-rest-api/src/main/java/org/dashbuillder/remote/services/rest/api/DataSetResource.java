package org.dashbuillder.remote.services.rest.api;

import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.DataSetBackendServices;
import org.dashbuilder.dataset.DataSetManager;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.def.DataSetDefRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by diogopontual on 30/04/15.
 */
@ApplicationScoped
@Path("/datasets")
public class DataSetResource {

    @Inject
    DataSetDefRegistry dataSetDefRegistry;

    @Inject
    DataSetManager dataSetManager;

    /**
     * Returns all available datasets.
     *
     * @return
     */
    @Produces("application/json")
    @GET
    public List<DataSetDef> get() {
        return dataSetDefRegistry.getDataSetDefs(false);
    }
}
