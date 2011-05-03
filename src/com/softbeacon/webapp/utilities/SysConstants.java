package com.softbeacon.webapp.utilities;

import java.util.HashMap;



public class SysConstants {

	public static final String dbPropertiesFile = "database_connection.properties";
	public static final String log4jPropertiesFile = "log4j.properties";
	public static final String popertiesFolder = "config";
	public static final String dbServer="database.server";
	public static final String dbUser="database.user";
	public static final String dbPassword="database.password";

	public static HashMap<String,String> propertiesMap = new HashMap<String,String>();
	
	public static final String listAllUsers = "LIST_ALL_USERS";
	public static final String listByUserId = "LIST_BY_USER_ID";
	public static final String listByUsername = "LIST_BY_USERNAME";
	
}
