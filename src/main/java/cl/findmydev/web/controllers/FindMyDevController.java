package cl.findmydev.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/findmydev")
public class FindMyDevController {

	@GetMapping("")
	public String mostrarIndex() {
		return "findmydev.jsp";
	}
}
