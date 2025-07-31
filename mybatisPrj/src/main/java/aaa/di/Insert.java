package aaa.di;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.PageInfo;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class Insert implements MyAction{
	
	
	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		
		return null;
	}

}
