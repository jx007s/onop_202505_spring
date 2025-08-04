package aaa.di;

import org.springframework.stereotype.Component;

import aaa.model.BoardDTO;
import aaa.model.BoardMapper;
import aaa.model.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class List implements MyAction{
	
	@Resource
	BoardMapper mapper;

	@Override
	public Object execute(PageInfo pInfo, BoardDTO dto, HttpServletRequest request) {
		// TODO Auto-generated method stub
		pInfo.setTotalCnt(mapper.totalCnt());
		return mapper.list2(pInfo);
	}
}
