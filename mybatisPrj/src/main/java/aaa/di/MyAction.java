package aaa.di;

import aaa.model.BoardDTO;
import aaa.model.PageInfo;
import jakarta.servlet.http.HttpServletRequest;

public interface MyAction {
	
	Object execute(PageInfo pInfo, 
		           BoardDTO dto, 
		           HttpServletRequest request);
}
