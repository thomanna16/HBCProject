package com.sample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.dao.UserDao;
import com.sun.jersey.api.client.ClientResponse.Status;

@Controller
@RequestMapping(value="/user")
public class UserRestController {
	
	private UserDao userDao;
	
	/* this method displays the users and returns in a JSON format */
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	@Produces("application/json")
	public @ResponseBody List<String> getUsers() {	
		return userDao.show();

	}
	
	/* this method add user and returns success of failure in JSON format 
	 * This method should ideally be using POST. However, since the question 
	 * mandates the request in http://localhost:8080/sample/add/<name> format, I
	 * have used get
	 * */

	@RequestMapping(value="/add/{name}", method = RequestMethod.GET)
	@Produces("application/json")
	public @ResponseBody Response addUsers(@PathVariable String name) {
		if(userDao.add(name))
		{
			return	Response.status(200).entity(name).build();	
		}
		 return	Response.status(400).entity(name).build();

 
	}
	
	/* this method handles no arguement user addition */

	@RequestMapping(value="/add", method = RequestMethod.GET)
	@Produces("application/json")
	public @ResponseBody Response addUsers() {
		 return	Response.status(404).build();
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
