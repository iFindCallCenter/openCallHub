package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Application {
    private String appName;
    private String appData;
    private Long appStamp;
}
