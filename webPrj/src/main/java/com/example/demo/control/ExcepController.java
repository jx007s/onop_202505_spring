package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExcepController {
	
	@RequestMapping("excep/errTestGo")
	String errTestGo(@RequestParam(value = "cnt", defaultValue = "10") int cnt) {
		
		int a = 1234/cnt;
		System.out.println("excep/errTestGo() 실행:"+a);
		return "excep/errTestGo";
	}
	
	
	// 컨트롤러에 속한 에러만 처리
	@ExceptionHandler(Exception.class)  //모든 예외 처리
	@ResponseBody
	String excep(Exception e) {
		return "예외처리 : "+e.getMessage();
	}

}
