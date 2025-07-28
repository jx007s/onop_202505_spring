package com.example.demo.control;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.PathInfo;

@Controller
@RequestMapping("/pathShop/{cate}/{service}")
public class PathShopController {
	/*
	회사소개     제품      고객센터
	-------------------------------
	   인사말     TV       공지사항
	   연혁      핸드폰     질문및답변
	   오시는길            
*/
	
	@ModelAttribute("menus")
	Map<String, String> menus(){
		Map<String, String> res = new LinkedHashMap<>();
		res.put("info/hello", "회사소개");
		res.put("product/tv", "제품");
		res.put("center/notice", "고객센터");
		
		return res;
	}
	
	@RequestMapping
	String view(PathInfo pi) {
		return "path/template";
	}

}
