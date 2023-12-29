package com.shopping.project.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shopping.project.product.ProductDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	@GetMapping("/join.go")
	public String joinGo(HttpServletRequest req) {
		pDAO.get(req);
		mDAO.isLogined(req);
		return "member/joinForm";
	}
	
	@GetMapping("/logout.do")
	public String logoutDo(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		pDAO.get(req);
		return "index";
	}
	
	@PostMapping("/join.do")
	public String joinDo(Member m,HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.isLogined(req);
		pDAO.get(req);
		return "index";
	}
	
	@PostMapping("/login.do")
	public String loginDo(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		pDAO.get(req);
		return "index";
	}
	
	
}
