package aaa.control_p;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;


// 예외 전역 처리

@Controller
// ErrorController : spring boot 에서 에러발생에 대한 예외처리 
public class CustomErrorController implements ErrorController{

	@RequestMapping("/error")  //spring boot는 에러발생시 "/error" 로 라우팅함
	String errorGo(HttpServletRequest request, Model mm) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		System.out.println("status : "+status);	//404, 500
		

		if(status.equals(500)) {
			Throwable e = (Throwable)request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
			System.out.println("500일때 뭐여:"+e.getMessage());
			if(e.getMessage().equals("Request processing failed: java.lang.ArithmeticException: / by zero")) {  // 500 이면서 / by zero
				return "divZero";
			}else {
				mm.addAttribute("msg", "내부오류입니다.");
			}
			
		}else if(status.equals(404)) {
			mm.addAttribute("msg", "없는페이지입니다.");
		}
		
		
		return "alert";
	}
}

/*
 404 : 없는페이지입니다. -> 확인 -> 최초 index
 500 : / by zero ==> 0으로 나누었어요 
       나머지      ==> 내부오류입니다. -> 확인 -> 최초 index
 * */










