package aaa.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.BoardDTO;
import aaa.model.BoardSSS;
import aaa.model.DynamicMapper;
import aaa.model.ExamDTO;
import jakarta.annotation.Resource;


@Controller
@ResponseBody
public class DynamicController {

    
	
	@Resource
	DynamicMapper mapper;

    

	@RequestMapping("/dy/list1")
	Object list1(BoardDTO dto) throws Exception {

		System.out.println("list1 : "+dto);
		return mapper.list1(dto);
	}
	
	@PostMapping("/dy/list2")
	Object list2(BoardDTO dto) throws Exception {

		System.out.println("list2 : "+dto);
		return mapper.list1(dto);
	}
	
	
	@RequestMapping("/dy/insert")
	Object insert() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("땡큐");
		dto.setPname("앤유?");
		dto.setPw("1111");
		dto.setContent("안봤어요");
		
		 mapper.insert(dto);
		
		System.out.println("insert : "+dto);
		return "insert : "+dto;
	}
	
	
	@RequestMapping("/dy/reply")
	Object reply() {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("[답변]땡큐");
		dto.setPname("[답변]앤유?");
		dto.setPw("1111");
		dto.setContent("[답변]안봤어요");
		dto.setGid(152);
		dto.setSeq(1);
		dto.setLev(1);
		
		 mapper.reply(dto);
		
		System.out.println("insert : "+dto);
		return "insert : "+dto;
	}
	
	
	@RequestMapping("/dy/exam")
	Object exam(ExamDTO dto) {

		
		return mapper.exam(dto);
	}
	
	@RequestMapping("/dy/insertList1")
	Object insertList1() {

		return mapper.insertList1();
	}
	
	@RequestMapping("/dy/insertList2")
	Object insertList2() {
		
		ArrayList<BoardDTO> arr = new ArrayList<>();
		arr.add(new BoardDTO("진주", "학생",  "박", "1111"));
		arr.add(new BoardDTO("은주", "학생2", "렛", "1111"));
		arr.add(new BoardDTO("경주", "불국사", "잇", "1111"));
		arr.add(new BoardDTO("간주", "점프",  "고", "1111"));
		
		return mapper.insertList2(arr);
	}
	
	@RequestMapping("/dy/insertList3")
	Object insertList3() {
		
		ArrayList<BoardDTO> arr = new ArrayList<>();
		
		arr.add(new BoardDTO("창원", "유비",  "피치보이즈", "1111"));
		arr.add(new BoardDTO("창투", "관우",  "피치보이즈", "1111"));
		arr.add(new BoardDTO("창쓰리","장비",  "피치보이즈", "1111"));
		
		BoardSSS bs = new BoardSSS();
		bs.setArr(arr);
		
		return mapper.insertList3(bs);
	}
	
	
	
	/// 컨트롤러 진입시 자동 실행
	@InitBinder
	void meth(WebDataBinder binder) {
		System.out.println("meth 실행");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		CustomDateEditor editor = new CustomDateEditor(sdf, true);
		
		//regDate 이름으로 오는 매개변수를 멤버변수에 대입시 문자열 --> Date.class 로 처리
		// 처리방식은 editor  ===> sdf 로 설정
		binder.registerCustomEditor(Date.class,"regDate", editor);
		
		//   localhost:8080/dy/list1?pname=%EC%9D%B4&regDate=2025-6-15
		//   2025-6-15 ===> Date 로 변형
		
	}
	
}


