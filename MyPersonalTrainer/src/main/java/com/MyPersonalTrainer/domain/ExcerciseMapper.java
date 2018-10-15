package com.MyPersonalTrainer.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ExcerciseMapper {
	
	public ExcerciseDto mapToExcerciseDto(Excercise excercise) {
		return new ExcerciseDto(
				excercise.getId(),
				excercise.getAddingTime(),
				excercise.getName(),
				excercise.getMicrocycleNo(),
				excercise.getSeries());
		
	}
	
	public Excercise mapToExcercise(ExcerciseDto excerciseDto) {
		return new Excercise(
				excerciseDto.getId(),
				excerciseDto.getAddingTime(),
				excerciseDto.getName(),
				excerciseDto.getMicrocycleNo(),
				excerciseDto.getSeries());
	}
	
	public List<ExcerciseDto> mapToExcerciseDtoList(List<Excercise> excerciseList) {
		return excerciseList.stream()
				.map(e -> new ExcerciseDto(e.getId(), e.getAddingTime(), e.getName(),e.getMicrocycleNo(), e.getSeries()))
				.collect(Collectors.toList());
	}
}
