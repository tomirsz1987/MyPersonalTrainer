package com.MyPersonalTrainer.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChartData {
	private LocalDate date;
	private double doneWeight;
}
