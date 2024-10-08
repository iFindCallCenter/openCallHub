package com.och.common.xmlcurl.sofia.profile;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.och.common.xmlcurl.sofia.aliase.Aliases;
import com.och.common.xmlcurl.sofia.domain.Domains;
import com.och.common.xmlcurl.sofia.gateway.Gateways;
import com.och.common.xmlcurl.sofia.setting.Settings;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author danmo
 */
@Data
@Accessors(chain = true)
public class Profile implements Serializable {
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "gateways", isAttribute = true)
    private Gateways gateways;

    @JacksonXmlProperty(localName = "aliases", isAttribute = true)
    private Aliases aliases;

    @JacksonXmlProperty(localName = "domains", isAttribute = true)
    private Domains domains;

    @JacksonXmlProperty(localName = "settings", isAttribute = true)
    private Settings settings;
}
