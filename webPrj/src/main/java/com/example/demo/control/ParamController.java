package com.example.demo.control;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Person;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ParamController {


	@RequestMapping("/param1")
	public String param1(HttpServletRequest request) {

		System.out.println("param1 : "+
				request.getParameter("name")+","+
				request.getParameter("age")+","+
				request.getParameter("marriage")
		
				);
		return "req/param";
	}
	
	//@ResponseBody	// forwarding 하지 않고 리턴값을  client(브라우져)에 전달
	@RequestMapping("/param2")
	public String bbb(@RequestParam(name = "name")String name,
			@RequestParam(name = "age", defaultValue = "17")int asdf,   //자료형에 맞게 변환
			//int asdf = Integer.parseInt(request.getParameter("age"));
			// defaultValue = "17"  parameter가 null 인 경우 변수에 대입하는 기본값
			
			@RequestParam(name = "marriage", defaultValue = "false")boolean mmm) {
		
		//  @RequestParam  --> ModelAttribute 가 아니다. 속성으로 처리 안함

		System.out.println("param2 : "+name+","+asdf+","+mmm);

		return "req/param2";
	}
	
	
	@RequestMapping("/param3")
	public String param3(String name, int age, boolean marriage) {

		//System.out.println("param3 : "+name+","+age+","+marriage);
		return "req/param";
	}
	
	@RequestMapping("/param4")
	public String param4(Person per) {
		// 매개변수를 Person의 멤버변수로 자동대입 -> setter 필수
		// model 전달 안함
		System.out.println("param4 : "+per);
		return "req/param4";
	}
	
	@RequestMapping("/param5")
	public String param5(@ModelAttribute Person per) {
		// 매개변수를 Person의 멤버변수로 자동대입 -> setter 필수
		// @ModelAttribute : model 로 전달  --> attribute 이름 : person 
		//  매개변수 per 와 attribute 관계없음

		System.out.println("param5 : "+per);
		return "req/param5";
	}
	
	@RequestMapping("/param6")
	public String param6(@ModelAttribute("pp") Person per) {
		// 매개변수를 Person의 멤버변수로 자동대입 -> setter 필수
		// @ModelAttribute("pp") : model 로 전달  --> attribute 이름 : pp 
		//  매개변수 per 와 attribute 관계없음

		System.out.println("param6 : "+per);
		return "req/param6";
	}
	
	@GetMapping("/person")
	public String form() {
		return "req/form";
	}
	
	@PostMapping("/person")
	public String submitttt(@ModelAttribute("pp") Person per) {
		System.out.println("submitttt 실행"+per);
		return "req/submittt";
	}
	
}


///   학생 데이터(이름,국어,영어,수학,총점,평균)를 출력하세요


