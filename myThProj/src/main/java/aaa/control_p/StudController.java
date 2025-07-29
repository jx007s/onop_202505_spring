package aaa.control_p;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.Stud;

@Controller
public class StudController {

	@RequestMapping("/")
	String exam(Model mm) {
		Stud st = new Stud("잘봐요",87,76,91);
		mm.addAttribute("st", st);
		System.out.println("왜? 어째서?"+st);
		
		return "exam";
	}
	
	@ResponseBody
	@RequestMapping("/arr")
	String arr(@RequestParam("no")int no) {
		
		String [] arr = {"해운대","달운대","별운대","왜운대","그만운대"};
		return "arr["+no+"] : "+arr[no];
	}
	
	@ResponseBody
	@RequestMapping("/div")
	String div(@RequestParam("no")int no) {
		
		
		return "div : "+  1234/no;
	}
}
