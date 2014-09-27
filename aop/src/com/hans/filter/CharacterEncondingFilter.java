package com.hans.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncondingFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig config;
	private String encoding = "ISO8859_1";

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		// 如何还有下一个Filter，那么就交给下一个Filter来处理，如果没有Filter，就调用Servlet
		chain.doFilter(request, response);
		response.setCharacterEncoding(encoding);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		// 获取初始化参数(web.xml)
		encoding = config.getInitParameter("encoding");
		// encoding = config.getServletContext().getInitParameter("encoding");
	}
}
