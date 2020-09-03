/**
 * 
 */
package tuanlm.fpt.web.todo.controller.api;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.service.AccountService;

/**
 * The Class AccountRestController.
 *
 * @author Tuan
 */
@Validated
@RestController
@RequestMapping(value = "/account")
public class AccountRestController {
	
	/** The service. */
	AccountService service;
	
	/**
	 * Instantiates a new account rest controller.
	 *
	 * @param service the service
	 */
	public AccountRestController(AccountService service) {
		this.service = service;
	}
	
	/**
	 * Check exist account.
	 *
	 * @param username the username
	 * @return the response entity
	 */
	@GetMapping(value = "/check-exist-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> checkExistAccount(@RequestParam @NotBlank(message = "Username is empty !") String username) {
		String verifyCode = service.checkExistAccount(username);
		if (verifyCode != null) {
			return new ResponseEntity<String>(verifyCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(verifyCode, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Register account.
	 *
	 * @param account the account
	 * @return the response entity
	 */
	@PostMapping(value = "/register-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registerAccount(@RequestBody @Valid Account account) {
		if (service.registerAccount(account)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}