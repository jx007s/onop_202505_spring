package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.model.Human;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/thyme/validate")
public class ValidateController {


	@GetMapping
	String form(Human hm) {  
		// Human hm -- validateForm.html 에서 field나 fields.hasErrors에서 human 을 찾기때문
		
		return "/thyme/validateForm";
	}
	
	
	@PostMapping
	// @Valid 유효성 검사 하라는 어노테이션
	// Human hm 에서 에러점검
	// 에러결과를 BindingResult brt에 전달
	String submittt(@Valid Human hm, BindingResult brt) {
	
		// 에러가 있을 경우 brt.hasErrors() 에서 true 리턴
		System.out.println("submittt 진입 : "+brt.hasErrors());
		
		//암호 일치 검사
		if(!hm.getPw1().equals(hm.getPw2())) {
			//일치하지 않을 경우 에러결과를 수동으로 넣는다.
			brt.rejectValue("pw2", null,"암호가 일치하지 않습니다.");
						// 필드명, 에러코드,   에러메세지
		}
		
		
		// 에러가 있으면 입력 폼으로 view 변경
		if(brt.hasErrors()) {
			return "/thyme/validateForm";
		}
		
		
		
		return "/thyme/validatePost";
	}
}
