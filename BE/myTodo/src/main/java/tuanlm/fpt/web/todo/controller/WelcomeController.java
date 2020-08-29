package tuanlm.fpt.web.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tuan
 *
 */
@Controller
public class WelcomeController {
	
	@RequestMapping(value = {"/", "/welcome"})
	public String welcomePage() {
		return "welcome";
	}
}
