package com.tugas.minpro.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugas.minpro.Service.StreamServiceImpl;
import com.tugas.minpro.Service.TaskService;
import com.tugas.minpro.TaskEntity.TaskEntity;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private StreamServiceImpl taskStream;
	
	@PostMapping("/newTask")
	public TaskEntity newTask(@RequestBody TaskEntity taskEntity){
		return taskService.newTask(taskEntity);
	}
	
//	@GetMapping("/GetTaskList")
//	public List<TaskEntity> getTaskList(){
//		return taskService.getTaskList();
//	}
	
//	@GetMapping("/GetTask/{name}")//Stream
//	public List<TaskEntity> getTaskByName(@PathVariable("name") String name) throws Exception{
//		return taskService.getTaskByName(name);
//	}
	
	@GetMapping("/GetTask/{id}")
	public Optional<TaskEntity> getTaskByid(@PathVariable("id") Integer id) throws Exception{
		return taskService.getTaskById(id);
	}
	
	@GetMapping("/GetTaskList")//Stream
	public List<TaskEntity> getTaskAll() throws Exception{
		return taskStream.streamFindAll();
	}
	
	@PutMapping("updateTask/{id}")
	public TaskEntity updateTaskById(@RequestBody TaskEntity entity  ,@PathVariable("id") Integer id){
		return taskService.updateTaskById(id, entity);
	}
	
	@DeleteMapping("deleteTask/{id}")
	public String deleteTaskById(@PathVariable("id") Integer id){
		taskService.deleteTaskById(id);
		return "Sukses";
	}

}
