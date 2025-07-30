package aaa.controller;

import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.ProductDTO;
import aaa.model.PageInfo;
import aaa.model.ProductMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product/{service}/{nowPage}")
public class ProductController {
	
	@Resource
	ProductMapper mapper;
	

	@ModelAttribute("mainData")
	Object pInfoGo(@ModelAttribute("pInfo") PageInfo pInfo, 
			       @ModelAttribute("dto") ProductDTO dto, 
			       HttpServletRequest request) {
		
		pInfo.setCate("product");
		
		
		
		System.out.println("pInfoGo : "+pInfo);
		System.out.println("pInfoGo=> dto : "+dto);
	
		//list
		if(pInfo.getService().equals("list")) {
			return mapper.list();
		}
		
		
		//detail , modify
		if(pInfo.getService().equals("detail") || pInfo.getService().equals("modify")) {
			return mapper.detail(dto.getId());
		}
		
		
		//insertReg
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
			pInfo.setGoUrl("/"+pInfo.getCate()+"/list/"+pInfo.getNowPage());
			
			
		}
		
		
		//deleteReg
		if(pInfo.getService().equals("deleteReg")) {
			
			pInfo.setMainUrl("alert");
			pInfo.setMsg("암호불일치");
			pInfo.setGoUrl("/"+pInfo.getCate()+"/delete/"+pInfo.getNowPage()+"/"+dto.getId());
			
			int cnt = mapper.delete(dto);
			
			if(cnt>0) {  //삭제되었다면
				pInfo.setMsg("삭제되었습니다.");
				pInfo.setGoUrl("/"+pInfo.getCate()+"/list/"+pInfo.getNowPage());
			}
		}
		
		
		//modifyReg
		if(pInfo.getService().equals("modifyReg")) {
			
			pInfo.setMainUrl("alert");
			pInfo.setMsg("암호불일치");
			pInfo.setGoUrl("/"+pInfo.getCate()+"/modify/"+pInfo.getNowPage()+"/"+dto.getId());
			
			int cnt = mapper.modify(dto);
			
			if(cnt>0) {  //수정되었다면
				pInfo.setMsg("수정되었습니다.");
				pInfo.setGoUrl("/"+pInfo.getCate()+"/detail/"+pInfo.getNowPage()+"/"+dto.getId());
			}
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
