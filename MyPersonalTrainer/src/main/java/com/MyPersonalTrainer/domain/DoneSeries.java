package com.MyPersonalTrainer.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DoneSeries {
	private int microcycleNo;
	private int seriesNumber;
	private int excerciseId;
	private double doneWeight;
	private int doneReps;
	private LocalDate date;

}
