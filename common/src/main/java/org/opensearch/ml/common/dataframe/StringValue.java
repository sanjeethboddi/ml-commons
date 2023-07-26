/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.ml.common.dataframe;

import java.io.IOException;

import org.opensearch.core.common.io.stream.StreamOutput;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@ToString
public class StringValue implements ColumnValue {
    @NonNull
    String value;

    @Override
    public ColumnType columnType() {
        return ColumnType.STRING;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public String stringValue() {
        return value;
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        out.writeEnum(columnType());
        out.writeString(value);
    }
}
