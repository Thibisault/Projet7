package com.nnk.springboot.security;


import org.springframework.security.core.Authentication;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    public void onAuthenticationSuccess(HttpServletRequest request,   HttpServletResponse response, Authentication authentication) throws IOException {
        Set<String> role = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (role.contains("ADMIN")) {
            response.sendRedirect("user/list");
        }
        if (role.contains("USER")) {
            response.sendRedirect("bidList/list");
        }
    }
}

