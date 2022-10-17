package com.tugas.minpro.Repository;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.QueryHint;
import org.hibernate.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.hibernate.jpa.QueryHints;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.tugas.minpro.TaskEntity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

	
//	@org.springframework.data.jpa.repository.QueryHints(value = {
//			@QueryHint(name = QueryHints.HINT_FETCH_SIZE, value = "5"),
//			@QueryHint(name = QueryHints.HINT_CACHEABLE, value = "false")
//	})
//	Stream<TaskEntity>findByName(String name);
	
//	@org.springframework.data.jpa.repository.QueryHints(value = {
//			@QueryHint(name = QueryHints.HINT_FETCH_SIZE, value = "5"),
//			@QueryHint(name = QueryHints.HINT_CACHEABLE, value = "false")
//	})
//	Stream<TaskEntity>findByIdName(Integer id);
	
	@org.springframework.data.jpa.repository.QueryHints(value = {
			@QueryHint(name = QueryHints.HINT_FETCH_SIZE, value = "100"),
			@QueryHint(name = QueryHints.HINT_CACHEABLE, value = "false")
	})
	@Query(value = "SELECT gl from TaskEntity gl")
	Stream<TaskEntity> getFindAll();

}
