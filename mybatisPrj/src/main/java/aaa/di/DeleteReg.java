package aaa.di;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class DeleteReg implements MyAction{
	
	@Resource
	BoardMapper mapper;

	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		
		
		pInfo.setMainUrl("alert");
		pInfo.setMsg("암호불일치");
		pInfo.setGoUrl("/"+pInfo.getCate()+"/delete/"+pInfo.getNowPage()+"/"+dto.getId());
		
		int cnt = mapper.delete(dto);
		
		if(cnt>0) {  //삭제되었다면
			pInfo.setMsg("삭제되었습니다.");
			pInfo.setGoUrl("/"+pInfo.getCate()+"/list/"+pInfo.getNowPage());
		}
		
		
		return null;
	}
	
	

}
