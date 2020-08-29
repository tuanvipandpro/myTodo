package tuanlm.fpt.web.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tuanlm.fpt.web.todo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findById(int id);
}
