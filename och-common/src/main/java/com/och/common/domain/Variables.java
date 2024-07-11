package com.och.common.domain;

import cn.hutool.core.net.URLDecoder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Data
@Accessors(chain = true)
public class Variables {
    private Map<String, String> variableTable;

    /**
     * <p>putVariable.</p>
     *
     * @param key   a {@link String} object.
     * @param value a {@link String} object.
     */
    public void putVariable(String key, String value) {
        if (variableTable == null) {
            variableTable = new ConcurrentHashMap<>(256);
        }
        variableTable.put(key, URLDecoder.decode(value, Charset.defaultCharset()));
    }
}
