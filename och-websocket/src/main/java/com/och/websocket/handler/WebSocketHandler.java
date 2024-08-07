package com.och.websocket.handler;

import com.och.common.config.redis.RedisService;
import com.och.common.constant.CacheConstants;
import com.och.security.utils.SecurityUtils;
import com.och.websocket.utils.WsSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


/**
 * @author danmo
 * @date 2023年09月22日 10:40
 */
@Slf4j
@Component
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    private RedisService redisService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("建立ws 连接 sessionId:{}", session.getId());
        Long userId = SecurityUtils.getUserId();
        String sessionId = session.getId();
        redisService.setCacheMapValue(CacheConstants.CLIENT_USER_POOL_KEY, String.valueOf(userId), sessionId);
        WsSessionUtil.add(sessionId, session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("接收到ws文本消息 sessionId:{}, msg:{}", session.getId(), message.toString());

    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        log.info("接收到ws二进制消息 sessionId:{}, msg:{}", session.getId(), message.toString());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("ws 连接异常 sessionId:{},msg:{}", session.getId(), exception.getMessage(), exception);
        String sessionId = session.getId();
        Long userId = SecurityUtils.getUserId();
        redisService.delCacheMapValue(CacheConstants.CLIENT_USER_POOL_KEY, String.valueOf(userId));
        WsSessionUtil.removeAndClose(sessionId);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.error("关闭ws连接 sessionId:{},status:{},{}", session.getId(), status.getCode(), status.getReason());
        String sessionId = session.getId();
        Long userId = SecurityUtils.getUserId();
        redisService.delCacheMapValue(CacheConstants.CLIENT_USER_POOL_KEY, String.valueOf(userId));
        WsSessionUtil.removeAndClose(sessionId);
    }
}
