package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Human;

@Controller
@RequestMapping("/thyme")
public class FormLayoutController {

	@RequestMapping("/form")
	String form(Human hm) {
		return "thyme/form";
	}
	
	@ResponseBody
	@RequestMapping("/submittt")
	String complate(Human hm) {
		return "complate : "+hm;
	}
}
