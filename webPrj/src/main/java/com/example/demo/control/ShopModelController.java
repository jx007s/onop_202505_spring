package com.example.demo.control;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.HandPhone;

@Controller
@RequestMapping("/shop")
public class ShopModelController {
	
	@ModelAttribute("menus")
	Map<String, String> menus(){
		Map<String, String> res = new LinkedHashMap<>();
		res.put("info", "회사소개");
		res.put("product?name=어른폰&price=80", "제품");
		res.put("gall", "갤러리");
		res.put("center", "고객센터");
		
		return res;
	}

	
	@RequestMapping("info")
	String info(Model mm) {
		mm.addAttribute("service", "info");
		return "shop/template";
	}
	
	@RequestMapping("product")
	String product(Model mm, HandPhone ph) {
		mm.addAttribute("service", "product");
		return "shop/template";
	}
	
	
	@RequestMapping("gall")
	String gall(Model mm) {
		mm.addAttribute("service", "gall");
		return "shop/template";
	}
	
	@RequestMapping("center")
	String center(Model mm) {
		mm.addAttribute("service", "center");
		return "shop/template";
	}
}
