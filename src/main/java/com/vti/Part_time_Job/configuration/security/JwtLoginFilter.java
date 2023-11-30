package com.vti.Part_time_Job.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    private final JwtHandler jwtHandler;

    @Autowired
    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtHandler jwtHandler) {
        super(new AntPathRequestMatcher("/api/v1/auth/login", "POST"), authenticationManager);
        this.jwtHandler = jwtHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(email, password);
        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String token = jwtHandler.generateToken(authResult.getName());
        response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }

}
