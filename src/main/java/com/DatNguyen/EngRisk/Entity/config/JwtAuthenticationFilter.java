package com.DatNguyen.EngRisk.Entity.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component // Bean -> Don't need to create bean in appconfig
@RequiredArgsConstructor // Can create constructor for final variable
// This filter will be activated anytime client send requests
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        // The request header includes JWT token which starts from index 7. Format : Bearer_token, _ is space
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response); // -> Pass the filter to next request
            return;
        }
        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(jwt); // Extract user email from jwt token
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){ // user is not authenticated
            // Check if the email exists in database
            CustomUserDetails customUserDetails = (CustomUserDetails) this.userDetailsService.loadUserByUsername(userEmail); // Override this method to load by user email
            // Check if token is valid
            if (jwtService.isTokenValidate(jwt, customUserDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        customUserDetails,
                        null,
                        customUserDetails.getAuthorities()
                );
                // Set authentication token
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Update new context for authentication
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
