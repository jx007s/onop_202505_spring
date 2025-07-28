package com.example.demo.di;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class PathShopInterCeptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String pid = (String)session.getAttribute("pid");
		
		if(pid==null || !pid.equals("aaa")) {
			
			response.sendRedirect(request.getContextPath()+"/path/info/hello");
			return false;
		}
			
		return true;
	}
}
