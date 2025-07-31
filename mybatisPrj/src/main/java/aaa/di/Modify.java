package aaa.di;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class Modify implements MyAction{
	
	@Resource
	BoardMapper mapper;

	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return mapper.detail(dto.getId());
	}
}
