package com.och.esl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.freeswitch.esl.client.transport.event.EslEvent;

/**
 * @author danmo
 * @date 2023年09月27日 21:14
 */
@AllArgsConstructor
@Builder
@Data
public class FsEslMsg {

    //发送员工ID
    private Long userId;

    //发送企业ID
    private Integer tenantId;

    //消息
    private EslEvent eslEvent;

    //FS地址
    private String address;

}
