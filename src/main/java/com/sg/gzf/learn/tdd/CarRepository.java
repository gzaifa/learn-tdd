package com.sg.gzf.learn.tdd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.gzf.learn.tdd.dto.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	public Car findByName(String name);
	
}
