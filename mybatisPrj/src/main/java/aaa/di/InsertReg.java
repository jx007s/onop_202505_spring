package aaa.di;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class InsertReg implements MyAction{
	
	@Resource
	BoardMapper mapper;

	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		
		
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
		
		
		return null;
	}
	
	

}
