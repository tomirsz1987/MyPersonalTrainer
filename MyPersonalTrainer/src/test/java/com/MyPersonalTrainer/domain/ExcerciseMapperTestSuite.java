package com.MyPersonalTrainer.domain;

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
import com.MyPersonalTrainer.domain.ExcerciseDto;
import com.MyPersonalTrainer.domain.ExcerciseMapper;
import com.MyPersonalTrainer.domain.Series;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcerciseMapperTestSuite {
	@Autowired
	ExcerciseMapper mapper;

	@Test
	public void shouldMapExcerciseToExcerciseDto() {
		//Given
		LocalDateTime date = LocalDateTime.now();
		List<Series> series = new ArrayList<>();
		List<Excercise> excerciseList = new ArrayList<>();
		User user = new User(12, "Tom12", "Password", excerciseList);
		Excercise excercise = new Excercise(date, "testName", 1, series, user);
		
		//When
		ExcerciseDto result = mapper.mapToExcerciseDto(excercise);
		
		//Then
		assertEquals(excercise.getName(), result.getName());
	}
	
	@Test
	public void shouldMapExcerciseDtoToExcercise() {
		//Given
		LocalDateTime date = LocalDateTime.now();		
		List<Series> series = new ArrayList<>();
		List<Excercise> excerciseList = new ArrayList<>();
		User user = new User(12, "Tom12", "Password", excerciseList);
		ExcerciseDto excerciseDto = new ExcerciseDto(1, date, "name", 1, series, user);
		
		//When
		Excercise result = mapper.mapToExcercise(excerciseDto);
	
		//Then
		assertEquals(excerciseDto.getName(), result.getName());
		
	}
	
	@Test
	public void shouldMapExcerciseListToExcerciseDtoList() {
		//Given
		LocalDateTime date1 = LocalDateTime.now();
		LocalDateTime date2 = LocalDateTime.now();
		LocalDateTime date3 = LocalDateTime.now();
		LocalDateTime date4 = LocalDateTime.now();
		LocalDateTime date5 = LocalDateTime.now();
		LocalDateTime date6 = LocalDateTime.now();
		
		List<Series> series = new ArrayList<>();
		List<Excercise> excerciseList = new ArrayList<>();
		User user = new User(12, "Tom12", "Password", excerciseList);
		Excercise excercise1 = new Excercise(date1, "name", 1, series, user);
		Excercise excercise2 = new Excercise(date2,  "name", 12,  series, user);
		Excercise excercise3 = new Excercise(date3, "name", 123,  series, user);
		Excercise excercise4 = new Excercise(date4, "name", 1234, series, user);
		Excercise excercise5 = new Excercise(date5, "name", 12345, series, user);
		Excercise excercise6 = new Excercise(date6, "name", 123456, series, user);
	
		//When
		excerciseList.add(excercise1);
		excerciseList.add(excercise2);
		excerciseList.add(excercise3);
		excerciseList.add(excercise4);
		excerciseList.add(excercise5);
		excerciseList.add(excercise6);
		int result = mapper.mapToExcerciseDtoList(excerciseList).size();
		
		//Then
		assertEquals(6, result);
	}
}
