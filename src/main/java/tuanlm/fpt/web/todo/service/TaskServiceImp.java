package tuanlm.fpt.web.todo.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tuanlm.fpt.web.todo.entity.Task;
import tuanlm.fpt.web.todo.repository.TaskRepository;
import tuanlm.fpt.web.todo.request.TaskRequest;
import tuanlm.fpt.web.todo.utils.AppConstants;
import tuanlm.fpt.web.todo.utils.DateUtils;

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
	 * @param task the task
	 * @return the task
	 */
	public Task addTask(String username, TaskRequest taskRequest) {
		Task task = new Task();
		task.setUsername(username);
		task.setContent(taskRequest.getContent());
		task.setStatusId(AppConstants.OPEN_STATUS);
		
		try {
			task.setDate(DateUtils.DateConvert(taskRequest.getDate(), "yyyy-MM-dd"));
		}
		catch(ParseException e) {
			task.setDate(new Date());
		}

		return taskRepository.save(task);
	}
	
	/**
	 * Update task.
	 *
	 * @param id the id
	 * @param status the status
	 * @return true, if successful
	 */
	public boolean updateTask(int id, int status) {
		Task task = taskRepository.findById(id);
		task.setStatusId(status);
		return (taskRepository.save(task) != null);
	}
}
