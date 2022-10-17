package com.tugas.minpro.Repository;

import java.util.List;

import com.tugas.minpro.TaskEntity.TaskEntity;

public interface TaskStreamService {
	//public List<TaskEntity> streamByName (String name) throws Exception;
	//public List<TaskEntity> streamById (Integer id) throws Exception;
	public List<TaskEntity> streamFindAll() throws Exception;


}
