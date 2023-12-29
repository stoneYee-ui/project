package com.shopping.project.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class OrderDAO {
	
	@Autowired
	private OrderRepo or;
	
	
	public void pay(Order o, HttpServletRequest req) {
		try {
			or.save(o);
			req.setAttribute("result", "등록 성공");
		} catch (Exception e) {
			req.setAttribute("result", "등록 실패");
		}
	}
	
	public void get(HttpServletRequest req) {
		req.setAttribute("orders", or.findAll());
	}
}
