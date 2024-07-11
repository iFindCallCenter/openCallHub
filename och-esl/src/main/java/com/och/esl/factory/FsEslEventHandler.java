package com.och.esl.factory;

import org.freeswitch.esl.client.transport.event.EslEvent;

/**
 * @author danmo
 * @date 2023年09月18日 19:03
 */
public interface FsEslEventHandler {

    /**
     * 接收事件处理方法
     * @param address 连接地址
     * @param event 事件
     */
    void  handleEslEvent(String address, EslEvent event);
}
