package tuanlm.fpt.web.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuanlm.fpt.web.todo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findById(int id);
}
