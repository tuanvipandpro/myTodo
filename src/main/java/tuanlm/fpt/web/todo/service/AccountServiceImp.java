/**
 * The Class AccountServiceImp.
 *
 * @author Admin
 */
package tuanlm.fpt.web.todo.service;

import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.repository.AccountRepository;
import tuanlm.fpt.web.todo.utils.AppConstants;

@Service
public class AccountServiceImp implements AccountService {
	private BCryptPasswordEncoder encoder;
	
	/** The account repository. */
	private AccountRepository accountRepository;
	
	/**
	 * Instantiates a new account service imp.
	 *
	 * @param accountRepository the account repository
	 */
	public AccountServiceImp(AccountRepository accountRepository, BCryptPasswordEncoder encoder) {
		this.accountRepository = accountRepository;
		this.encoder = encoder;
	}

	/**
	 * Register account.
	 *
	 * @param username the username
	 * @param password the password
	 * @param fullname the fullname
	 * @param email the email
	 */
	@Override
	public boolean registerAccount(Account account) {
//		account.setStatus_id(AppConstants.ACTIVE_STATUS);
//		accountRepository.save(account);
		if (accountRepository.findByUsername(account.getUsername()) == null) {
			accountRepository.save(new Account(account.getUsername(), encoder.encode(account.getPassword()), account.getFullname(), AppConstants.ACTIVE_STATUS, account.getEmail()));
			return true;
		}
		return false;
	}

}
