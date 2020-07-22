
package com.example.demo;



import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;



@SpringBootTest
@AutoConfigureMockMvc
public class SubmissionFormApplication1ApplicationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	CustomerRepo repo;

	 @MockBean
	    private Customers customers;
	 
	 @LocalServerPort
		private int port;
	 
	 
	
	TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    
 
   @Test
	public Customers getCustomers5(@RequestBody Customers customers) throws Exception
	{
	  
	   HttpEntity<String> entity = new HttpEntity<String>(null, headers);
     ResponseEntity<String> response = restTemplate.exchange(
    		 createURLWithPort ("/customers"), HttpMethod.GET, entity, String.class);
    String expected = "{\"cid\":\"1\",\"cname\":girisha\",\"cemail\":\"giri@gmail.com\"}";
     JSONAssert.assertEquals(expected, response.getBody(), false);
	   
	   
	  /* String expected = "{\"cid\":\"1\",\"cname\":girisha\",\"cemail\":\"giri@gmail.com\"}";
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString(expected))); */
	   
			 
			   repo.save(customers);
				return customers;
			  
    
		
	}



 @Test
	  public Customers getCustomers3(@RequestBody Customers customers) throws Exception
	  {
	  	
	  		 HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	       ResponseEntity<String> response = restTemplate.exchange(
	         createURLWithPort("/customers"), HttpMethod.POST, entity, String.class);
	       String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
	       
	       assertTrue(actual.contains("/customers"));
	  	 
	       repo.save(customers);
	  	 return customers;
	  	
	  	
		}
		

	  private String createURLWithPort(String uri) {
		    return "http://localhost:" + port + uri;
		}





/*@Test
public Customers getCustomers4(@PathVariable("cid")int cid) throws Exception
{
	String expected="[]";
	this.mockMvc.perform(delete("/customers/{cid}")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString(expected)));
	
	
	Customers cust=repo.getOne(cid);
	repo.delete(cust);
	return cust;
}*/



}
 



