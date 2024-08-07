package com.och.websocket.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.och.common.config.redis.RedisService;
import com.och.common.constant.CacheConstants;
import com.och.common.constant.TokenConstants;
import com.och.common.utils.StringUtils;
import com.och.security.authority.LoginUserInfo;
import com.och.security.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author danmo
 * @date 2023年09月22日 11:26
 */
@Slf4j
public class OchHandshakeInterceptor implements HandshakeInterceptor {

    private final RedisService redisService;

    public OchHandshakeInterceptor(RedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        try {
            // 从请求头中获取认证信息
            String authorization = request.getHeaders().getFirst("Authorization");
            final String username;
            if (authorization == null || !authorization.startsWith(TokenConstants.PREFIX)) {
                return false;
            }
            String token = authorization.substring(7);
            // 从token中解析出userId
            Long userId = JwtUtils.getUserId(token);
            String jwtToken = (String) redisService.getCacheObject(CacheConstants.LOGIN_TOKEN_KEY + userId);
            if (StringUtils.isEmpty(jwtToken) && !StringUtils.equals(token, jwtToken)) {
                return false;
            }
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据jwt解析出来的username，获取数据库中的用户信息，封装UserDetails对象
                LoginUserInfo userDetails = JSONObject.parseObject(JwtUtils.getLoginUserInfo(token), LoginUserInfo.class);
                // TODO 如果令牌有效，封装一个UsernamePasswordAuthenticationToken对象
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                // 更新安全上下文的持有用户
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }


}