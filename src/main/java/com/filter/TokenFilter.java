package com.filter;

import java.io.IOException;

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
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Token filter called");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String token = req.getHeader("Token");
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
