package com.shopping.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopping.project.member.MemberDAO;
import com.shopping.project.product.ProductDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDAO pDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@GetMapping("/")
	public String goIndex(HttpServletRequest req) {
		mDAO.isLogined(req);
		pDAO.get(req);
		return "index";
	}
}