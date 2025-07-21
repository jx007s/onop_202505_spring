package aaa.control_p;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
