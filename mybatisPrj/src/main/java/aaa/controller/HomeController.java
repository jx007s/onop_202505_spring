package aaa.controller;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@Resource
	BoardMapper mapper;

	@RequestMapping("/")
	String home(Model mm) {
		List<BoardDTO> arr = mapper.list(); 
		System.out.println("home 진입:"+arr);
		mm.addAttribute("mainData", arr);
		return "index";
	}
	
	
	@RequestMapping("/detail/{no}")
	String detail(Model mm, @PathVariable("no") int no) {
		
		System.out.println("detail 진입:"+no);
		mm.addAttribute("dto", mapper.detail(no));
		return "detail";
	}
	
	@GetMapping("/insert")
	String insertForm() {
		
		return "insertForm";
	}
	
	@PostMapping("/insert")
	String insertReg(Model mm,BoardDTO dto, HttpServletRequest request) {
		
		System.out.println("insertReg 진입:"+dto);
		
		//파일 저장
		String dirPath = request.getServletContext().getRealPath("fff")+"\\";
		dirPath = "D:\\public\\onop\\onop2025_05\\public\\study\\spring_work\\mybatisPrj\\src\\main\\resources\\static\\fff\\";
		
		try {
			
			if(!dto.getUpFF().isEmpty()) {
				FileOutputStream fos = new FileOutputStream(dirPath+dto.getUpFF().getOriginalFilename());
				fos.write(dto.getUpFF().getBytes());
				fos.close();
				
				//파일이름 넣기
				dto.setUpfile(dto.getUpFF().getOriginalFilename());
			}else {
				System.out.println("파일없어");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cnt = mapper.insert(dto);
		
		PageInfo pInfo = new PageInfo();
		pInfo.setMsg("작성되었습니다."+cnt);
		pInfo.setGoUrl("/");
		mm.addAttribute("pInfo", pInfo);
		return "alert";
	}
}
