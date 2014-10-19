package com.sample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

public class UserDaoImpl implements UserDao {
	public boolean add(String username) {
		
		if(username==null || username =="" || username==" " )
			return false;
		UserCache.userNameList.add(username);
	    return true;
		}
		
		public List<String> show() {
	      return UserCache.userNameList;

		}
	 

}