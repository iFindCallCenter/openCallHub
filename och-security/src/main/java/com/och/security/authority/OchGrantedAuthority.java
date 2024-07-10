package com.och.security.authority;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.List;

/**
 * @author danmo
 * @date 2024-02-23 10:49
 **/
@Data
public final class OchGrantedAuthority implements GrantedAuthority {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;


    private final String role;

    private final List<String> permissions;

    public OchGrantedAuthority(String role, List<String> permissions) {
        this.role = role;
        this.permissions = permissions;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}
