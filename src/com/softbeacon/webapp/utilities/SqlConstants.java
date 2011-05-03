package com.softbeacon.webapp.utilities;

public class SqlConstants {

	public static final String listAllUsers = "FROM User";
	public static final String listUserByUserId = "FROM User as user WHERE user.idusers = ?";
	public static final String listUserByUsername = "FROM User as user WHERE user.username = ?";
	
}
