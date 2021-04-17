package com.sg.gzf.learn.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sg.gzf.learn.tdd.dto.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void getCar_ReturnsCarDetails() throws Exception {
		//arrange
		
		
		//act
		ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getStatusCode().is2xxSuccessful());
		
		assertThat(response.getBody().getName()).isEqualTo("prius");
		assertThat(response.getBody().getType()).isEqualTo("hybrid");
	
		
	}
	

}
