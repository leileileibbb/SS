package com.bzu.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;
		HttpSession session = rq.getSession();
		String realpath = rq.getRequestURI();
		String path = realpath.substring(realpath.lastIndexOf("/") + 1);
		Object obj = session.getAttribute("stu_info");
		if (obj == null) {
			if (path.equals("login.jsp"))
				chain.doFilter(request, response);
			else {
				session.setAttribute("result", "对不起，您还没有登陆，请先登录");
				rp.sendRedirect(rq.getContextPath()
						+ "/jsp/front/login.jsp");
			}
		} else
			chain.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
