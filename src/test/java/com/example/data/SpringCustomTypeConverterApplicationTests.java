package com.example.data;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.assertj.core.api.Assertions.assertThat; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.web.servlet.MockMvc;

import com.example.data.controllers.OrderController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringCustomTypeConverterApplicationTests {


	@Autowired
	ConversionService conversionService;
	@Autowired
	private MockMvc mockMvc;
	
	
	@Autowired
	private OrderController orderController;
	
	/**
	 * Test checks that instance of controller was created and injeced sucessfully
	 */
	@Test
	void contextLoads() {
		assertThat(orderController).isNotNull();
	}
	
	
	/**
	 * 
	 * Test check that instance of controller return correct JSON object  
	 * 
	 * @throws Exception
	 */
	@Test
	public void getStringToLocalDataTest() throws Exception{
		String description = "TP-Link AC1750 Smart WiFi Router - Dual Band Gigabit Wireless Internet Router for Home, "
				+ "Works with Alexa, VPN Server, Parental Control&QoS (Archer A7).";
		String data = "2020-07-26";
		this.mockMvc.perform(get("http://localhost:8080/orders/order/20200726"))
		.andDo(print())
		.andExpect(jsonPath("$.carg", is(64.99)))
		.andExpect(jsonPath("$.description", is(description)))
		.andExpect(jsonPath("$.data", is(data)));
	}

}
