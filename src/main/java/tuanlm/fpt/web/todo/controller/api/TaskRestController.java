package tuanlm.fpt.web.todo.controller.api;


import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tuanlm.fpt.web.todo.entity.Task;
import tuanlm.fpt.web.todo.service.TaskService;
import tuanlm.fpt.web.todo.utils.AppConstants;
import tuanlm.fpt.web.todo.utils.DateUtils;

/**
 * The Class TaskRestController.
 */
@RestController
@RequestMapping(value = "/task-service")
public class TaskRestController {
	
	/** The task service. */
	private TaskService taskService;

	/**
	 * Instantiates a new task rest controller.
	 *
	 * @param taskService the task service
	 */
	public TaskRestController(TaskService taskService) {
		this.taskService = taskService;
	}
	
//	@GetMapping(value = "get-list-task-by-day", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Task>> getTaskListByDate(@RequestParam String date, Principal principal) {
//		if (principal == null) {
//			return new ResponseEntity<List<Task>>(HttpStatus.FORBIDDEN);
//		}	
//		
//		return new ResponseEntity<List<Task>>(taskService.getTaskByUsernameAndDate(principal.getName(), date), HttpStatus.OK);
//	}
	
	/**
	 * Creates the task.
	 *
	 * @param task the task
	 * @param principal the principal
	 * @return the response entity
	 */
	@PostMapping(value = "/create-new-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createTask (@RequestBody @Valid Task task, Principal principal) {
		if (principal == null) {
			return new ResponseEntity<Integer>(HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<Integer>(taskService.addTask(principal.getName(), task.getContent()) , HttpStatus.OK);
	}
	
	/**
	 * Done task.
	 *
	 * @param id the id
	 * @param principal the principal
	 * @return the response entity
	 */
	@GetMapping(value = "done-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> doneTask (@RequestParam int id, Principal principal) {
		if (principal == null) {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}		
		return taskService.updateTask(id, AppConstants.DONE_STATUS) ? 
				new ResponseEntity<Void> (HttpStatus.OK) : 
				new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Open task.
	 *
	 * @param id the id
	 * @param principal the principal
	 * @return the response entity
	 */
	@GetMapping(value = "open-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> openTask (@RequestParam int id, Principal principal) {
		if (principal == null) {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}		
		return taskService.updateTask(id, AppConstants.OPEN_STATUS) ? 
				new ResponseEntity<Void> (HttpStatus.OK) : 
				new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
