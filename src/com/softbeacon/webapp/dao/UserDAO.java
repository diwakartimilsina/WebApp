package com.softbeacon.webapp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.softbeacon.webapp.beans.User;
import com.softbeacon.webapp.utilities.SqlConstants;
import com.softbeacon.webapp.utilities.SysConstants;

@Path("/myresource")
public class UserDAO implements UserDAOInterface {

	final static Logger log = Logger.getLogger(UserDAO.class);

	public UserDAO() {

	}

	@GET
	@Path("/listuserbyid")
	@Produces("application/xml")
	public ArrayList<User> listUserById(@QueryParam("id") Integer id) {
		log.debug("Listing users");
		ArrayList<User> returnUserList = new ArrayList<User>();
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();

		try {
			tx = session.beginTransaction();
			String sql = new String();
			List<User> users = new ArrayList<User>();

			sql = SqlConstants.listUserByUserId;
			users = session.createQuery(sql).setInteger(0, id).list();

			User tempUser = new User();
			
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
		log.debug("Returning list of " + returnUserList.size() + " users.");
		return returnUserList;
	}

	public ArrayList<User> listUsers(String listingType, String listingValue) {
		log.debug("Listing users");
		ArrayList<User> returnUserList = new ArrayList<User>();
		Transaction tx = null;
		Session session = new Configuration().configure().buildSessionFactory()
				.getCurrentSession();

		try {
			tx = session.beginTransaction();
			String sql = new String();
			List<User> users = new ArrayList<User>();

			if (listingType.equals(SysConstants.listAllUsers)) {
				sql = SqlConstants.listAllUsers;
				users = session.createQuery(sql).list();
			} else if (listingType.equals(SysConstants.listByUserId)) {
				sql = SqlConstants.listUserByUserId;
				users = session.createQuery(sql)
						.setInteger(0, Integer.parseInt(listingValue)).list();
			} else if (listingType.equals(SysConstants.listByUsername)) {
				sql = SqlConstants.listUserByUsername;
				users = session.createQuery(sql).setString(0, listingValue)
						.list();
			}

			User tempUser = new User();

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
		log.debug("Returning list of " + returnUserList.size() + " users.");
		return returnUserList;
	}
	
	@POST
	@Path("/insertuser")
	@Consumes("application/xml")

	public void createUser(User user) {
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
				throw e;
			}
		}
	}

	public void updateUser(User user) {
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

	public void deleteUser(User user) {
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
