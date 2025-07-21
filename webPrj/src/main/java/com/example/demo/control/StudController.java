package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Stud;

@Controller
@RequestMapping("/stud")
public class StudController {

	@GetMapping
	String form() {
		return "req/studForm";
	}
	
	@PostMapping
	String complete(@ModelAttribute("st") Stud st) {
		st.calc();
		return "req/studReg";
	}
}
