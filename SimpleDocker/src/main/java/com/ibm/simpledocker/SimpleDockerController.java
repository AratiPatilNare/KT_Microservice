package com.ibm.simpledocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleDockerController {
	
	@GetMapping("/message")
	public String getMessage() {
		
		return "Welcome to Docker";
	}

}
