package aaa.controller;

import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/layout/{service}/{nowPage}")
public class LayoutController {
	
	@Resource
	BoardMapper mapper;
	

	@ModelAttribute("mainData")
	Object pInfoGo(@ModelAttribute("pInfo") PageInfo pInfo, 
					BoardDTO dto, HttpServletRequest request) {
		
		System.out.println("pInfoGo : "+pInfo);
		System.out.println("pInfoGo=> dto : "+dto);
	
		if(pInfo.getService().equals("list")) {
			return mapper.list();
		}
		
		if(pInfo.getService().equals("detail")) {
			return mapper.detail(dto.getId());
		}
		if(pInfo.getService().equals("insertReg")) {
			
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
			
			pInfo.setMainUrl("alert");
			pInfo.setMsg("작성되었습니다."+cnt);
			pInfo.setGoUrl("/layout/list/"+pInfo.getNowPage());
			
			
		}
		
		return null;
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
