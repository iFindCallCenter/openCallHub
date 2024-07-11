package com.och.common.xmlcurl.dialplan;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.och.common.enums.AppEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author danmo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Action implements Serializable {

    @JacksonXmlProperty(localName = "application", isAttribute = true)
    private AppEnum application;

    @JacksonXmlProperty(localName = "data", isAttribute = true)
    private String data;

    public Action(String application, String data) {
        this.application = AppEnum.instance(application);
        this.data = data;
    }

}
