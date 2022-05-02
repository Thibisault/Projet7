package com.nnk.springboot.security;

import com.nnk.springboot.domain.User;
import org.springframework.security.core.GrantedAuthority;

public final class SimpleGrantedAuthority implements GrantedAuthority {

    @Override
    public String getAuthority() {
        User user = new User();
        return user.getRole();
    }
}