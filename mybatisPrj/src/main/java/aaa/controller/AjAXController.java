package aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjAXController {

	@RequestMapping("/join")
	String join() {
		return "ajax/join";
	}
}
