package org.dashbuillder.remote.services.rest.api;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class DashbuilderRestApplication extends Application{
    private Set<Object> singletons = new HashSet<Object>();

    public DashbuilderRestApplication() {
        singletons.add(new DatasetResource());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
