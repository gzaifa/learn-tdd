package com.sg.gzf.learn.tdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sg.gzf.learn.tdd.CarRepository;
import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.exceptions.CarNotFoundException;


@Service
public class CarService {
	
	private CarRepository carRepository;
	
	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Cacheable("cars")
	public Car getCarDetails(String name) {
		Car car = carRepository.findByName(name);
		if (car == null) {
			throw new CarNotFoundException();
		}
		
		return car;
	}
}
