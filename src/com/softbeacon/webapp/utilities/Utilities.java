package com.softbeacon.webapp.utilities;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.softbeacon.webapp.utilities.SysConstants;

public class Utilities {
	
	static Logger log = Logger.getLogger(Utilities.class);
	
	
	
	public static void loadPropertiesFile(){
		log.debug("Entering loadPropertiesFile()");
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(SysConstants.popertiesFolder+File.separator+SysConstants.dbPropertiesFile));
			Set<String> keys = props.stringPropertyNames();

			Iterator<String> it = keys.iterator();
			String key="";
			while(it.hasNext()){
				key=it.next();
				SysConstants.propertiesMap.put(key,props.getProperty(key));				
			}
		}

		catch (Exception e) {
			log.error("There was an exception while loading Properties file"+e);
		}
		finally{
			log.debug("Leaving loadPropertiesFile()");
		}
	}
	
	public static void loadLog4JPropertiesFile(){
		log.debug("Entering loadLog4JPropertiesFile()");
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(SysConstants.popertiesFolder+File.separator+SysConstants.log4jPropertiesFile));
		    PropertyConfigurator.configure(props);
		}

		catch (Exception e) {
			log.error("There was an exception while loading Log4J Properties file"+e);
		}
		finally{
			log.debug("Leaving loadLog4JPropertiesFile()");
		}
	}
}
