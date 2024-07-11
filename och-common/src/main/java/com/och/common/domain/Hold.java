package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Hold {
    private Long on;
    private Long off;
    private String bridgedTo;
}
