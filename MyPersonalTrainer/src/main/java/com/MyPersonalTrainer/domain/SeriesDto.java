package com.MyPersonalTrainer.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDto {
	private int id;
	private int microcycleNo;
	private int number;
	private int reps;
	private double weight;
	private Excercise excercise;
	private double doneWeight;
	private int doneReps;
	private LocalDate date;
}
