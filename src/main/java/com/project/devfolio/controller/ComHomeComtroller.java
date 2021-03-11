package com.project.devfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ComHomeComtroller {

	@RequestMapping("/com/home/main")
	public String showMain() {
		return "com/home/main";
	}
	
}
