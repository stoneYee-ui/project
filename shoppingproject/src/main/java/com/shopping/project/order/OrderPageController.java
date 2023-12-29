package com.shopping.project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopping.project.member.MemberDAO;
import com.shopping.project.product.ProductDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class OrderPageController{
	
	@Autowired
	private ProductDAO pDAO;
	
	@Autowired
	private OrderDAO oDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@GetMapping("/order.do")
	public String orderDo(Order o, HttpServletRequest req) {
		oDAO.pay(o, req);
		mDAO.isLogined(req);
		pDAO.get(req);
		return "index";
	}
	@GetMapping("/order.go")
	public String orderGo(Order o, HttpServletRequest req) {
		oDAO.get(req);
		pDAO.get(req);
		mDAO.isLogined(req);
		return "order/orderDetail";
	}
}
