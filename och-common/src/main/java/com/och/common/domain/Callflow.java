package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class Callflow {
    private String dialplan;
    private String uniqueId;
    private String cloneOf;
    private String profileIndex;
    private Extension extension;
    private CallerProfile callerProfile;
    private Times times;
}
