package com.example.demo.control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Person;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {



	@GetMapping
	String form() {
		return "req/fileForm";
	}
	
	@PostMapping
	String complete(Person per, HttpServletRequest request) {
		System.out.println("file complete : "+per);
		
		
		System.out.println(per.getUpfile().getOriginalFilename());
		System.out.println(per.getUpfile().getName());
		System.out.println(per.getUpfile().getSize());
		System.out.println(per.getUpfile().isEmpty());
		
		String dirPath = request.getServletContext().getRealPath("fff")+"\\";
		dirPath = "D:\\public\\onop\\onop2025_05\\public\\study\\spring_work\\webPrj\\src\\main\\resources\\static\\fff\\";
		
		try {
			FileOutputStream fos = new FileOutputStream(dirPath+per.getUpfile().getOriginalFilename());
			fos.write(per.getUpfile().getBytes());
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "req/fileReg";
		
		/*
		  회원가입을 구현하세요
		  필수요소 id, 이름, 기본주소,상세주소, 사진(이미지 파일만 업로드) 해주세요
		  
		  
		 * */
		
	}
	
}
