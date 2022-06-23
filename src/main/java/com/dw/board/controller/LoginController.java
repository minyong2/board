package com.dw.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/health")
public class LoginController {

	@GetMapping("/login")
	public String callLoginPage() {
		return "login";
	}
	
	@GetMapping("join")
	public String callJoinPage() {
		return "join";
	}
//	
//	@GetMapping("/logout")
//	public String callLoginout(HttpSession httpSession) {
//		// 세션 remove
//		httpSession.removeAttribute("studentsId");
//		httpSession.removeAttribute("studentsName");
//		return "login";
//	}
	
}