package ca.ubc.cpsc.mystuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/media")
public class MediaController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadContent(Model model) {
		return "media";
	}
	
}
