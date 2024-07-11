package com.och.common.xmlcurl.odbccdr;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.och.common.xmlcurl.Configuration;
import com.och.common.xmlcurl.sofia.setting.Settings;
import com.och.common.xmlcurl.xmlcdr.OdbcCdrTables;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author danmo
 * @date 2023年09月15日 16:44
 */
@Data
@Accessors(chain = true)
public class OdbcCdrConfiguration extends Configuration implements Serializable {

    @JacksonXmlElementWrapper(localName = "settings", useWrapping = false)
    private Settings settings;

    @JacksonXmlElementWrapper(localName = "tables", useWrapping = false)
    private OdbcCdrTables tables;
}
