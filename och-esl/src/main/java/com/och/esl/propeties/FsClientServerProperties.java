package com.och.esl.propeties;

import lombok.Data;

/**
 * @author danmo
 * @date 2023年09月18日 15:05
 */
@Data
public class FsClientServerProperties {

    private String ip;

    private Integer port;

    private String passWord;

    private Integer outTime;
}
