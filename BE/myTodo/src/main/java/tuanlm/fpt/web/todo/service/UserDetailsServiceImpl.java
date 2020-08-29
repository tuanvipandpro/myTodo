/**
 * 
 */
package tuanlm.fpt.web.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Account;
import tuanlm.fpt.web.todo.entity.AccountRole;
import tuanlm.fpt.web.todo.repository.AccountRepository;
import tuanlm.fpt.web.todo.repository.AccountRoleRepository;
import tuanlm.fpt.web.todo.repository.RoleRepository;

/**
 * @author Tuan
 *
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private AccountRoleRepository accountRoleRepository;

	/**
	 * @param accountRepository
	 * @param roleRepository
	 * @param accountRoleRepository
	 */
	public UserDetailsServiceImpl(
			AccountRepository accountRepository, 
			RoleRepository roleRepository,
			AccountRoleRepository accountRoleRepository) {
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
		this.accountRoleRepository = accountRoleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = this.accountRepository.findByUsername(username);
		
		if (account == null) {
			throw new UsernameNotFoundException("Account " + username + " was not found !!!");
		}
		
		List<String> rolesList = getRoleList(username);
		
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		if (rolesList != null && !rolesList.isEmpty()) {
			rolesList.forEach(role -> {
				grantList.add(new SimpleGrantedAuthority(role));
			});
		}
		
		return (UserDetails) new User(account.getUsername(), account.getPassword(), grantList);
	}
	
	private List<String> getRoleList(String username) {
		List<AccountRole> listRoleId = accountRoleRepository.findByUsername(username);
		
		if (listRoleId != null) {
			List<String> list = new ArrayList<String>();
			
			listRoleId.forEach(accountRole -> {
				list.add(roleRepository.findById(accountRole.getRole_id()).getRole());
			});
			
			return list;
		}
		
		return null;
	}
}
