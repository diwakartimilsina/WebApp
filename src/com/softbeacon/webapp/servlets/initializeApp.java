package com.softbeacon.webapp.servlets;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

import com.softbeacon.webapp.utilities.Utilities;



public class initializeApp implements ServletContextListener{

	Logger log = Logger.getLogger(initializeApp.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		// Load Log4J properties file
		Utilities.loadLog4JPropertiesFile();
		
		log.debug("Initializing stuff for the web apps");
		
		// Load DB Properties file
		Utilities.loadPropertiesFile();
	}
}
