package com.example.demo.control;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


// 예외 전역 처리

@Controller
// ErrorController : spring boot 에서 에러발생에 대한 예외처리 
public class CustomErrorController implements ErrorController{

	@ResponseBody
	@RequestMapping("/error")  //spring boot는 에러발생시 "/error" 로 라우팅함
	String errorGo(HttpServletRequest request) {
		
		System.out.println("RequestDispatcher.ERROR_STATUS_CODE : "+RequestDispatcher.ERROR_STATUS_CODE);
		//에러메세지
		//Object status = request.getAttribute("jakarta.servlet.error.status_code");
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		System.out.println("status : "+status);	//404, 500
		
		String ttt = "에러구나:"+ status;
		
		if(status.equals(500)) {
			System.out.println("500일때만 와");
			Throwable e = (Throwable)request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
			ttt += " , "+e.getMessage();
		}
		
		
		return ttt;
	}
}
