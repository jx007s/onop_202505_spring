package com.example.demo.di;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class EventInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session =   request.getSession();
		
		System.out.println("EventInterceptor.preHandle() 실행");
		
		Date eventDay = new Date(2025-1900, 7-1, 27);
		
		if(new Date().after(eventDay)) {
			System.out.println("이벤트 지났다");
			response.sendRedirect(request.getContextPath()+"/intercep/fail");
			
			return false;
			// return false : 밑의 postHandle(), afterCompletion() 으로 진행하지 않음
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("EventInterceptor.postHandle() 실행");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("EventInterceptor.afterCompletion() 실행");
	}

}
