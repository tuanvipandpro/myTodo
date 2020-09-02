package tuanlm.fpt.web.todo.service;

import tuanlm.fpt.web.todo.entity.Account;

/**
 * The Interface AccountService.
 */
public interface AccountService {
	
	/**
	 * Register account.
	 *
	 * @param account the account
	 * @return boolean
	 */
	boolean registerAccount(Account account);
	
	/**
	 * Check exist account.
	 *
	 * @param username the username
	 * @return the string
	 */
	String checkExistAccount(String username);
}
