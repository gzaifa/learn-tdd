package com.sg.gzf.learn.tdd.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String name;
	
	private String type;
	
	public Car() {
		super();
	}
	
	public Car(String name, String type) {
		this.name = name;
		this.type = type;
	}	
}
