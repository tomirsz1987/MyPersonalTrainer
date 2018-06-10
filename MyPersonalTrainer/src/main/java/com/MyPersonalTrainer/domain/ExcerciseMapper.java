package com.MyPersonalTrainer.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ExcerciseMapper {

	public ExcerciseDto mapToExcerciseDto(Excercise excercise) {
		return new ExcerciseDto(
				excercise.getId(),
				excercise.getName(),
				excercise.getSeries(),
				excercise.getReps(),
				excercise.getWeight());
	}
	
	public Excercise mapToExcercise(ExcerciseDto excerciseDto) {
		return new Excercise(
				excerciseDto.getId(),
				excerciseDto.getName(),
				excerciseDto.getSeries(),
				excerciseDto.getReps(),
				excerciseDto.getWeight());
	}
	
	public List<ExcerciseDto> mapToExcerciseDtoList(List<Excercise> excerciseList) {
		return excerciseList.stream()
				.map(e -> new ExcerciseDto(e.getId(), e.getName(), e.getSeries(), e.getReps(), e.getWeight()))
				.collect(Collectors.toList());
	}
}
