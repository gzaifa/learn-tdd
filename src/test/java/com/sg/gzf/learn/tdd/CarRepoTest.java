package com.sg.gzf.learn.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.gzf.learn.tdd.dto.Car;


@RunWith(SpringRunner.class)
@DataJpaTest
class CarRepoTest {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	void findCar_ReturnsCarDetails() throws Exception {
		Car savedCar = entityManager.persistFlushFind(new Car("Accord", "petrol"));
		
		assertThat(savedCar.getId())
		.isNotNull()
		.isNotNegative();
		
		Car retrievedCar = carRepository.findByName("Accord");
		
		assertThat(savedCar).isEqualTo(retrievedCar);
	}
}
