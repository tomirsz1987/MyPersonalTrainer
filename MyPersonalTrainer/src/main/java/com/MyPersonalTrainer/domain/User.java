package com.MyPersonalTrainer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "UserId", unique = true)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @JsonIgnore
    @Column(name = "excercise")
	@OneToMany(
			targetEntity = Excercise.class,
			mappedBy = "user",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.LAZY
			)
    private List<Excercise> excercise = new ArrayList<>();
    
    public User(String username, String password, List<Excercise> excercise) {
    	this.username = username;
    	this.password = password;
    	this.excercise = excercise;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
	public List<Excercise> getExcercise() {
		return excercise;
	}

	public void setExcercise(List<Excercise> excercise) {
		this.excercise = excercise;
	}


}