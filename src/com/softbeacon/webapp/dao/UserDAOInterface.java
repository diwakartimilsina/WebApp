package com.softbeacon.webapp.dao;

import java.util.ArrayList;

import com.softbeacon.webapp.beans.User;

public interface UserDAOInterface {

	public void createUser(User user);
	public void deleteUser(User user);
	public ArrayList<User> listUsers(String listingType, String listingValue);
	public void updateUser(User user);
	
}
