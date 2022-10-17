package com.tugas.minpro.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas.minpro.Repository.TaskRepository;
import com.tugas.minpro.Repository.TaskStreamService;
import com.tugas.minpro.TaskEntity.TaskEntity;

@Service
@Transactional()
public class StreamServiceImpl implements TaskStreamService {
	private static final Object TaskEntity = null;
@Autowired
	TaskRepository taskrepository;

//	@Override
//	public List<TaskEntity> streamByName(String name) throws Exception {
//
//		List<TaskEntity> streamEntity = new ArrayList<>();
//		try (Stream<TaskEntity> streamTaskEntity = taskrepository.findByName(name)) {
//			streamTaskEntity.forEach(eachStreamEntity -> {
//				streamEntity.add(eachStreamEntity);
//			});
//		} 
//		return streamEntity;
//	}
	
//	@Override
//	public List<TaskEntity> streamById(Integer id) throws Exception {
//
//		List<TaskEntity> streamEntity = new ArrayList<>();
//		try (Stream<TaskEntity> streamTaskEntity = taskrepository.findByIdName(id)) {
//			streamTaskEntity.forEach(eachStreamEntity -> {
//				streamEntity.add(eachStreamEntity);
//			});
//		} 
//		return streamEntity;
//	}
	
	@Override
	public List<TaskEntity> streamFindAll() throws Exception {

		List<TaskEntity> streamEntity = new ArrayList<>();
		try (Stream<TaskEntity> streamTaskEntity = taskrepository.getFindAll()) {
			streamTaskEntity.forEach(eachStreamEntity -> {
				streamEntity.add(eachStreamEntity);
			});
		} 
		return streamEntity;
	}
	

}
