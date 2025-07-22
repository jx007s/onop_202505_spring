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
}
