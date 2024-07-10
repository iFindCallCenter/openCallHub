package com.och.security.utils;

import com.och.security.authority.LoginUserInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;

/**
 * @author danmo
 * @date 2024-07-10 15:31
 **/
public class SecurityUtils extends com.och.common.utils.SecurityUtils {

    /**
     * 获取当前用户信息
     *
     * @return LoginUserInfo
     */
    public static LoginUserInfo getCurrentUserInfo() {
        if (Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
            return null;
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof LoginUserInfo) {
            return (LoginUserInfo) principal;
        } else {
            return null;
        }
    }

    /**
     * 获取当前用户ID
     *
     * @return Long
     */
    public static Long getUserId() {
        return getCurrentUserInfo().getUserId();
    }

    /**
     * 获取当前用户账号
     *
     * @return String
     */
    public static String getUserName() {
        return getCurrentUserInfo().getUsername();
    }

    /**
     * 获取当前用户角色
     *
     * @return List<Long>
     */
    public static List<Long> getRole() {
        return getCurrentUserInfo().getRoleIds();
    }

    /**
     * 获取当前用户数据权限
     *
     * @return List<Integer>
     */
    public static List<Integer> getDataScope() {
        return getCurrentUserInfo().getDataScope();
    }

    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }
}
