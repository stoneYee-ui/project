package com.shopping.project.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {
	
	@GetMapping("/payment.do")
	public String paymentDo(HttpServletRequest req) {
		return "payment";
	}
}
