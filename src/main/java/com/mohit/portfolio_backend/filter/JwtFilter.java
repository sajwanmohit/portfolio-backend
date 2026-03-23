package com.mohit.portfolio_backend.filter;

import com.mohit.portfolio_backend.service.CustomUserDetailsService;
import com.mohit.portfolio_backend.utility.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        String username = null;
        String token = null;
try {
    // 1. Extract Token
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
        token = authHeader.substring(7);
        username = jwtUtil.extractUsername(token);
    }

    // 2. Authenticate if not already authenticated
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (jwtUtil.validateToken(token, userDetails.getUsername())) {

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new org.springframework.security.web.authentication.WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }
} catch (Exception e) {
    System.out.println("JWT Error : "+ e.getMessage());
}

        chain.doFilter(request, response);
    }
}