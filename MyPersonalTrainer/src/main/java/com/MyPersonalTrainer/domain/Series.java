package com.MyPersonalTrainer.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NamedNativeQuery(
		name = "Series.getChartData",
		query = "SELECT date, max(weight)\n" + 
				"	FROM training.excercise, training.series\n" + 
				"    WHERE training.series.id in (SELECT training.excercise.id FROM training.excercise where training.excercise.name = :NAME) and date IS NOT NULL\n" + 
				"    GROUP BY date"
		)

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SERIES")
public class Series {
	private int id;
	private int microcycleNo;
	private int number;
	private int reps;
	private double weight;
	private Excercise excercise;
	private double doneWeight;
	private int doneReps;
	private LocalDate date;
	
	public Series(int microcycleNo, int number, int reps, double weight) {
		this.microcycleNo = microcycleNo;
		this.number = number;
		this.reps = reps;
		this.weight = weight;
	}
	
	public Series(int microcycleNo, int number, int reps, double weight, Excercise excercise) {
		this.microcycleNo = microcycleNo;
		this.number = number;
		this.reps = reps;
		this.weight = weight;
		this.excercise = excercise;
	}
	
	public Series(double doneWeight, int doneReps, LocalDate date) {
		this.doneWeight = doneWeight;
		this.doneReps = doneReps;
		this.date = date;
	}
	
	@Column(name = "SERIES_ID", unique = true)
	@GeneratedValue
	@NotNull
	@Id
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	@Column(name = "MICROCYCLE_NO")
	public int getMicrocycleNo() {
		return microcycleNo;
	}
	public void setMicrocycleNo(int microcycleNo) {
		this.microcycleNo = microcycleNo;
	}
	@Column(name = "SERIES_NO")
	public int getNumber() {
		return number;
	}
	private void setNumber(int number) {
		this.number = number;
	}
	@Column(name = "REPS")
	public int getReps() {
		return reps;
	}
	private void setReps(int reps) {
		this.reps = reps;
	}
	@Column(name = "WEIGHT")
	public double getWeight() {
		return weight;
	}
	private void setWeight(double weight) {
		this.weight = weight;
	}
	@ManyToOne
	@JoinColumn(name = "ID")
	public Excercise getExcercise() {
		return excercise;
	}

	public void setExcercise(Excercise excercise) {
		this.excercise = excercise;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getDoneWeight() {
		return doneWeight;
	}
	public void setDoneWeight(double doneWeight) {
		this.doneWeight = doneWeight;
	}
	public int getDoneReps() {
		return doneReps;
	}
	public void setDoneReps(int doneReps) {
		this.doneReps = doneReps;
	}
	
	public static class SeriesBuilder {
		private int microcycleNo;
		private int number;
		private int reps;
		private double weight;
		private Excercise excercise;
		private double doneWeight;
		private int doneReps;
		private LocalDate date;
		
		public SeriesBuilder setMicrocycleNo(int microcycleNo) {
			this.microcycleNo = microcycleNo;
			return this;
		}
		
		public SeriesBuilder setNumber(int number) {
			this.number = number;
			return this;
		}
		
		public SeriesBuilder setReps(int reps) {
			this.reps = reps;
			return this;
		}
		
		public SeriesBuilder setWeight(double weight) {
			this.weight = weight;
			return this;
		}
		
		public SeriesBuilder setExcercise(Excercise excercise) {
			this.excercise = excercise;
			return this;
		}
		
		public SeriesBuilder setDoneWeight(double doneWeight) {
			this.doneWeight = doneWeight;
			return this;
		}
		
		public SeriesBuilder setDoneReps(int doneReps) {
			this.doneReps = doneReps;
			return this;
		}
		
		public SeriesBuilder setDate(LocalDate date) {
			this.date = date;
			return this;
		}
		
		public Series build() {
			return new Series(microcycleNo, number, reps, weight, excercise);
		}	
	}
	
	public Series buildDoneSeries (Series series, double doneWeight, int doneReps, LocalDate date) {
		series.setDoneWeight(doneWeight);
		series.setDoneReps(doneReps);
		series.setDate(date);
		return series;
	}
}
