package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Audio {
    private Inbound inbound;
    private Outbound outbound;
    private ErrorLog errorLog;
}
