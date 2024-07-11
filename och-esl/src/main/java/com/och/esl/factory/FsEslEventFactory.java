package com.och.esl.factory;

import com.och.common.annotation.EslEventName;
import com.och.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author danmo
 * @date 2023年09月18日 19:03
 */
@Slf4j
@Component
public class FsEslEventFactory {

    private Map<String, FsEslEventHandler> eventMap = new ConcurrentHashMap<>();

    public FsEslEventFactory(Map<String, FsEslEventHandler> eventMap) {
       this.eventMap.putAll(eventMap);
    }

    public void getResource(String address, EslEvent event) {

        String eventName = event.getEventName();
        FsEslEventHandler factory = factory(eventName);
        if (factory != null) {
            factory.handleEslEvent(address, event);
        }
    }

    private FsEslEventHandler factory(String eventName) {
        for (FsEslEventHandler handler : eventMap.values()) {
            EslEventName handlerName = handler.getClass().getAnnotation(EslEventName.class);
            if (handlerName == null) {
                handlerName = handler.getClass().getSuperclass().getAnnotation(EslEventName.class);
            }
            if (handlerName == null || StringUtils.isEmpty(handlerName.value())) {
                continue;
            }
            if (Objects.equals(eventName, handlerName.value())) {
                return handler;
            }
        }
        return null;
    }


}
