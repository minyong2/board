package com.dw.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class LogsController {
	
	@GetMapping("/logs")
	public String loadLogsPage() {
		return "logs";
	}

}
