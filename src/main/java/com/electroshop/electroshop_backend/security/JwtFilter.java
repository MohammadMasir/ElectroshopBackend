package com.electroshop.electroshop_backend.security;

import java.io.IOException;

import com.electroshop.electroshop_backend.service.CustomUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final CustomUserDetailsService userDetailsService;

	public JwtFilter(JwtService jwtService, CustomUserDetailsService userDetailsService){
		this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

	private final String privateKey = "";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		if (authHeader == null && !authHeader.startsWith("Bearer ")){
			filterChain.doFilter(request,response);
			return;
		}

		try {
			final String token = authHeader.substring(7);
			final String username = jwtService.extractUsername(token);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (username != null && authentication == null){
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (jwtService.vaildateJwt(token, userDetails)){
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails,
							null,
							userDetails.getAuthorities()
					);
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		} catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        }

        filterChain.doFilter(request, response);
	}

}
