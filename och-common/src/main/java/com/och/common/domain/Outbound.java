package com.och.common.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Outbound {
    private String rawBytes;
    private String mediaBytes;
    private String packetCount;
    private String mediaPacketCount;
    private String skipPacketCount;
    private String dtmfPacketCount;
    private String cngPacketCount;
    private String rtcpPacketCount;
    private String rtcpOctetCount;
}
