package com.MyPersonalTrainer.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcerciseMapperTestSuite {
	@Autowired
	ExcerciseMapper mapper;
	
	@Test
	public void shouldMapExcerciseToExcerciseDto() {
		//Given
		Excercise excercise = new Excercise(1, "name", 2, 3, 4.0);
		
		//When
		ExcerciseDto result = mapper.mapToExcerciseDto(excercise);
		
		//Then
		assertEquals(excercise.getName(), result.getName());
	}
	@Test
	public void shouldMapExcerciseDtoToExcercise() {
		//Given
		ExcerciseDto excerciseDto = new ExcerciseDto(1, "name", 2, 3, 4.0);
		
		//When
		Excercise result = mapper.mapToExcercise(excerciseDto);
	
		//Then
		assertEquals(excerciseDto.getName(), result.getName());
		
	}
	@Test
	public void shouldMapExcerciseListToExcerciseDtoList() {
		//Given
		List<Excercise> excerciseList = new ArrayList();
		Excercise excercise1 = new Excercise(1, "name", 21, 31, 14.0);
		Excercise excercise2 = new Excercise(12, "name", 232, 32, 24.0);
		Excercise excercise3 = new Excercise(123, "name", 245, 32, 4.3);
		Excercise excercise4 = new Excercise(11234, "name", 245, 43, 12.0);
		Excercise excercise5 = new Excercise(112345, "name", 22, 43, 4.3);
		Excercise excercise6 = new Excercise(1123456, "name", 223, 345, 4.44);
	
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
