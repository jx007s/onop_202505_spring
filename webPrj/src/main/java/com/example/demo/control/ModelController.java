package com.example.demo.control;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Address;
import com.example.demo.model.HandPhone;
import com.example.demo.model.Person;
import com.example.demo.model.Stud;

import jakarta.annotation.Resource;

@Controller
@RequestMapping("/mmm")
public class ModelController {
	

	@Resource
	//@ModelAttribute  멤버변수에 직접 model 설정 불가  
	HandPhone phone;

	// arr 로 model 설정
	// @ModelAttribute("arr")--> 컨트롤러 접근시 자동 실행
	@ModelAttribute("arr")
	int [] meth_1() {
		int [] res = {11,22,33,44};
		System.out.println("meth_1() 실행 : "+Arrays.toString(res)+phone);
		return res;
	}
	
	// model 이름 기본값 : 리턴형
	@ModelAttribute
	Address meth_2(Stud st) {
		st.calc();
		Address res = new Address();
		res.setZipcode("145236");
		res.setAddr1("경남 진주시");
		res.setAddr2("네 진주목걸이");
		System.out.println("meth_2() 실행 : "+res);
		return res;
	} 
	
	//@ModelAttribute  --  Address meth_2(Stud st) 의 st 와 
	// stud 이름이 중첩되어 model 설정하므로 우선순위를 알 수 없으므로 정확한 bean 사용이 될 수 잆다
	// 중첩되지 않게 하기 위해 model 이름을 명확히 한다
	@ModelAttribute("stCha")
	Stud meth_3() {
		Stud res = new Stud();
		res.setPname("차소현");
		res.setKor(88);
		res.setEng(78);
		res.setMat(91);
		res.calc();
		return res;
	}
	
	
	@ModelAttribute
	HandPhone meth_4() {
		
		System.out.println("meth_4() 실행 : ");
		
		//bean 으로 받은 멤버변수를 model로 사용한다.
		return phone;
	} 
	

	@RequestMapping("list")
	String list(Model mm, Person per) {
		mm.addAttribute("df", "고추잠자리");
		return "mmm/list";
	}
	
	@RequestMapping("detail")
	String detail(Model mm) {
		mm.addAttribute("elsa", "박렛잇고");
		return "mmm/detail";
	}
}
