package com.MyPersonalTrainer.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.Series;

@Transactional
@Repository
public interface ExcerciseDao extends CrudRepository<Excercise, Integer> {
	void deleteByName(String name);
	
	Excercise findById(int id);
		
	List<Excercise> findAllByName(String name);
	
	Series save(Series series);
		
	@Query
	List<Excercise> getExcerciseList(@Param("VALUE") int value);
	
}
