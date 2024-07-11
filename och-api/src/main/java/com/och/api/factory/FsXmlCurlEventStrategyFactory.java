package com.och.api.factory;

import com.och.common.annotation.XmlCurlEventName;
import com.och.common.utils.StringUtils;
import com.och.system.domain.entity.FsXmlCurl;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * xml_curl策略工厂
 *
 * @author danmo
 * @date 2023/09/13 22:02
 **/
@Component
public class FsXmlCurlEventStrategyFactory {

    private final Map<String, FsXmlCurlEventStrategy> eventStrategyMap = new ConcurrentHashMap<>();

    public FsXmlCurlEventStrategyFactory(Map<String, FsXmlCurlEventStrategy> eventStrategyMap) {
        this.eventStrategyMap.putAll(eventStrategyMap);
    }


    public String getResource(String type, FsXmlCurl fsXmlCurl) {
        FsXmlCurlEventStrategy factory = factory(type);
        if (factory != null) {
            return factory.eventHandle(fsXmlCurl);
        }
        return "";
    }


    private FsXmlCurlEventStrategy factory(String eventType) {
        for (FsXmlCurlEventStrategy eventStrategy : eventStrategyMap.values()) {
            XmlCurlEventName handlerName = eventStrategy.getClass().getAnnotation(XmlCurlEventName.class);
            if (handlerName == null) {
                handlerName = eventStrategy.getClass().getSuperclass().getAnnotation(XmlCurlEventName.class);
            }
            if (handlerName == null || StringUtils.isEmpty(handlerName.value())) {
                continue;
            }
            if (Objects.equals(eventType, handlerName.value())) {
                return eventStrategy;
            }
        }
        return null;
    }
}
