package com.MyPersonalTrainer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "EXCERCISE")
public class Excercise {
	@Column(name = "ID", unique = true)
	@Id
	@GeneratedValue
	@NotNull
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SERIES")
	private int series;
	@Column(name = "REPS")
	private int reps;
	@Column(name = "WEIGHT")
	private double weight;
	
	public Excercise(String name, int series, int reps, double weight) {
		this.name = name;
		this.series = series;
		this.reps = reps;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getSeries() {
		return series;
	}

	private void setSeries(int series) {
		this.series = series;
	}

	public int getReps() {
		return reps;
	}

	private void setReps(int reps) {
		this.reps = reps;
	}

	public double getWeight() {
		return weight;
	}

	private void setWeight(double weight) {
		this.weight = weight;
	}
}
