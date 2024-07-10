package com.och.security.authority;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-23 10:44
 **/
@Component("authz")
public class OchMenuAuthorization {

    public boolean hasPerm(String permission) {
        List<OchGrantedAuthority> authorities = (List<OchGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (OchGrantedAuthority authority : authorities) {
            return authority.getPermissions().contains(permission) || StringUtils.equals(authority.getAuthority(),"ROLE_ADMIN");
        }
        return false;
    }
}
