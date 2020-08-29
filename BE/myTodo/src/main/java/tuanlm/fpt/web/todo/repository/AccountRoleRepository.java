/**
 * 
 */
package tuanlm.fpt.web.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tuanlm.fpt.web.todo.entity.AccountRole;

/**
 * @author Tuan
 *
 */

public interface AccountRoleRepository extends JpaRepository<AccountRole, Integer> {
	List<AccountRole> findByUsername(String username);
}
