package tuanlm.fpt.web.todo.controller.api;


import java.security.Principal;
import java.text.ParseException;
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
import tuanlm.fpt.web.todo.request.TaskRequest;
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
	
	@GetMapping(value = "/get-list-task-by-day", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> getTaskListByDate(@RequestParam String date, Principal principal) {
		try {
			Date dateConverted = DateUtils.DateConvert(date, "yyyy-MM-dd");
			if (dateConverted != null) {
				return new ResponseEntity<List<Task>>(taskService.getTaskByUsernameAndDate(principal.getName(), dateConverted), HttpStatus.OK);
			} 
			else {
				return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 
		catch (ParseException e) {
			return new ResponseEntity<List<Task>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Creates the task.
	 *
	 * @param task the task
	 * @param principal the principal
	 * @return the response entity
	 */
	@PostMapping(value = "/create-new-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> createTask (@RequestBody @Valid TaskRequest task, Principal principal) {
		return new ResponseEntity<Task>(taskService.addTask(principal.getName(), task) , HttpStatus.OK);
	}
	
	/**
	 * Done task.
	 *
	 * @param id the id
	 * @param principal the principal
	 * @return the response entity
	 */
	@GetMapping(value = "/done-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> doneTask (@RequestParam int id, Principal principal) {	
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
	@GetMapping(value = "/open-task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> openTask (@RequestParam int id, Principal principal) {	
		return taskService.updateTask(id, AppConstants.OPEN_STATUS) ? 
				new ResponseEntity<Void> (HttpStatus.OK) : 
				new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
