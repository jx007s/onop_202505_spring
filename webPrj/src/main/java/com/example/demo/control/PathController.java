package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path/{cate}/{service}")
public class PathController {
	
	@ModelAttribute("aaa")
	Object meth_1(@PathVariable("cate") String cate, 
			      @PathVariable("service") String service) {
		
		System.out.println("meth_1 : "+cate+","+service);
		return "뭐냐";
	}

	@RequestMapping
	String view() {
		return "pathView";
	}
}
