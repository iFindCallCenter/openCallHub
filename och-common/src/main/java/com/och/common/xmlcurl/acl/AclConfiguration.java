package com.och.common.xmlcurl.acl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.och.common.xmlcurl.Configuration;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author danmo
 * @date 2023年09月14日 16:54
 */
@Data
@Accessors(chain = true)
public class AclConfiguration extends Configuration implements Serializable {

    @JacksonXmlElementWrapper(localName = "network-lists", useWrapping = false)
    private AclNetworkLists networkLists;
}
