package com.example.demo.control;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;

@Controller
public class HomeController {

	@RequestMapping("/")   //url-mapping 과 같다
	String home(Model mm) {
		
		// request.setAttribute 와 같음
		mm.addAttribute("now", new Date());
		mm.addAttribute("arr", new int[] {11,22,33,44});
		mm.addAttribute("age", 34);
		mm.addAttribute("per", new Person("이지원",175,false));
		
		System.out.println("home 실행");
		return "index";
		
		/*
		 * 
application.yml

spring:
    thymeleaf:
        prefix: /views/
        suffix: .html
        cashe: false
        
      "/views/" + "index" + ".html"   으로 forwarding  
*/
		
		
		
		
	}
	
	@RequestMapping("/thyme/link")   
	String link(Model mm) {
		mm.addAttribute("cate1", "gall");
		mm.addAttribute("cate2", "winter");
		mm.addAttribute("pp1", "detail");
		mm.addAttribute("pp2", 17);
		
		return "link";
		
	}
	
	
	
	
}

/*
////myThProj 프로젝트를 생성하고

/// 학생 데이터(이름,국어,영어,수학,총점,평균)를 출력하세요
 * */


