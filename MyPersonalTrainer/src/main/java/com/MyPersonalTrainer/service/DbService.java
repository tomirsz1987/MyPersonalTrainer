package com.MyPersonalTrainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.ExcerciseDao;

@Service
public class DbService {
	@Autowired
	private ExcerciseDao excerciseDao;
	
	public Excercise addExcercise(Excercise excercise) {
		return excerciseDao.save(excercise);
	}
	
	public void deleteExcercise(String name) {
		excerciseDao.deleteByName(name);
		
	}
	
	public List<Excercise> showAllExcercises() {
		return (List<Excercise>) excerciseDao.findAll();
	}
}
