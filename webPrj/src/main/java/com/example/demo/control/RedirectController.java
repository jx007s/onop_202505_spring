package com.example.demo.control;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Address;
import com.example.demo.model.Person;

@Controller
@RequestMapping("/red")
public class RedirectController {
	
	@RequestMapping("from1")
	String from1() {
		System.out.println("from1 진입");
		// redirect 할 경우 redirect:이동할URL
		return "redirect:to?pid=aaa&age=34&marriage=true";
	}
	
	@RequestMapping("from2")
	String from2(Model mm) {
		System.out.println("from2 진입");

		//Model 로 paramter 전달 실패
		mm.addAttribute("pid", "bbb");
		mm.addAttribute("age",26);
		mm.addAttribute("marriage", false);
		
		return "redirect:to";
	}
	
	@RequestMapping("from3")
	ModelAndView from3() {
		System.out.println("from3 진입");
		ModelAndView mav = new ModelAndView("redirect:to?pid=ccc&age=17&marriage=false");
		
		// ModelAndView 로 페이지이동 가능
		return mav;
	}
	
	@RequestMapping("from4")
	ModelAndView from4() {
		System.out.println("from4 진입");
		
		ModelAndView mav = new ModelAndView("redirect:to");
		
		//ModelAndView 로 paramter 전달 가능
		mav.addObject("pid", "ddd");
		mav.addObject("age",45);
		mav.addObject("marriage", true);

		// ModelAndView 로 페이지이동 가능
		return mav;
	}
	
	@RequestMapping("from5")
	ModelAndView from5() {
		
		Date birth = new Date(1974-1900, 3-1, 20);
		Address addr = new Address();
		addr.setZipcode("12345");
		addr.setAddr1("창원 중앙동");
		addr.setAddr2("임꺽정 옆블럭");
		
		System.out.println("from5 진입:"+birth+" , "+addr);
		
		ModelAndView mav = new ModelAndView("redirect:to");
		
		//ModelAndView 로 paramter 전달 가능
		mav.addObject("pid", "eee");
		mav.addObject("age",51);
		mav.addObject("marriage", true);

		//문자열 : "Wed Mar 20 00:00:00 KST 1974" 으로 전달
		mav.addObject("birth", birth);
		
		//개발자가 정의한 클래스 기반 객체 전달 불가
		mav.addObject("addr", addr);

		// ModelAndView 로 페이지이동 가능
		return mav;
	}
	

	@ResponseBody
	@RequestMapping("to")
	String to(Person per) {
		return "to 페이지 : "+per;
	}
}


