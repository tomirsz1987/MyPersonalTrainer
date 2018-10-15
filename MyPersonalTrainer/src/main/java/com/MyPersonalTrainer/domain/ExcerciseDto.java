package com.MyPersonalTrainer.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExcerciseDto {
	private int id;
	private LocalDateTime addingTime;
	private String name;
	private int microcycleNo;
	private List<Series> series = new ArrayList<>();
}
