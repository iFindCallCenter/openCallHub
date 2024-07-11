package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Times {
    private Long createdTime;
    private Long profileCreatedTime;
    private Long progressTime;
    private Long progressMediaTime;
    private Long answeredTime;
    private Long bridgedTime;
    private Long lastHoldTime;
    private Long holdAccumTime;
    private Long hangupTime;
    private Long resurrectTime;
    private Long transferTime;
}
