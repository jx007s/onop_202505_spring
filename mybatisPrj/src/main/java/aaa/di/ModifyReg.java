package aaa.di;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class ModifyReg implements MyAction{
	
	@Resource
	BoardMapper mapper;

	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		
		pInfo.setMainUrl("alert");
		pInfo.setMsg("암호불일치");
		pInfo.setGoUrl("/"+pInfo.getCate()+"/modify/"+pInfo.getNowPage()+"/"+dto.getId());
		
		int cnt = mapper.modify(dto);
		
		if(cnt>0) {  //수정되었다면
			pInfo.setMsg("수정되었습니다.");
			pInfo.setGoUrl("/"+pInfo.getCate()+"/detail/"+pInfo.getNowPage()+"/"+dto.getId());
		}
		
		return null;
	}

}
