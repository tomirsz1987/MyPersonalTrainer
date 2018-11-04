
package com.MyPersonalTrainer.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NamedQuery(
	name = "Excercise.getExcerciseList",
	query = "FROM Excercise WHERE microcycle_no = :VALUE AND user_id = :USER"
	)

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXCERCISE")
public class Excercise {
	private int id;
	private LocalDateTime addingTime;
	private String name;
	private int microcycleNo;
	private List<Series> excercise = new ArrayList<>();
	private User userId;
	
	public Excercise(LocalDateTime addingTime, String name, int microcycleNo, List<Series> excercise, User userId) {
		this.addingTime = LocalDateTime.now();
		this.name = name;
		this.microcycleNo = microcycleNo;		
		this.excercise = excercise;
		this.userId = userId;
	}
	
	@Column(name = "ID", unique = true)
	@GeneratedValue
	@NotNull
	@Id
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	@Column(name = "ADDING_TIME")
	public LocalDateTime getAddingTime() {
		return addingTime;
	}
	public void setAddingTime(LocalDateTime addingTime) {
		this.addingTime = addingTime;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	@Column(name = "MICROCYCLE_NO")
	public int getMicrocycleNo() {
		return microcycleNo;
	}
	private void setMicrocycleNo(int microcycleNo) {
		this.microcycleNo = microcycleNo;
	}
	@JsonIgnore
	@Column(name = "SERIES")
	@OneToMany(
			targetEntity = Series.class,
			mappedBy = "excercise",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	public List<Series> getSeries() {
		return excercise;
	}
	public void setSeries(List<Series> excercise) {
		this.excercise = excercise;
	}
	@ManyToOne
	@JoinColumn(name = "UserId")
	public User getUser() {
		return userId;
	}
	
	public void setUser(User userId) {
		this.userId = userId;
	}
	
	public static class ExcerciseBuilder {
		
		private String name;
		private LocalDateTime addingTime;
		private int microcycleNo;
		private List<Series> excercise = new ArrayList<>();
		private User userId;
		
		public ExcerciseBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public ExcerciseBuilder setExcerciseNumber(LocalDateTime addingTime) {
			this.addingTime = addingTime;
			return this;
		}
		
		public ExcerciseBuilder setMicrocycleNo(int microcycleNo) {
			this.microcycleNo = microcycleNo;
			return this;
		}
		
		public ExcerciseBuilder setSeriesList(List<Series> excercise) {
			this.excercise = excercise;
			return this;
		}
		
		public ExcerciseBuilder setUser(User userId) {
			this.userId = userId;
			return this;
		}
		
		public Excercise built() {
			return new Excercise(addingTime, name, microcycleNo, excercise, userId);
		}
	}
}
