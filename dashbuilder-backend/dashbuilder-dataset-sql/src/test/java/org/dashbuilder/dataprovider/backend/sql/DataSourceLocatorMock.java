/**
 * Copyright (C) 2014 JBoss Inc
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
package org.dashbuilder.dataprovider.backend.sql;

import javax.enterprise.inject.Specializes;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.dashbuilder.dataset.def.SQLDataSetDef;
import org.h2.jdbcx.JdbcDataSource;

@Specializes
public class DataSourceLocatorMock extends SQLDataSourceLocatorImpl {

    public DataSource lookup(SQLDataSetDef def) throws NamingException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DATABASE_TO_UPPER=FALSE");
        return ds;
    }
}
