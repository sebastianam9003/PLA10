package com.trifulcas.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

	@GetMapping("/formlogin")
	public String formLogin() {
		return "login";
	}
	
	@GetMapping("/prohibido")
	public String prohibido() {
		return "prohibido";
	}
	
}
