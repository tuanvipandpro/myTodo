package tuanlm.fpt.web.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class PageController.
 *
 * @author Tuan
 */
@Controller
public class PageController {
	
	/**
	 * Welcome page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = {"/", "/welcome", "/logoutSuccessful"})
	public String welcomePage() {
		return "welcome";
	}
	
	/**
	 * Home page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/home")
	public String homePage() {
		return "home";
	}
	
	/**
	 * Register page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/register")
	public String registerPage() {
		return "register";
	}
	
	/**
	 * Denied page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/403")
	public String deniedPage() {
		return "403";
	}
	
	/**
	 * Forget page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/forget")
	public String forgetPage() {
		return "forget";
	}
}
