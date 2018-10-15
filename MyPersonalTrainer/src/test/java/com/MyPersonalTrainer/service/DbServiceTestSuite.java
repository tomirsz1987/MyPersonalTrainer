package com.MyPersonalTrainer.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.repository.ExcerciseDao;
import com.MyPersonalTrainer.domain.Series;

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
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = LocalDateTime.now();
		LocalDateTime date3 = LocalDateTime.now();
		List<Series> series = new ArrayList<>();
		Excercise excercise1 = new Excercise(date1, "OHP", 1, series);
		Excercise excercise2 = new Excercise(date2, "Dead Lift", 1, series);
		Excercise excercise3 = new Excercise(date3, "Bench Press", 1, series);
		
		//When
		dbService.addExcercise(excercise1);
		dbService.addExcercise(excercise2);
		dbService.addExcercise(excercise3);
		int id1 = excercise1.getId();
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		long result = excerciseDao.count();
		
		//Then
		assertEquals(3 + result, result);
		
		//CleanUp
		excerciseDao.deleteById(id1);
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}

	@Test
	public void shouldFindExcercise() {
		//Given
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = LocalDateTime.now();
		List<Series> series = new ArrayList<>();
		Excercise excercise1 = new Excercise(date1, "OHP", 1, series);
		Excercise excercise2 = new Excercise(date2, "Dead Lift", 1, series);
		
		//When
		dbService.addExcercise(excercise1);
		dbService.addExcercise(excercise2);
		int id1 = excercise1.getId();
		int id2 = excercise2.getId();
		Excercise resultExcercise = dbService.getExcercise(id1);
	
		//Then
		assertEquals("OHP", resultExcercise.getName());
		
		//CleanUp
		excerciseDao.deleteById(id1);
		excerciseDao.deleteById(id2);
	}
	
	@Test
	public void shouldDeleteExcercise() {
		//Given
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = LocalDateTime.now();
		LocalDateTime date3 = LocalDateTime.now();
		List<Series> series = new ArrayList<>();
		Excercise excercise1 = new Excercise(date1, "OHP", 1, series);
		Excercise excercise2 = new Excercise(date2, "Dead Lift", 1, series);
		Excercise excercise3 = new Excercise(date3, "Bench Press", 1, series);
		
		//When
		excerciseDao.save(excercise1);
		excerciseDao.save(excercise2);
		excerciseDao.save(excercise3);
		String name = excercise1.getName();
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		long result = excerciseDao.count();
		
		//Then
		assertEquals(3 + result, result);
		dbService.deleteExcercise(name);
		assertEquals(2 + result, result - 1);
		
		//CleanUp
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}
	
	@Test
	public void shouldShowAllExcercises() {
		//Given
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = LocalDateTime.now();
		LocalDateTime date3 = LocalDateTime.now();
		
		List<Series> series = new ArrayList<>();
		Excercise excercise1 = new Excercise(date1, "OHP", 1, series);
		Excercise excercise2 = new Excercise(date2, "Dead Lift", 1, series);
		Excercise excercise3 = new Excercise(date3, "Bench Press", 1, series);
	 
		//When
		excerciseDao.save(excercise1);
		excerciseDao.save(excercise2);
		excerciseDao.save(excercise3);
		int id1 = excercise1.getId();
		int id2 = excercise2.getId();
		int id3 = excercise3.getId();
		int result = dbService.showAllExcercises().size();
		
		//Then
		assertEquals(3 + result, result);
		
		//CleanUp
		excerciseDao.deleteById(id1);
		excerciseDao.deleteById(id2);
		excerciseDao.deleteById(id3);
	}
	
	@Test
	public void shouldShowAllSeries() {
		//Given
		List<Series> series = new ArrayList<>();
		Series s1 = new Series(1, 1, 10, 100);
		Series s2 = new Series(2, 1, 8, 120);
		Series s3 = new Series(3, 1, 6, 145);
		series.add(s1);
		series.add(s2);
		series.add(s3);
		LocalDateTime date = LocalDateTime.now();
		Excercise e1 = new Excercise(date, "Dead Lift", 1, series);
		s1.setExcercise(e1);
		s2.setExcercise(e1);
		s3.setExcercise(e1);
		e1.setSeries(series);
	
		//When
		excerciseDao.save(e1);	
		int id1 = e1.getId();
		List<Series> resultList = dbService.showAllSeries(id1);

		int result = resultList.size();
		//Then
		assertEquals(3, result);
		
		//CleanUp
		excerciseDao.deleteById(id1);

	}
	
	@Test
	public void shouldAddSeries() {
		//Given
		LocalDateTime date = LocalDateTime.now();
		List<Series> series = new ArrayList<>();
		Excercise e1 = new Excercise(date, "Dead Lift", 1, series);
		Series s1 = new Series(1, 1, 12, 80);
		
		//When
		excerciseDao.save(e1);	
		int id1 = e1.getId();
		Excercise newExcercise = dbService.addSeries(id1, s1);
		
		//Then
		assertEquals(1, newExcercise.getSeries().size());
				
		//CleanUp
		excerciseDao.deleteById(newExcercise.getId());
	}		
	
	@Test
	public void shouldUpdateSeries() {
		
	}
}
