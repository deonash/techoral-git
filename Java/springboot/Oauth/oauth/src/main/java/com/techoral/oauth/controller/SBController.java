package com.techoral.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SBController {

	@GetMapping("/")
	public String home() {
		return "hello techoral";
	}

	@GetMapping("/secured/api")
	public String securedAPI() {
		return "Hello Secured API";
	}

}
