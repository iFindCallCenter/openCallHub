package com.och.esl.factory;

import com.och.common.annotation.EslRouteName;
import com.och.esl.handler.route.FsAbstractRouteHandler;
import lombok.extern.slf4j.Slf4j;
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
public class FsEslRouteFactory {

    private final Map<String, FsAbstractRouteHandler> routeMap = new ConcurrentHashMap<>(16);

    public FsEslRouteFactory(Map<String, FsAbstractRouteHandler> routeMap) {
        this.routeMap.putAll(routeMap);
    }

    public FsAbstractRouteHandler factory(Integer type) {
        for (FsAbstractRouteHandler handler : routeMap.values()) {
            EslRouteName routeName = handler.getClass().getAnnotation(EslRouteName.class);
            if (routeName == null) {
                routeName = handler.getClass().getSuperclass().getAnnotation(EslRouteName.class);
            }
            if (Objects.equals(type, routeName.value().getType())) {
                return handler;
            }
        }
        return null;
    }

}
