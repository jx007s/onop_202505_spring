package com.example.demo.control;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;

@Controller
@RequestMapping("/thyme")
public class ThymeleafController {

	@RequestMapping("/var")
	String var(Model mm) {
		mm.addAttribute("aa",1234);
		mm.addAttribute("bb",new Person("루미", 167, false));
		mm.addAttribute("cc",new String[] {"사자","보이즈","팔자","아저씨즈"});
		
		ArrayList<String> shape = new ArrayList();
		shape.add("직사각형");
		shape.add("직각삼각형");
		shape.add("원");
		shape.add("마름모");
		
		HashMap<String, String> maps = new HashMap<>();
		maps.put("호랑이", "포유류");
		maps.put("사자", "포유류");
		maps.put("악어", "파충류");
		maps.put("오타니", "이도류");
		maps.put("상어", "어류");
		maps.put("사자", "단백이");
		maps.put("켄", "어류어겐");
		mm.addAttribute("dd",shape);
		mm.addAttribute("ee",maps);
		return "thyme/var";
	}
	 
	
	@RequestMapping("/calc")
	String calc(Model mm) {
		mm.addAttribute("aa",30);
		return "thyme/calc";
	
	}
	
	
	@RequestMapping("/control")
	String control(Model mm) {
		mm.addAttribute("aa",30);
		return "thyme/control";
	
	}
	
	@RequestMapping("/control2")
	String control2(Model mm) {
		mm.addAttribute("cc",new String[] {"사자","보이즈","팔자","아저씨즈"});
		
		ArrayList<String> shape = new ArrayList();
		shape.add("직사각형");
		shape.add("직각삼각형");
		shape.add("원");
		shape.add("마름모");
		
		HashMap<String, String> maps = new HashMap<>();
		maps.put("호랑이", "포유류");
		maps.put("사자", "포유류");
		maps.put("악어", "파충류");
		maps.put("오타니", "이도류");
		maps.put("상어", "어류");
		maps.put("사자", "단백이");
		maps.put("켄", "어류어겐");
		mm.addAttribute("dd",shape);
		mm.addAttribute("ee",maps);
		
		return "thyme/control2";
	
	}
	
	
	@RequestMapping("/layout")
	String layout(Model mm) {
		mm.addAttribute("cate","gall");
		mm.addAttribute("service","list");
		
		return "thyme/lao/layout";
	
	}
	
	
	
	
}
