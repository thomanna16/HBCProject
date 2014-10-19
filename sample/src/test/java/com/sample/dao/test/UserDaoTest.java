package com.sample.dao.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.dao.UserDao;
import com.sample.dao.UserDaoImpl;
@ContextConfiguration(locations={"file:src\\main\\webapp\\WEB-INF\\application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	

	/*Test if it add values and returns*/
	@Test
	public void addUser()
	{
		userDao.add("Anna");
		userDao.add("Thomas");
		
		List<String> actual=new ArrayList<String>();
		actual.add("Anna");
		actual.add("Thomas");
		
        Assert.assertEquals(actual.size(), userDao.show().size());
        for(int i=0;i<actual.size();i++)
        	Assert.assertEquals(actual.get(i), userDao.show().get(i));
	}
	
	
	

}
