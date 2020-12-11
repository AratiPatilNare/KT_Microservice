package com.ibm.FirstService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class FirstController {
	
	@Value("${msg}")
	private String message;
	
	@GetMapping("/test")
	public String hello() {
		
		return "welcome to spring boot: Boot camp session: second day";
	}
	  
	@GetMapping ("/message")
	public String getMessage() {
		
		return this.message;
	}
}
