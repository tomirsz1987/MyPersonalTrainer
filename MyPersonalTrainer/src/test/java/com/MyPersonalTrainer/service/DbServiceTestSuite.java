package com.MyPersonalTrainer.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.ExcerciseDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {

	@Autowired
	ExcerciseDao excerciseDao;
	
	@Autowired
	DbService dbService;
	
	@Test
	public void shouldAddExcercise() {
		//Given
		Excercise excercise1 = new Excercise("OHP", 5, 5, 60.0);
		Excercise excercise2 = new Excercise("Dead Lift", 5, 8, 180.0);
		Excercise excercise3 = new Excercise("Bench Press", 5, 5, 120.0);
		
		//When
		dbService.addExcercise(excercise1);
		dbService.addExcercise(excercise2);
		dbService.addExcercise(excercise3);
		int id1 = excercise1.getId();
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		long result = excerciseDao.count();
		
		//Then
		assertEquals(3, result);
		
		//CleanUp
		excerciseDao.deleteById(id1);
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}

	@Test
	public void shouldDeleteExcercise() {
		//Given
		Excercise excercise1 = new Excercise("OHP", 5, 5, 60.0);
		Excercise excercise2 = new Excercise("Dead Lift", 5, 8, 180.0);
		Excercise excercise3 = new Excercise("Bench Press", 5, 5, 120.0);
		
		//When
		excerciseDao.save(excercise1);
		excerciseDao.save(excercise2);
		excerciseDao.save(excercise3);
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		long result = excerciseDao.count();
		
		//Then
		assertEquals(3, result);
		dbService.deleteExcercise("OHP");
		assertEquals(2, result - 1);
		
		//CleanUp
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}
	
	@Test
	public void shouldShowAllExcercise() {
		//Given
		Excercise excercise1 = new Excercise("OHP", 5, 5, 60.0);
		Excercise excercise2 = new Excercise("Dead Lift", 5, 8, 180.0);
		Excercise excercise3 = new Excercise("Bench Press", 5, 5, 120.0);
		
		//When
		excerciseDao.save(excercise1);
		excerciseDao.save(excercise2);
		excerciseDao.save(excercise3);
		int id1 = excercise1.getId();
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		int result = dbService.showAllExcercises().size();
		
		//Then
		assertEquals(3, result);
		
		//CleanUp
		excerciseDao.deleteById(id1);
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}
}
