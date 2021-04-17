package com.sg.gzf.learn.tdd;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sg.gzf.learn.tdd.controller.CarController;
import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

/**
 * WebMvcTest will not start up the entire SpringBoot application
 * it will just wire up the components that are necessary for the WebMVvc test, i.e. the controller
 * @author Zaifa
 *
 */
@WebMvcTest(CarController.class)
public class CarControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	
	@Test
	private void getCar_ReturnsCarDetails() throws Exception {
		
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("prius"))
				.andExpect(jsonPath("type").value("prius"));
		
	}
	
}
