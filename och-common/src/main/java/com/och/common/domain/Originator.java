package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Originator {
    private OriginatorCallerProfile originatorCallerProfile;
}