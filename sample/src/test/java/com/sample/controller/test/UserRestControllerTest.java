package com.sample.controller.test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.hamcrest.Matchers;

import com.sample.dao.UserDao;

import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src\\test\\resources\\test-context.xml")
public class UserRestControllerTest {
	
	 public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8") );

	  @Autowired
	  private WebApplicationContext wac;

	  private MockMvc mockMvc;
	  
	  @Autowired
	  private UserDao userDaoMock;

	  @Before
	  public void setup() {
	    this.mockMvc = webAppContextSetup(this.wac).build();
	    
	  }
	  
		 /*Verifies if it show users */
	  @Test
	  public void showUserTest() throws Exception {
		 when(userDaoMock.show()).thenReturn(new ArrayList<String>());
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/user/show"))
	    	    	.andExpect(content().contentType(APPLICATION_JSON_UTF8));
	    verify(userDaoMock, times(1)).show();
	    verifyNoMoreInteractions(userDaoMock);

	  }
	  
	  
	 /*Verifies if it successfully add users */
	  
	  @Test
	  public void addUserTest() throws Exception {
		when(userDaoMock.add("anna")).thenReturn(true);
	    this.mockMvc.perform(MockMvcRequestBuilders.get("/user/add/anna"))
	    			.andExpect(status().isOk())
	    			.andExpect(content().contentType(APPLICATION_JSON_UTF8));	    
	    verify(userDaoMock, times(1)).add("anna");
	    verifyNoMoreInteractions(userDaoMock);

	
	  }
	  
		/*Verifies if it maps to no arguement rest call when no parameters  */

	  @Test
	  public void addUserInvalid() throws Exception
	  {
		  this.mockMvc.perform(MockMvcRequestBuilders.get("/user/add/"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(APPLICATION_JSON_UTF8));	
		    verifyNoMoreInteractions(userDaoMock);

	  }
	  


}
