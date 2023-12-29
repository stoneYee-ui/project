package com.shopping.project.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.project.member.MemberDAO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private ProductDAO pDAO;
	
	@GetMapping("/product.go")
	public String productGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		pDAO.get(req);
		return "product/productReg";
	}
	
	@PostMapping("/product.do")
	public String productDo(@RequestParam("picc")MultipartFile mf, Product p, HttpServletRequest req) {
		pDAO.reg(mf, p, req);
		pDAO.get(req);
		mDAO.isLogined(req);
		return "index";
	}
	
	@GetMapping("/pic/{fileNamee}")
	public @ResponseBody Resource picGet(@PathVariable("fileNamee") String f) {
		return pDAO.getImageFile(f);
	}
}
