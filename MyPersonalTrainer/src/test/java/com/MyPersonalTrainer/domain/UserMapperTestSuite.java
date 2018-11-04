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
public class UserMapperTestSuite {
	
	@Autowired
	UserMapper mapper;

	@Test
	public void shouldMapUserToUserDto() {
		
		//Given
		List<Excercise> excerciseList = new ArrayList<>();
		User user = new User(12, "Tom12", "Password", excerciseList);
		
		//When
		UserDto result = mapper.mapToUserDto(user);
		
		//Then
		assertEquals(user.getUsername(), result.getUsername());
		
	}
	
	@Test
	public void shouldMapUserDtoToUser() {
		
		//Given
		List<Excercise> excerciseList = new ArrayList<>();
		UserDto userDto = new UserDto(12, "Tom12", "Password", excerciseList);
		
		//When
		User result = mapper.mapToUser(userDto);
	
		//Then
		assertEquals(userDto.getUsername(), result.getUsername());
		
	}
	
}
