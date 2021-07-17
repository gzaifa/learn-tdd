package com.sg.gzf.learn.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CarServiceTest2 {
	@MockBean
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
		
	@Test
	void findCar_ReturnsCarDetails() throws Exception {
		
		//This is a unit test of Car Service, so we mock carRepo.
		//Testing the inner workings of CarService. 
		//In this case, CarService does nothing except calls carRepository.findByName to return the values,
		//however, in a real application, there might be other business logic or code that runs,
		// and these are the logic, code that we want to test in this unit test. 
		// Otherwise, this would be a int
		given(carRepository.findByName(anyString())).willReturn(new Car("Accord", "petrol"));
		
		Car retrievedCar = carService.getCarDetails("Accord");
		
		assertThat(retrievedCar.getName()).isNotNull();
	}
	
	
}
