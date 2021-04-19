package com.sg.gzf.learn.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

@RestController
public class CarController {
	
	private CarService carService;
	
	public CarController() {
		super();
	}
	
	@Autowired
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping("/cars/{name}")
	private Car  getCar(@PathVariable String name) {
		return carService.getCarDetails(name);
	}
	
}
