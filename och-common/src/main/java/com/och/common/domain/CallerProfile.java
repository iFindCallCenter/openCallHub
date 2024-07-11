package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class CallerProfile {
    private String username;
    private String dialplan;
    private String callerIdName;
    private String callerIdNumber;
    private String calleeIdName;
    private String calleeIdNumber;
    private String ani;
    private String aniii;
    private String networkAddr;
    private String rdnis;
    private String destinationNumber;
    private String uuid;
    private String source;
    private String transferSource;
    private String context;
    private String chanName;
    private Originator originator;
    private Originatee originatee;
    private Origination origination;
}
