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


//관리자 페이지에 로그인 된 관리자만 진입하게 해주세요
//  공지사항은 모두 들어갈수 있도록 해 주세요
//관리자 id : root  / 1234

