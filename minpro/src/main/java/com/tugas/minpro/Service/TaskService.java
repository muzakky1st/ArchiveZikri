package com.tugas.minpro.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas.minpro.Repository.TaskRepository;
import com.tugas.minpro.Repository.TaskStreamService;
import com.tugas.minpro.TaskEntity.TaskEntity;

@Service
public class TaskService {
	@Autowired
	private TaskStreamService streamService;
	
	@Autowired
	private TaskRepository taskRepo;
	
	public TaskEntity newTask(TaskEntity task){
		return taskRepo.save(task);
	}
	
	public List<TaskEntity> getTaskList(){
		return taskRepo.findAll();
	}
	
//	public List<TaskEntity> getTaskByName (String name) throws Exception{
//		return streamService.streamByName(name);
//	}
	
	public Optional<TaskEntity> getTaskById (Integer id) throws Exception{
		return taskRepo.findById(id);
	}
	
	public List<TaskEntity> getFindAll () throws Exception{
		return streamService.streamFindAll();
	}
	
	public TaskEntity updateTaskById(Integer id, TaskEntity dto){
		Optional<TaskEntity> upt = taskRepo.findById(id);
		
		TaskEntity task = upt.get();
		task.setName(dto.getName());
		task.setDescription(dto.getDescription());
		task.setStatus(dto.isStatus());
		
		return taskRepo.save(task);
	}
	
	public void deleteTaskById(Integer id){
		taskRepo.deleteById(id);
	}

}
