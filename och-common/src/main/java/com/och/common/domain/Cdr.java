package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;


@Data
@Accessors(chain = true)
public class Cdr {
    private String coreUuid;
    private String switchname;
    private ChannelData channelData;
    private CallStats callStats;
    private Variables variables;
    private AppLog appLog;
    private HoldRecord holdRecord;
    private List<Callflow> callflows;

    /**
     * <p>addCallflow.</p>
     *
     * @param callflow a {@link Callflow} object.
     */
    public void addCallflow(Callflow callflow) {
        if (callflows == null) {
            callflows = new ArrayList<>(4);
        }
        callflows.add(callflow);
    }
}
