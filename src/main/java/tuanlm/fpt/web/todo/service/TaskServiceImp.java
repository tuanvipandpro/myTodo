package tuanlm.fpt.web.todo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Task;
import tuanlm.fpt.web.todo.repository.TaskRepository;
import tuanlm.fpt.web.todo.utils.AppConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskServiceImp.
 */
@Service
public class TaskServiceImp implements TaskService {
	
	/** The task repository. */
	private TaskRepository taskRepository;
	
	/**
	 * Instantiates a new task service imp.
	 *
	 * @param taskRepository the task repository
	 */
	public TaskServiceImp(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	/**
	 * Gets the task by username and date.
	 *
	 * @param username the username
	 * @param date the date
	 * @return the task by username and date
	 */
	public List<Task> getTaskByUsernameAndDate(String username, Date date) {
		return taskRepository.findByUsernameAndDate(username, date);
	}
	
	/**
	 * Adds the task.
	 *
	 * @param username the username
	 * @param content the content
	 * @return the integer
	 */
	public Integer addTask(String username, String content) {
		return taskRepository.save(new Task(username, content, new Date(), AppConstants.OPEN_STATUS)).getId();
	}
	
	/**
	 * Update task.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean updateTask(int id, int status) {
		Task task = taskRepository.findById(id);
		task.setStatusId(status);
		return (taskRepository.save(task) != null);
	}
}
