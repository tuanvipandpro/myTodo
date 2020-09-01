/**
 * 
 */
package tuanlm.fpt.web.todo.controller.api;

import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tuan
 *
 */
@Validated
@RestController
public class AccountRestController {
//	private JavaMailSender sender;
//	
//	public AccountRestController(JavaMailSender sender) {
//		this.sender = sender;
//	}
	
//	public String forgetPassword() {
//		return 
//	}
	
	@RequestMapping(value = "/register-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> registerAccount(@RequestParam(name = "fullname") @NotBlank(message = "Fullnam empty !") String fullname) {
		
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
