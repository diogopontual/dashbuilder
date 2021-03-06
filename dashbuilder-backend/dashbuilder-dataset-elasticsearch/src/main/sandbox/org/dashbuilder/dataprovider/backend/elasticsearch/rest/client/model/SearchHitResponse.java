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
package org.dashbuilder.dataprovider.backend.elasticsearch.rest.client.model;

import org.apache.commons.collections.map.UnmodifiableMap;

import java.util.Collections;
import java.util.Map;

public class SearchHitResponse {

    protected float score;
    protected String index;
    protected String id;
    protected String type;
    protected long version;
    protected Map<String ,Object> fields;

    public SearchHitResponse(float score, String index, String id, String type, long version, Map<String ,Object> fields) {
        this.score = score;
        this.index = index;
        this.id = id;
        this.type = type;
        this.version = version;
        this.fields = fields;
    }

    public SearchHitResponse(Map<String ,Object> fields) {
        this.score = -1;
        this.index = null;
        this.id = null;
        this.type = null;
        this.version = -1;
        this.fields = fields;
    }

    public float getScore() {
        return score;
    }

    public String getIndex() {
        return index;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getVersion() {
        return version;
    }

    public Map<String, Object> getFields() {
        return fields;
    }
    public Object getFieldValue(String name) {
        if (name == null || name.trim().length() == 0 || fields == null || fields.isEmpty()) return null;
        return fields.get(name);
    }
}
