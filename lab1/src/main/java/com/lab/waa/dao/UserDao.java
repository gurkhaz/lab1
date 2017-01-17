package com.lab.waa.dao;

import java.util.HashMap;

import com.lab.waa.model.Users;

public class UserDao {
	
	HashMap<String, String> hmap = new HashMap<String, String>();
	
	public UserDao(){
	
   
	hmap.put("admin", "test123");   
	hmap.put("hari", "1234");
   
	}
	
	 public boolean validate(Users user){
		 
		 
		 if(hmap.containsKey(user.getUsername()))
		 {
			 if(hmap.get(user.getUsername()).equals(user.getPassword())){
				 return true;			 
			 }
		 }
		 
		 
			 
			 return false; 
				 
	 }
		

}
