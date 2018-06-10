package com.MyPersonalTrainer.domain;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ExcerciseDao extends CrudRepository<Excercise, Integer> {	
	void deleteByName(String name);
}
