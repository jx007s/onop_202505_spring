package com.example.demo.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
class MyAddr{

	@Min(10000)
	@Max(99999)
	Integer zipcode;
	
	@NotEmpty(message = "기본주소확인")
	String addr1;
	
	@NotBlank
	String addr2;
}


@Data
public class Human {

	//유효성검사 정의
	@NotEmpty(message = "아이디를 입력하세요")
	@Size(min=3,max=10)  // message 를 입력하지 않을 경우 기본값 : "크기가 3에서 10 사이여야 합니다"
	String pid;
	
	@Size(min=4,max=15, message = "4~15 암호입력요")
	String pw1;
	
	@NotEmpty(message = "비밀번호 확인 입력요망")
	String pw2;
	
	@NotEmpty  // 비어 있을 수 없습니다
	String pname = "aaaa";
	
	//이메일형식
	@Email
	String email;
	
	// regexp : javascript의 유효성 패턴 규칙
	@Pattern(regexp="^01[0-9]{1}-\\d{3,4}-[0-9]{4}$", message="핸드폰 번호가 아닙니다.")
	String phone;
	
	
	
	//  멤버로 클래스(인스턴스로 작동시) @Valid를 이용하여 멤버필드도 유효성 검사토록 함
	@Valid
	MyAddr ma;
	
	
	String hobby="netflix", job="독립의사";
	
	
	
	boolean marriage = false;
	
	public Map<String, String> getHobbyMap(){
		Map<String, String> res = new LinkedHashMap<String, String>();
		res.put("bass","베이스기타");
		res.put("netflix","넷플릭스");
		res.put("drink","술");
		res.put("zumba","줌바");
		
		return res;
	}
	
	String [] menu;
	String [] menus = {"찜닭","양꼬치","돈가스","짜장면"};
	String [] jobs = {"의사","장의사","독립의사","한의사","수의사"};
	
	
	public ArrayList<String> getArChoice(){
		ArrayList<String> res = new ArrayList<>();
		res.add("찜닭");
		res.add("돈가스");
		return res;
	} 
	
	
}
