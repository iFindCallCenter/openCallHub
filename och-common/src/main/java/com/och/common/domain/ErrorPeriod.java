package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorPeriod {
    private String start;
    private String stop;
    private String flaws;
    private String consecutiveFlaws;
    private String durationMsec;
}
