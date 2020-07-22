package com.example.demo;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpHeaders;


import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	//@Autowired
	//private MockMvc mockMvc;
	
	 @MockBean
	    private Customers customers;
	
	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
	


	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		
		String expected="[{\"cid\":\"1\",\"cname\":girisha\",\"cemail\":\"giri@gmail.com\"}]";
		
		/*this.mockMvc.perform(get("/customers")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().json(expected));*/


		  assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/customers",
				String.class)).contains(expected);
		
		           
		            
	}
}