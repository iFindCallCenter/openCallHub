package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
public class Extension {
    private String name;
    private String number;
    private List<Application> applications;
}
