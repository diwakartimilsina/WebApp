package com.softbeacon.webapp.utilities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.softbeacon.webapp.beans.User;

public class HibernateTest {

	final static Logger log = Logger.getLogger(HibernateTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		log.info("Creating new User******************************************");

		User newUser = new User();

		newUser.setIdusers(10);
		newUser.setUsername("woodyallen");
		newUser.setFirstname("Woody");
		newUser.setLastname("Allen");
		newUser.setSex("M");
		newUser.setAge(73);
		newUser.setZipcode("72801");
		newUser.setEmail("woody.allen@gmail.com");
		newUser.setDatecreated(new Timestamp(System.currentTimeMillis()));
		
		createUser(newUser);
		
		log.info("Updating new User******************************************");

		newUser.setAge(100);
		
		// Update User
		updateUser(newUser);

		ArrayList<User> users = new ArrayList<User>();
		User user = new User();
		
		log.info("Listing ALL USers*************************");
		users = listUsers(SysConstants.listAllUsers,null);
		user = new User();
		for(Iterator<User> it=users.iterator();it.hasNext();){
			user = it.next();
			log.info(user.getPrintbadge());
		}
		
		log.info("Listing by UserId*************************");
		users = listUsers(SysConstants.listByUserId,"5");
		user = new User();
		for(Iterator<User> it=users.iterator();it.hasNext();){
			user = it.next();
			log.info(user.getPrintbadge());
		}

		log.info("Listing by Username*************************");
		users = listUsers(SysConstants.listByUsername,"diwakar3");
		user = new User();
		for(Iterator<User> it=users.iterator();it.hasNext();){
			user = it.next();
			log.info(user.getPrintbadge());
		}
		
		log.info("Deleting user****************************");
		deleteUser(newUser);
		
	}

	private static ArrayList<User> listUsers(String listingType, String listingValue) {
		ArrayList<User> returnUserList = new ArrayList<User>();
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();

		try {
			tx = session.beginTransaction();
			String sql = new String();
			List<User> users = new ArrayList<User>();
			
			if(listingType.equals(SysConstants.listAllUsers)){
				sql=SqlConstants.listAllUsers;
				users = session.createQuery(sql).list();
			}		
			else if(listingType.equals(SysConstants.listByUserId)){
				sql=SqlConstants.listUserByUserId;
				users = session.createQuery(sql).setInteger(0, Integer.parseInt(listingValue)).list();
			}
			else if(listingType.equals(SysConstants.listByUsername)){
				sql=SqlConstants.listUserByUsername;
				users = session.createQuery(sql).setString(0, listingValue).list();
			}

			User tempUser = new User();;
			for (Iterator<User> iter = users.iterator(); iter.hasNext();) {
				tempUser = (User) iter.next();
				returnUserList.add(tempUser);	
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					log.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
		return returnUserList;
	}


	private static void createUser(User user) {
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					log.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}
	
	private static void updateUser(User user) {
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					log.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}
	
	private static void deleteUser(User user) {
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				try {
					// Second try catch as the rollback could fail as well
					tx.rollback();
				} catch (HibernateException e1) {
					log.debug("Error rolling back transaction");
				}
				// throw again the first exception
				throw e;
			}
		}
	}
}