package com.sg.gzf.learn.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CarServiceTest {
	@MockBean
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@Test
	void findCar_ReturnCarDetails() throws Exception {
		given(carRepository.findByName(anyString())).willReturn(new Car("Accord", "petrol"));
		
		Car retrievedCar = carService.getCarDetails("Accord");
		
		assertThat(retrievedCar).isNotNull();
	}
	
}
