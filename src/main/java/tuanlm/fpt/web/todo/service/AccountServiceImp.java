/**
 * The Class AccountServiceImp.
 *
 * @author Admin
 */
package tuanlm.fpt.web.todo.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.entity.AccountRole;
import tuanlm.fpt.web.todo.repository.AccountRepository;
import tuanlm.fpt.web.todo.repository.AccountRoleRepository;
import tuanlm.fpt.web.todo.utils.AppConstants;
import tuanlm.fpt.web.todo.utils.MailUtils;
import tuanlm.fpt.web.todo.utils.MathUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountServiceImp.
 */
@Service
public class AccountServiceImp implements AccountService {
	
	/** The sender. */
	private JavaMailSender sender;
	
	/** The encoder. */
	private BCryptPasswordEncoder encoder;
	
	/** The account role repository. */
	private AccountRoleRepository accountRoleRepository;
	
	/** The account repository. */
	private AccountRepository accountRepository;
	
	/**
	 * Instantiates a new account service imp.
	 *
	 * @param accountRepository the account repository
	 * @param encoder the encoder
	 */
	public AccountServiceImp(
			AccountRepository accountRepository, 
			BCryptPasswordEncoder encoder, 
			AccountRoleRepository accountRoleRepository,
			JavaMailSender sender) {
		this.accountRepository = accountRepository;
		this.encoder = encoder;
		this.accountRoleRepository = accountRoleRepository;
		this.sender = sender;
	}

	/**
	 * Register account.
	 *
	 * @param account the account
	 * @return true, if successful
	 */
	@Override
	public boolean registerAccount(Account account) {
		if (accountRepository.findByUsername(account.getUsername()) == null) {
			accountRepository.save(new Account(
					account.getUsername(), 
					encoder.encode(account.getPassword()), 
					account.getFullname(), 
					AppConstants.ACTIVE_STATUS, 
					account.getEmail()));
			accountRoleRepository.save(new AccountRole(account.getUsername(), AppConstants.MEMBER_ROLE));
			return true;
		}
		return false;
	}

	@Override
	public String checkExistAccount(String username) {
		Account account = accountRepository.findByUsername(username);
		if (account == null) {
			return null;
		} else {
			int randomCode = MathUtils.getRandomInteger();
			MailUtils.sendTextMail(sender, account.getEmail(), "myTodo | Forget Password", randomCode + "");
			return randomCode + "";
		}
		
	}

}
