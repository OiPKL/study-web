package com.ssafy.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
	
	private FilterConfig fConfig;
       
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿에게 전달 전 코드 작성 ---------------------------------------------------
		System.out.println("서블릿 전1");
		// 필터체이닝 -> doFilter를 통해 다음으로
		// 마지막 필터 -> 처리하는 서블릿으로
		
		String encoding = fConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		// 사용자에게 전달 전 코드 작성 ---------------------------------------------------
		System.out.println("서블릿 후1");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
