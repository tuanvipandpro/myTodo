/**
 * 
 */
package tuanlm.fpt.web.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuanlm.fpt.web.todo.entity.Account;

/**
 * @author Tuan
 *
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	Account findByUsername(String username);
}
