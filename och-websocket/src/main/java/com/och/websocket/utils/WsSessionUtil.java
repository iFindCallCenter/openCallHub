package com.och.websocket.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author danmo
 * @date 2023年09月22日 10:53
 */
@Slf4j
public class WsSessionUtil {

    public static Map<String, WebSocketSession> sessionPool =  new ConcurrentHashMap<>(16);

    /**
     * 添加session
     * @param key sessionId
     * @param session session
     */
    public static void add(String key,WebSocketSession session){
        sessionPool.put(key,session);
    }

    /**
     * 移除session
     * @param key sessionId
     */
    public static void remove(String key){
        sessionPool.remove(key);
    }

    /**
     * 移除session并关闭连接
     * @param key sessionId
     */
    public static void removeAndClose(String key){
        if(sessionPool.containsKey(key)){
            WebSocketSession socketSession = sessionPool.remove(key);
            if(Objects.nonNull(socketSession)){
                try {
                    socketSession.close();
                } catch (IOException e) {
                    log.error("ws 连接关闭异常 msg:{}",e.getMessage(),e);
                }

            }
        }

    }

    /**
     * 获取session
     * @param key sessionId
     * @return
     */
    public static WebSocketSession get(String key){
       return sessionPool.get(key);
    }
}
