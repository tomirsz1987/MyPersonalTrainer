package com.MyPersonalTrainer.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.MyPersonalTrainer.domain.ExcerciseDto;
import com.MyPersonalTrainer.domain.Series;
import com.MyPersonalTrainer.domain.User;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(ExcerciseController.class)
public class ExcerciseControllerTestSuite {

	private final String URL = "v1/MyPersonalTrainer/";
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ExcerciseController excerciseController;
	
	@Test
	public void shouldCreateExcercise() throws Exception {
		//Given
//		LocalDateTime date = LocalDateTime.now();
//		List<Series> seriesList = new ArrayList<>();
//		User user = new User();
//		ExcerciseDto eDto = new ExcerciseDto(1, date, "Over Head Press", 1, seriesList, user);
//		when(excerciseController.createExcercise(ArgumentMatchers.any(ExcerciseDto.class))).thenReturn(eDto);
//		Gson gson = new Gson();
//		String jsonCnt = gson.toJson(eDto);
//		
//		//When & Then
//		mockMvc.perform(post("/v1/MyPersonalTrainer/createExcercise")
//				.contentType(MediaType.APPLICATION_JSON)
//				.characterEncoding("UTF-8")
//				.content(jsonCnt))
//				.andExpect(jsonPath("$.id", is(1)));
	}
	
	@Test
	public void shouldDeleteExcercise() {
		//Given
		
		//When & Then
	}
	@Test
	public void shouldGetExcercise() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldGetExcerciseListByName() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldGetChartData() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldAddSeries() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldUpdateSeries() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldGetExcercisesList() {
		//Given
		
		//When & Then
	}
	
	@Test
	public void shouldGetSeries() {
		//Given
		
		//When & Then
	}

}
