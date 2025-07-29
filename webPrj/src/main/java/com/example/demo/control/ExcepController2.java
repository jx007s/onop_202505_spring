package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExcepController2 {
	
	@RequestMapping("excep/errTestGo2")
	String errTestGo2(@RequestParam(value = "cnt", defaultValue = "10") int cnt) {
		
		int a = 1234/cnt;
		System.out.println("excep/errTestGo2() 실행:"+a);
		return "excep/errTestGo";
	}
	
}
