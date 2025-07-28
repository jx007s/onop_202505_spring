package com.example.demo.control;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ModelAttribute("sides")
	Map<String, String> sides(@PathVariable("cate") String cate){
		
		Map<String, String> info = new LinkedHashMap<>();
		info.put("hello", "인사말");
		info.put("history", "연혁");
		info.put("location", "오시는길");
		
		Map<String, String> product = new LinkedHashMap<>();
		product.put("tv", "TV");
		product.put("handPhone", "핸드폰");
		
		Map<String, String> center = new LinkedHashMap<>();
		center.put("notice", "공지사항");
		center.put("fnq", "질문및답변");
		
		
		
		Map<String, Map<String, String>> res = new LinkedHashMap<>();
		res.put("info", info);
		res.put("product", product);
		res.put("center", center);
		
		return res.get(cate);
	}
	
	
	@RequestMapping
	String view(PathInfo pi) {
		return "path/template";
	}

}
