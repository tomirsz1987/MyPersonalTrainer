package com.MyPersonalTrainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyPersonalTrainer.domain.DoneSeries;
import com.MyPersonalTrainer.domain.ExcerciseDto;
import com.MyPersonalTrainer.domain.ExcerciseMapper;
import com.MyPersonalTrainer.domain.Series;
import com.MyPersonalTrainer.domain.SeriesMapper;
import com.MyPersonalTrainer.service.DbService;

@RestController
@RequestMapping("v1/MyPersonalTrainer/")
@CrossOrigin(origins = "*")
public class ExcerciseController {
	@Autowired
	DbService dbService;
	
	@Autowired
	ExcerciseMapper excerciseMapper;
	
	@Autowired
	SeriesMapper seriesMapper;

	@RequestMapping(method=RequestMethod.POST, value = "createExcercise", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ExcerciseDto createExcercise(@RequestBody ExcerciseDto excerciseDto) {
		return excerciseMapper.mapToExcerciseDto(dbService.addExcercise(excerciseMapper.mapToExcercise(excerciseDto)));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "deleteExcercise")
	public void deleteExcercise(@RequestParam String name) {
		dbService.deleteExcercise(name);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getExcercise")
	public ExcerciseDto getExcercise(@RequestParam int id) {
		return excerciseMapper.mapToExcerciseDto(dbService.getExcercise(id));
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getExcerciseListByName")
	public List<ExcerciseDto> getExcerciseListByName(@RequestParam String name) {
		return excerciseMapper.mapToExcerciseDtoList(dbService.getExcerciseListByName(name));
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getChartData")
	public List<Series> getChartData(@RequestParam String name) {
		return dbService.getChartData(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "addSeries", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ExcerciseDto addSeries(@RequestParam int id, @RequestBody Series series) throws Exception {
		return excerciseMapper.mapToExcerciseDto(dbService.addSeries(id, series));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "updateSeries", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateSeries(@RequestBody DoneSeries doneSeries) {
		System.out.println("Contorller ok");
		dbService.updateSeries(doneSeries);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getTraining")
	public List<ExcerciseDto> excercisesList() {
		return excerciseMapper.mapToExcerciseDtoList(dbService.showAllExcercises());
	}

	@RequestMapping(method=RequestMethod.GET, value = "getExcercisesList")
	public List<ExcerciseDto> excercisesListWithParam(@RequestParam int value) {
		return excerciseMapper.mapToExcerciseDtoList(dbService.getExcercisesListWithParam(value));
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getSeries")
	public List<Series> seriesList(@RequestParam int id) throws Exception {
		return dbService.showAllSeries(id);
	}
}
