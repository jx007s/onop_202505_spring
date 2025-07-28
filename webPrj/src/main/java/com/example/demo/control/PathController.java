package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.PathInfo;

@Controller
@RequestMapping("/path/{cate}")
public class PathController {
	
	@ModelAttribute("aaa")
	Object meth_1(@PathVariable("cate") String cate,  //반드시 필수
												// required = false 필수가 아님
			      @PathVariable(value="service", required = false) String service,
			      @PathVariable(value="bid", required = false) Integer bid) {
		
		System.out.println("meth_1 : "+cate+","+service);
		
		PathInfo res = new PathInfo();
		res.setCate(cate);
		res.setService(service);
		res.setBid(bid);
		
		return res;
	}
	
	@ModelAttribute("bbb")
	Object meth_2(PathInfo pi) {  
		// 멤버변수에  @PathVariable 항목으로 대입
		// PathInfo pi 가 model pathInfo로 설정
					
		System.out.println("meth_2 : "+pi);
		
		//bbb 와  pathInfo 가 같다
		return pi;
	}
	
	//      {cate}
	// path/event
	@RequestMapping  
	String view(@ModelAttribute("ppi") PathInfo pi) {
		System.out.println("view : "+pi);
		return "pathView";
	}
	
	//      {cate}/{service}
	// path/info/hello
	@RequestMapping("{service}")
	String view1( ) {
		System.out.println("view1 : ");
		return "pathView";
	}
	
	//      {cate}/{service}/bid
	// path/product/detail/34
	@RequestMapping("{service}/{bid}")
	String view2(@PathVariable("bid") int bid) {
		System.out.println("view2 : "+bid);
		return "pathView";
	}
}


/*
회사소개     제품      고객센터
-------------------------------
   인사말     TV       공지사항
   연혁      핸드폰     질문및답변
   오시는길            



주메뉴 -   회사소개     제품      고객센터
-----------------------------------------------
서브메뉴 |
       |     메인(data)
       |
       |


* */
