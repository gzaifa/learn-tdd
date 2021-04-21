package com.sg.gzf.learn.tdd;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CachingTest {
	private static final String PRIUS = "prius";

	@Autowired
	private CarService carService;
	
	@MockBean
	private CarRepository carRepository;
	
	@Test
	public void getCar_ReturnsCachedCarSecondTime() throws Exception {
		given(carRepository.findByName(anyString())).willReturn(new Car(PRIUS, "hybrid"));
		
		carService.getCarDetails(PRIUS);
		carService.getCarDetails(PRIUS);
		
		verify(carRepository, times(1)).findByName(PRIUS);
	}
	
}
