/**
 * The Class AccountServiceImp.
 *
 * @author Admin
 */
package tuanlm.fpt.web.todo.service;

import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.repository.AccountRepository;
import tuanlm.fpt.web.todo.utils.AppConstants;

@Service
public class AccountServiceImp implements AccountService {
	
	/** The account repository. */
	private AccountRepository accountRepository;
	
	/**
	 * Instantiates a new account service imp.
	 *
	 * @param accountRepository the account repository
	 */
	public AccountServiceImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
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
	public void registerAccount(Account account) {
		account.setStatus_id(AppConstants.ACTIVE_STATUS);
		accountRepository.save(account);
	}

}
