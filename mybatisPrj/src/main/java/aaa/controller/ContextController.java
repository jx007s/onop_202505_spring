package aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.di.MyAction;
import aaa.di.MyProvider;
import aaa.model.BoardDTO;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/context/{service}/{nowPage}")
public class ContextController {
	
	@Resource
	MyProvider myProvider;


	@ModelAttribute("mainData")
	Object pInfoGo(@ModelAttribute("pInfo") PageInfo pInfo, 
			       @ModelAttribute("dto") BoardDTO dto, 
			       HttpServletRequest request) {
		
		pInfo.setCate("context");
			
		System.out.println("pInfoGo : "+pInfo);
		System.out.println("pInfoGo=> dto : "+dto);
	
		return myProvider.getContext().getBean(pInfo.getService(), MyAction.class).execute(pInfo, dto, request);
	}
	

	@RequestMapping
	String view1() {
		return "template";
	}
	
	@RequestMapping("{id}")
	String view2() {
		return "template";
	}
}
