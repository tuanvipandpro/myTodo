package tuanlm.fpt.web.todo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tuanlm.fpt.web.todo.entity.Task;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskRepository.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	/**
	 * Find by username and date.
	 *
	 * @param username the username
	 * @param date the date
	 * @return the list
	 */
	List<Task> findByUsernameAndDate(String username, Date date);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the task
	 */
	Task findById(int id);
}
