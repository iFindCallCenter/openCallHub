package com.och.websocket.service.impl;

import com.och.common.config.redis.RedisService;
import com.och.common.constant.CacheConstants;
import com.och.websocket.service.IWebSocketService;
import com.och.websocket.utils.WsSessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Objects;
import java.util.Set;

/**
 * @author danmo
 * @date 2023年09月22日 11:10
 */
@Slf4j
@Service
public class WebSocketServiceImpl implements IWebSocketService {

    @Autowired
    private RedisService redisService;

    @Override
    public String getSessionId(String userId) {
        if(redisService.getCacheMapHasKey(CacheConstants.CLIENT_USER_POOL_KEY, String.valueOf(userId))){
            return (String) redisService.getCacheMapValue(CacheConstants.CLIENT_USER_POOL_KEY, String.valueOf(userId));
        }
        return null;
    }

    @Override
    public void sendMsg(String key, String msg) throws IOException {
        WebSocketSession webSocketSession = WsSessionUtil.get(key);
        if(Objects.nonNull(webSocketSession)){
            webSocketSession.sendMessage(new TextMessage(msg));
        }
    }

    @Override
    public void sendPongMsg(String key) throws IOException {
        WebSocketSession webSocketSession = WsSessionUtil.get(key);
        if(Objects.nonNull(webSocketSession)){
            webSocketSession.sendMessage(new PongMessage());
        }
    }

    @Override
    public void sendBroadcastMsg(String msg) throws IOException {
        for (WebSocketSession socketSession : WsSessionUtil.sessionPool.values()) {
            if(Objects.nonNull(socketSession)){
                socketSession.sendMessage(new TextMessage(msg));
            }
        }
    }


}
