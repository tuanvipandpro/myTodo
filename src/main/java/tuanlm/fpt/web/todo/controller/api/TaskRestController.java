package tuanlm.fpt.web.todo.controller.api;

import tuanlm.fpt.web.todo.service.TaskService;

public class TaskRestController {
	private TaskService taskService;

	public TaskRestController(TaskService taskService) {
		this.taskService = taskService;
	}

}
