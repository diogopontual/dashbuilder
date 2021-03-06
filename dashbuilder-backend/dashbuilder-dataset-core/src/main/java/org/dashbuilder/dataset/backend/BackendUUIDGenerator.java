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
package org.dashbuilder.dataset.backend;

import java.nio.ByteBuffer;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.codec.binary.Base64;
import org.dashbuilder.dataset.uuid.UUIDGenerator;

/**
 * UUID generator based on the <i>java.util.UUID</i> utility
 */
@ApplicationScoped
public class BackendUUIDGenerator implements UUIDGenerator {

    public String newUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public String newUuidBase64() {
        String uuidStr = newUuid();
        return uuidToBase64(uuidStr);
    }

    public String uuidToBase64(String str) {
        Base64 base64 = new Base64();
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return base64.encodeBase64URLSafeString(bb.array());
    }

    public String uuidFromBase64(String str) {
        Base64 base64 = new Base64();
        byte[] bytes = base64.decodeBase64(str);
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        UUID uuid = new UUID(bb.getLong(), bb.getLong());
        return uuid.toString();
    }
}
