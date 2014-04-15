/**
 * Copyright (C) 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.event;

import org.dashbuilder.model.dataset.DataSetLookup;
import org.dashbuilder.model.dataset.DataSet;
import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Event fired when a data set is ready for usage.
 */
@Portable
public class DataSetReadyEvent {

    protected DataSetLookup dataSetLookup;
    protected DataSet dataSet;

    public DataSetReadyEvent() {
    }

    public DataSetReadyEvent(DataSetLookup dataSetLookup, DataSet dataSet) {
        this();
        this.dataSetLookup = dataSetLookup;
        this.dataSet = dataSet;
    }

    public DataSetLookup getDataSetLookup() {
        return dataSetLookup;
    }

    public DataSet getDataSet() {
        return dataSet;
    }
}