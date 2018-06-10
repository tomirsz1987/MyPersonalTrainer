package com.MyPersonalTrainer.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcerciseDaoTestSuite {
	@Autowired
	private ExcerciseDao excerciseDao;
	@Test
	public void shouldShowAllExcercises() {
		//Given
		Excercise excercise1 = new Excercise("Over Head Press", 5, 5, 50.0);
		
		//When
		excerciseDao.save(excercise1);
		int id = excercise1.getId();
		String name = excerciseDao.findById(id).get().getName();
		
		//Then
		assertEquals("Over Head Press", name);
		
		//CleanUp
		excerciseDao.deleteById(id);
	}
}
