package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ChannelData {
    private String state;
    private String direction;
    private String stateNumber;
    private String flags;
    private String caps;
}
