package com.MyPersonalTrainer.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.Series;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcerciseDaoTestSuite {
	@Autowired
	private ExcerciseDao excerciseDao;
	
	@Test
	public void shouldShowAllExcercises() {
		//Given
		LocalDateTime date = LocalDateTime.now();
		Series s1 = new Series(1, 1,  5, 70);
		Series s2 = new Series(2, 1,  5, 80);
		Series s3 = new Series(3, 1,  5, 90);
		ArrayList<Series> seriesList = new ArrayList<>();
		seriesList.add(s1);
		seriesList.add(s2);
		seriesList.add(s3);
		Excercise excercise1 = new Excercise(date, "Over Head Press", 1, seriesList);
		excercise1.getSeries().add(s1);
		excercise1.getSeries().add(s2);
		excercise1.getSeries().add(s3);
		s1.setExcercise(excercise1);
		s2.setExcercise(excercise1);
		s3.setExcercise(excercise1);
		
		//When	
		excerciseDao.save(excercise1);
		int id = excercise1.getId();
		System.out.println(id);
		String name = excerciseDao.findById(id).getName();
		
		//Then
		assertEquals("Over Head Press", name);
		
		//CleanUp
		excerciseDao.deleteById(id);
	}
	
	@Test
	public void shoudUpdateSeries() {
		//Given
		LocalDate date = LocalDate.now();
		LocalDateTime date2 = LocalDateTime.now();
		Series s1 = new Series(1, 1,  5, 70);
		Series s2 = new Series(2, 1,  5, 80);
		Series s3 = new Series(3, 1,  5, 90);
		ArrayList<Series> seriesList = new ArrayList<>();
		seriesList.add(s1);
		seriesList.add(s2);
		seriesList.add(s3);
		Excercise excercise1 = new Excercise(date2, "Over Head Press", 1, seriesList);
		excercise1.getSeries().add(s1);
		excercise1.getSeries().add(s2);
		excercise1.getSeries().add(s3);
		s1.setExcercise(excercise1);
		s2.setExcercise(excercise1);
		s3.setExcercise(excercise1);
		excerciseDao.save(excercise1);
		
		//When
		s1.setDate(date);
		s1.setDoneReps(4);
		s1.setDoneWeight(65);
		excerciseDao.save(s1);
		int id = excercise1.getId();
		String resultDate = s1.getDate().toString();
		double resultReps = s1.getDoneReps();
		double resultWeight = s1.getDoneWeight();
		
		//Then
		assertEquals(date.toString(), resultDate);
		assertEquals(4, resultReps, 0);
		assertEquals(65, resultWeight, 0);
		
		//CleanUp
		excerciseDao.deleteById(id);
	}
}
