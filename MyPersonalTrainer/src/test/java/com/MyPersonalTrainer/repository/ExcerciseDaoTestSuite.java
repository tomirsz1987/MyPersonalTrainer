package com.MyPersonalTrainer.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.Series;
import com.MyPersonalTrainer.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcerciseDaoTestSuite {
	@Autowired
	private ExcerciseDao excerciseDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	BCryptPasswordEncoder encoder;
	
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
		List<Excercise> excerciseList = new ArrayList<>();
		String password = encoder.encode("123456");
		User user = new User("Adahn", password, excerciseList);
		userDao.save(user);
		Excercise excercise1 = new Excercise(date, "Over Head Press", 1, seriesList, user);
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
		userDao.delete(user);
	}
}
