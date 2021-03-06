package com.sg.gzf.learn.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.gzf.learn.tdd.dto.Car;

@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	void findCar_ReturnCarDetails() throws Exception {
		Car savedCar = entityManager.persistFlushFind(new Car("Accord", "petrol"));
		
		assertThat(savedCar.getId())
		.isNotNull()
		.isNotNegative();
		
		Car retrievedCar = carRepository.findByName("Accord");
		
		assertThat(retrievedCar).isEqualTo(savedCar);
	}
	
}
