package com.sg.gzf.learn.tdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

@RestController
public class CarController {
	private CarService carService;
	
	
	
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}



	@GetMapping("/car/{name}")
	public Car  getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
}
