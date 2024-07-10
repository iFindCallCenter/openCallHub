package com.och.api.event;

import com.och.system.domain.entity.SysOperLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author danmo
 * @date 2024-03-12 18:58
 **/
public class OchLogEvent extends ApplicationEvent {

    public OchLogEvent(SysOperLog log) {
        super(log);
    }
}
