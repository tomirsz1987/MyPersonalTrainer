package com.MyPersonalTrainer.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExcerciseDto {
	private int id;
	private String name;
	private int series;
	private int reps;
	private double weight;
}
