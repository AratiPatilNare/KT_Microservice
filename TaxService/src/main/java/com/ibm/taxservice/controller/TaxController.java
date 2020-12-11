package com.ibm.taxservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class TaxController {
	private static Logger logger= LoggerFactory.getLogger(TaxController.class);
	
	@GetMapping("/tax/{name}")
	public Long getTax(@PathVariable(value="name") String name) {
		logger.info("Inside TaxController:"+name);
		
		
			if(name.equals("Apple")){
				return 10L;
			}else if (name.equals("Orange")) {
			     return 8L;
			}		
			else {
			return 5L;
			}
	}

}
