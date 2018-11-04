package com.MyPersonalTrainer.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.Series;
import com.MyPersonalTrainer.domain.SeriesDto;
import com.MyPersonalTrainer.domain.SeriesMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SeriesMapperTestSuite {
	
	@Autowired
	SeriesMapper seriesMapper;
	
	@Test
	public void shouldMapSeriesToSeriesDto() {
		//Given
		LocalDate date = LocalDate.now();
		Series s1 = new Series.SeriesBuilder()
				.setWeight(50)
				.setReps(10)
				.setNumber(1)
				.setMicrocycleNo(1)
				.build();
				
		s1.buildDoneSeries(s1, 45, 9, date);
		
		//When
		SeriesDto resultDto = seriesMapper.mapToSeriesDto(s1);
		double resultWeight = resultDto.getWeight();
		int resultReps = resultDto.getReps();
		int resultNumber = resultDto.getNumber();
		int resultMicrocycleNo = resultDto.getMicrocycleNo();
		double resultDoneWeight = resultDto.getDoneWeight();
		int resultDoneReps = resultDto.getDoneReps();
		LocalDate resultDate = resultDto.getDate();
		
		//Then
		assertEquals(50, resultWeight, 0);
		assertEquals(10, resultReps);
		assertEquals(1, resultNumber);
		assertEquals(1, resultMicrocycleNo);
		assertEquals(45, resultDoneWeight, 0);
		assertEquals(9, resultDoneReps);
		assertEquals(date, resultDate);
	}
	
	@Test
	public void shouldMapSeriesDtoToSeries() {
		
		//Given
		List<Series> seriesList = new ArrayList<>();
		LocalDate date = LocalDate.now();
		Excercise e1 = new Excercise.ExcerciseBuilder()
				.setMicrocycleNo(1)
				.setName("OHP")
				.setSeriesList(seriesList)
				.built();
		SeriesDto s1Dto = new SeriesDto(12, 1, 1, 10, 100, e1, 100, 10, date);
		
		//When
		Series result = seriesMapper.mapToSeries(s1Dto);
		double resultWeight = result.getWeight();
		int resultReps = result.getReps();
		int resultNumber = result.getNumber();
		int resultMicrocycleNo = result.getMicrocycleNo();
		double resultDoneWeight = result.getDoneWeight();
		int resultDoneReps = result.getDoneReps();
		LocalDate resultDate = result.getDate();
		
		//Then
		assertEquals(100, resultWeight, 0);
		assertEquals(10, resultReps);
		assertEquals(1, resultNumber);
		assertEquals(1, resultMicrocycleNo);
		assertEquals(100, resultDoneWeight, 0);
		assertEquals(10, resultDoneReps);
		assertEquals(date, resultDate);
	}
	
	@Test
	public void shouldMapSeriesListToSeriesDtoList() {
		
		//Given
		LocalDate date = LocalDate.now();
		
		List<Series> seriesList = new ArrayList<>();
		
		Series s1 = new Series.SeriesBuilder()
				.setWeight(50)
				.setReps(10)
				.setNumber(1)
				.setMicrocycleNo(1)
				.build();
				
		s1.buildDoneSeries(s1, 50, 10, date);
		
		Series s2 = new Series.SeriesBuilder()
				.setWeight(60)
				.setReps(10)
				.setNumber(2)
				.setMicrocycleNo(1)
				.build();
				
		s2.buildDoneSeries(s2, 60, 10, date);
		
		Series s3 = new Series.SeriesBuilder()
				.setWeight(70)
				.setReps(10)
				.setNumber(3)
				.setMicrocycleNo(1)
				.build();
				
		s3.buildDoneSeries(s3, 70, 8, date);
		
		//When
		seriesList.add(s1);
		seriesList.add(s2);
		seriesList.add(s3);
		
		int result = seriesMapper.mapToSeriesDto(seriesList).size();
		
		//Then
		assertEquals(3, result);
	
	}
}
