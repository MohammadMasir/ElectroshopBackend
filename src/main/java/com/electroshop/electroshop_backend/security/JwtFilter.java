package com.electroshop.electroshop_backend.security;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

//		String path = request.getRequestURI();
//		System.out.println(path.contains("/signup"));
//		if (isAllowed(request)){
//			filterChain.doFilter(request,response);
//			System.out.println(isAllowed(request));
//			return;
//		}
//
		filterChain.doFilter(request, response);
	}

	private boolean isAllowed(HttpServletRequest request){
		String path = request.getRequestURI();
		return path.endsWith("/signup") || path.endsWith("/login") || path.endsWith("/");
	}

}
