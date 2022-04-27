package com.training.web.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@GetMapping("/regularuser")
	public String welcome()
	{
		return "welcome user";
	}
	@GetMapping("/admin")
	public String welcome2()
	{
		return "welcome admin!!";
	}
}
