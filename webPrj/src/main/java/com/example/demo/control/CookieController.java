package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Person;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/coo")
public class CookieController {

	@RequestMapping("make")
	@ResponseBody
	String make1(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid", "aaa"));
		//response.addCookie(new Cookie("cnt", 1234));
		response.addCookie(new Cookie("cnt", "1234"));
		
		return "쿠키생성";
	}
	
	
	@RequestMapping("view")
	@ResponseBody
	String view(
			@CookieValue(value="pid", defaultValue = "없음")String pid,
			@CookieValue(value="cnt", defaultValue = "0")int cnt,
			@CookieValue(value="mil", defaultValue = "false")boolean mil) {

		return "쿠키보기 : "+pid+","+cnt+","+mil;
	}
	
	
	@RequestMapping("modify")
	@ResponseBody
	String make2(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid", "bbb"));
		response.addCookie(new Cookie("mil", "true"));
		
		return "쿠키수정";
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	String delete(HttpServletResponse response) {
		Cookie coo = new Cookie("pid", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		coo = new Cookie("cnt", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		coo = new Cookie("mil", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		
		return "쿠키삭제";
	}
	
	
	@GetMapping("logMain")
	@ResponseBody
	String  logForm(
			@CookieValue(value="pid", defaultValue = "")String pid,
			@CookieValue(value="pname", defaultValue = "")String pname
			
			) {

		String ttt = "<h2>로그인메인</h2>";
		if(pid.equals("")) {
			ttt += "<form method='post'>";
			ttt += "id <input name='pid'/>";
			ttt += "암호 <input name='pw'/>";
			ttt += "<input type='submit' value='로그인'/>";
			ttt += "</form>";
		}else {
			ttt += pname+"님 안녕하세요";
			ttt += "<a href='logout'>로그아웃</a>";
		}
		return ttt;
	}
	
	
	@PostMapping("logMain")
	@ResponseBody
	String  logReg(HttpServletResponse response, Person per) {

		System.out.println(per);
		String ttt = "<script>";
		String msg = "로그인실패";
		if(per.getPid().equals("aaa") && per.getPw().equals("1234")) {
			msg = "로그인성공";
			response.addCookie(new Cookie("pid", "aaa"));
			response.addCookie(new Cookie("pname", "장동건"));
		}
		ttt += "alert('"+msg+"'); ";
		ttt += "location.href='logMain'; ";
		ttt += "</script>";
		return ttt;
	}
	
	
	
	@RequestMapping("logout")
	@ResponseBody
	String logout(@CookieValue(value="pname", defaultValue = "")String pname, 
			HttpServletResponse response) {
		Cookie coo = new Cookie("pid", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		coo = new Cookie("pname", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		String ttt = "<script>";
		ttt += "alert('"+pname+"로그아웃 하였습니다.'); ";
		ttt += "location.href='logMain'; ";
		ttt += "</script>";
		
		return ttt;
	}
}
