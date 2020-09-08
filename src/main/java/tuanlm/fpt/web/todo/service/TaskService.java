package tuanlm.fpt.web.todo.service;

import java.util.Date;
import java.util.List;

import tuanlm.fpt.web.todo.entity.Task;

/**
 * The Interface TaskService.
 */
public interface TaskService {
	
	/**
	 * Gets the task by username and date.
	 *
	 * @param username the username
	 * @param date the date
	 * @return the task by username and date
	 */
	List<Task> getTaskByUsernameAndDate(String username, Date date);
	
	/**
	 * Adds the task.
	 *
	 * @param username the username
	 * @param content the content
	 * @return the integer
	 */
	Integer addTask(String username, String content);
	
	/**
	 * Done task.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean doneTask(int id);
}
