package com.och.esl.handler.route;

import com.och.common.annotation.EslRouteName;
import com.och.common.domain.CallInfo;
import com.och.common.enums.RouteTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author danmo
 * @date 2023-11-10 17:20
 **/
@EslRouteName(RouteTypeEnum.VOICE)
@Component
@Slf4j
public class FsVoiceRouteHandler extends FsAbstractRouteHandler {

    @Override
    public void handler(String address, CallInfo callInfo, String uniqueId, String routeValue) {

    }
}
