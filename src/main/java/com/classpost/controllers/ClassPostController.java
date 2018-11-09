package com.classpost.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassPostController {
	
	@RequestMapping("/")
	public String home() {
		return "Bem Vindo";
	}

}
