package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.BuyOrder;

@Controller
@RequestMapping("/buyOrder")
public class BuyOrderController {

   
	@RequestMapping(method = RequestMethod.GET)
	String form() {
		return "req/buyOrderForm";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	String complete(BuyOrder bo) {
		System.out.println("complete : "+bo);
		return "req/buyOrderReg";
	}
}
