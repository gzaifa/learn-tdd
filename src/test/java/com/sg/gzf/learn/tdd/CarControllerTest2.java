package com.sg.gzf.learn.tdd;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.anyString;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sg.gzf.learn.tdd.dto.Car;
import com.sg.gzf.learn.tdd.service.CarService;

@WebMvcTest
class CarControllerTest2 {
	@MockBean
	private CarService carService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getCar_ReturnCarDetails() throws Exception {
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hyrbid"));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("name").value("prius"))
			.andExpect(jsonPath("type").value("hybrid"));
	}
}
