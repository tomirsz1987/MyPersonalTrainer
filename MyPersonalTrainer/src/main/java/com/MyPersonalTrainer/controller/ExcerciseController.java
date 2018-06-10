package com.MyPersonalTrainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyPersonalTrainer.domain.Excercise;
import com.MyPersonalTrainer.domain.ExcerciseDto;
import com.MyPersonalTrainer.domain.ExcerciseMapper;
import com.MyPersonalTrainer.service.DbService;

@RestController
@RequestMapping("v1/MyPersonalTrainer/")
public class ExcerciseController {
	@Autowired
	DbService dbService;
	
	@Autowired
	ExcerciseMapper excerciseMapper;
	
	@RequestMapping(method=RequestMethod.POST, value = "createExcercise")
	public Excercise createExcercise(@RequestBody ExcerciseDto excerciseDto) {
		return dbService.addExcercise(excerciseMapper.mapToExcercise(excerciseDto));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "deleteExcercise")
	public void deleteExcercise(@RequestParam String name) {
		dbService.deleteExcercise(name);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "getTraining")
	public List<Excercise> excercisesList() {
		return dbService.showAllExcercises();
	}
}
