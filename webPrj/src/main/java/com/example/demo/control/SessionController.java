package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Person;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ses")
public class SessionController {

	@RequestMapping("view")
	String view() {
		return "ses/view";
	}
	
	
	@ResponseBody
	@RequestMapping("make1")
	String make1(HttpSession session) {
		session.setAttribute("pid", "aaa");
		session.setAttribute("per", new Person("정우성", 187, false));
		return "세션생성";
	}
	
	
	@ResponseBody
	@RequestMapping("make2")
	String make2(HttpSession session) {
		session.setAttribute("pid", "bbb");
		session.setAttribute("arr", new int[] {11,22,33});
		return "세션생성2";
	}
	
	@ResponseBody
	@RequestMapping("delete1")
	String delete1(HttpSession session) {
		session.removeAttribute("pid");
		session.removeAttribute("arr");
		return "세션삭제1";
	}
	
	@ResponseBody
	@RequestMapping("delete2")
	String delete2(HttpSession session) {
		session.invalidate();
		return "세션초기화2";
	}
}
