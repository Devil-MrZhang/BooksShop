package com.bookshop.filer;

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

import com.bookshop.model.User;

public class UserFiler implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("——————————管理用户拦截器损坏!——————————");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("——————————进入管理用户拦截器——————————");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getPassword());
		if (user != null && user.getRole() == 1) {
			// 如果有下一个过滤器则跳转到下一个过滤器否则目标页面
			System.out.println("——————————拦截器察觉管理用户已登录！——————————");
			System.out.println(user);
			chain.doFilter(request, response);
		} else {
			System.out.println("——————————拦截器察觉管理用户未登录！——————————");
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("——————————管理用户拦截器初始化成功！——————————");

	}

}
