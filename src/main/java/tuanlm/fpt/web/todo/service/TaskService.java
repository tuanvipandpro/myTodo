package tuanlm.fpt.web.todo.service;

import java.util.Date;
import java.util.List;

import tuanlm.fpt.web.todo.entity.Task;
import tuanlm.fpt.web.todo.request.TaskRequest;

// TODO: Auto-generated Javadoc
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
	 * @param task the task
	 * @return the task
	 */
	Task addTask(String username, TaskRequest task);
	
	/**
	 * Done task.
	 *
	 * @param id the id
	 * @param status the status
	 * @return true, if successful
	 */
	boolean updateTask(int id, int status);
}
