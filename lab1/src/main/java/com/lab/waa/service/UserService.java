package com.lab.waa.service;

import com.lab.waa.dao.UserDao;
import com.lab.waa.model.Users;

public class UserService {
	
	
 public boolean validate(Users user){
	 
	 UserDao dao = new UserDao();
	 Boolean result = dao.validate(user);
	 
	return result; 
	 
 }
	
	

}
