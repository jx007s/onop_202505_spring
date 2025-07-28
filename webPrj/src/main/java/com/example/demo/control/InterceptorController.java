package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/intercep")
public class InterceptorController {

	@RequestMapping("event")
	String event() {
		return "intercep/event";
	}
	
	@ResponseBody
	@RequestMapping("fail")
	String fail() {
		return "이벤트 끝났지롱";
	}
}
