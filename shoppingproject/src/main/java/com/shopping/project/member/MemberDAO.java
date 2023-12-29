package com.shopping.project.member;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class MemberDAO {
	
	@Autowired
	private MemberRepo mr;
	
	private SimpleDateFormat sdf;
	
	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}
	
	public void join(Member m, HttpServletRequest req) {
		try {
			String jumin1 = req.getParameter("psm_jumin1");
			int jumin2 = Integer.parseInt(req.getParameter("psm_jumin2"));
			if (jumin2 > 2) {
				jumin1 = "20" + jumin1;
			} else {
				jumin1 = "19" + jumin1;
			}
			m.setPsm_birthday(sdf.parse(jumin1));
			String addr1 = req.getParameter("psm_address1");
			String addr2 = req.getParameter("psm_address2");
			String addr3 = req.getParameter("psm_address3");
			m.setPsm_address(addr2 + "!" + addr3 + "!" + addr1);
			mr.save(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/logined");
			req.setAttribute("login", "logined");
			return true;
		}
		req.setAttribute("loginPage", "member/loginForm");
		req.setAttribute("login", "login");
		return false;
	}
	
	public void login(Member m, HttpServletRequest req) {
		try {
			Member dbMember = mr.findById(m.getPsm_id()).get();
			if (dbMember != null) {
				if (m.getPsm_pw().equals(dbMember.getPsm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.setAttribute("name", dbMember.getPsm_name());
				} else {
					req.setAttribute("result", "로그인 실패[pw]");
				}
			} else {
				req.setAttribute("result", "로그인 실패[미가입id]");
			}
		} catch (Exception e) {
			req.setAttribute("result", "로그인 실패[DB서버]");
		}
	}
	
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
}
