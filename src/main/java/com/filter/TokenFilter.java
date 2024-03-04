package com.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter implements Filter {
	private final List<String> publicEndpoints = Arrays.asList("/signup");
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Token filter called");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestURI = req.getRequestURI();
		if (publicEndpoints.contains(requestURI)) {
			System.out.println("Public URI");
            chain.doFilter(request, response);
        }
		else {
			String token = req.getHeader("Token");
			System.out.println("Private URI");
			if(token == null) {
				System.out.println("Token is not present");
				res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				res.getWriter().print("UNAUTHORIZED");
				res.getWriter().flush();		
			}
			else {
				System.out.println("TOken Present");
				chain.doFilter(request, response);
			}
		}
	}
}
