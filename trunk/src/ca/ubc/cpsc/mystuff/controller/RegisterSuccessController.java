package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterSuccessController {
	
	@RequestMapping("/registerSuccess.do")
	public String redirect() {
		return("registerSuccess");
	}
}
