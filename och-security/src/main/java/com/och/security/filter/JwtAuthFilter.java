package com.och.security.filter;

import com.alibaba.fastjson.JSONObject;
import com.och.security.authority.LoginUserInfo;
import com.och.common.config.redis.RedisService;
import com.och.common.constant.CacheConstants;
import com.och.common.constant.TokenConstants;
import com.och.security.utils.JwtUtils;
import com.och.common.utils.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author danmo
 * @date 2024-02-21 11:04
 **/
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // 从请求头中获取认证信息
            final String authHeader = request.getHeader(TokenConstants.AUTHENTICATION);
            final String token;
            final String username;
            if (authHeader == null || !authHeader.startsWith(TokenConstants.PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            token = authHeader.substring(7);
            // 从token中解析出userId
            Long userId = JwtUtils.getUserId(token);
            String jwtToken = (String) redisService.getCacheObject(CacheConstants.LOGIN_TOKEN_KEY + userId);
            if (StringUtils.isEmpty(jwtToken) && !StringUtils.equals(token,jwtToken)) {
                filterChain.doFilter(request, response);
                return;
            }
            // 从token中解析出username
            username = JwtUtils.getUserName(token);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据jwt解析出来的username，获取数据库中的用户信息，封装UserDetails对象
                LoginUserInfo userDetails = JSONObject.parseObject(JwtUtils.getLoginUserInfo(token),LoginUserInfo.class);
                // TODO 如果令牌有效，封装一个UsernamePasswordAuthenticationToken对象
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 更新安全上下文的持有用户
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
                return;
            }
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            return;
        }
        // 如果token为空直接下一步过滤器，此时上线文中无用户信息，所有在后续认证环节失败
        filterChain.doFilter(request, response);
    }
}
