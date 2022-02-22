/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.sort.formats.common;

import java.util.Objects;

public class LocalZonedTimestampFormatInfo implements FormatInfo {

    private static final long serialVersionUID = -7501810151856898046L;

    private final String format;

    public LocalZonedTimestampFormatInfo(String format) {
        this.format = format;
    }

    public LocalZonedTimestampFormatInfo() {
        this("yyyy-MM-dd HH:mm:ss");
    }

    public String getFormat() {
        return format;
    }

    @Override
    public TypeInfo getTypeInfo() {
        return LocalZonedTimestampTypeInfo.INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocalZonedTimestampFormatInfo that = (LocalZonedTimestampFormatInfo) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }

    @Override
    public String toString() {
        return "LocalZonedTimestampFormatInfo{"
                + "format='" + format + '\''
                + '}';
    }

}