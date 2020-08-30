package tuanlm.fpt.web.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tuan
 *
 */
@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/welcome", "/logoutSuccessful"})
	public String welcomePage() {
		return "welcome";
	}
	
	@RequestMapping(value = "/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value = "/register")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value = "/403")
	public String deniedPage() {
		return "403";
	}
}
