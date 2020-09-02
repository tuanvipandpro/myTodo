/**
 * 
 */
package tuanlm.fpt.web.todo.controller.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.service.AccountService;

/**
 * @author Tuan
 *
 */
@Validated
@RestController
@RequestMapping(value = "/account")
public class AccountRestController {
	AccountService service;
	
	public AccountRestController(AccountService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/register-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registerAccount(@RequestBody @Valid Account account) {
		service.registerAccount(account);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}