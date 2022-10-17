package com.tugas.minpro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.config.Task;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tugas.minpro.Repository.TaskRepository;
import com.tugas.minpro.Service.TaskService;
import com.tugas.minpro.TaskEntity.TaskEntity;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MinproApplicationTests {
	
	@Autowired
	private TaskService taskService;
	
	@MockBean
	private TaskRepository taskRepo;
	
	@org.junit.Test
	public void newTask(){
		TaskEntity task = new TaskEntity(99, "haha", "uhuy", false);
		when(taskRepo.save(task)).thenReturn(task);
		assertEquals(task, taskService.newTask(task));
		System.out.println("Test newTask");
	}
	
	@org.junit.Test
	public void getTaskId() throws Exception{
		TaskEntity task = new TaskEntity(99, "findbyId", "findbyId desc", true);
		when(taskRepo.findById(99)).thenReturn(Optional.of(task));
		System.out.println("Test getTaskById");
	}
	
	@org.junit.Test
	public void deleteTaskById(){
		TaskEntity task = new TaskEntity(77, "test delete", "test delete desc", false);
		taskService.deleteTaskById(task.getId());
		verify(taskRepo, times(1)).deleteById(task.getId());
		System.out.println("Test deleteById");
	}
	
	@org.junit.Test
	public void updateTaskId(){
		TaskEntity task = new TaskEntity(77, "test update", "test update desc", false);
		when(taskRepo.findById(task.getId())).thenReturn(Optional.of(task));
		taskRepo.save(task);
		System.out.println("Test UpdateById");
	}


}
