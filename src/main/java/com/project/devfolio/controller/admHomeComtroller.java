package com.project.devfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admHomeComtroller {

	@RequestMapping("/adm/home/main")
	public String showMain() {
		return "adm/home/main";
	}
	
}
