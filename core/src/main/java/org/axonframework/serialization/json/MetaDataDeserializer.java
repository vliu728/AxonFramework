/*
 * Copyright (c) 2010-2016. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.axonframework.messaging.MetaData;

import java.io.IOException;
import java.util.Map;

/**
 * JsonDeserializer implementation that deserializes MetaData instances.
 *
 * @author Allard Buijze
 * @since 2.4.2
 */
public class MetaDataDeserializer extends JsonDeserializer<MetaData> {

    @SuppressWarnings("unchecked")
    @Override
    public MetaData deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonDeserializer<Object> deserializer = ctxt.findRootValueDeserializer(
                ctxt.getTypeFactory().constructMapType(Map.class, String.class, String.class));

        return MetaData.from((Map) deserializer.deserialize(jp, ctxt));
    }
}
