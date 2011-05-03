package com.softbeacon.webapp.servlets;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softbeacon.webapp.beans.User;
import com.softbeacon.webapp.dao.UserDAO;
import com.softbeacon.webapp.utilities.SysConstants;

@Controller
@RequestMapping("/showUserlist.html")
public class ListUsersController{
 
    private ArrayList<User> listOfUsers ;

    @RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model) {
    	listOfUsers = new ArrayList<User>();
		UserDAO dao = new UserDAO();
		listOfUsers = dao.listUsers(SysConstants.listAllUsers,null);
		model.addAttribute("listOfUsers", listOfUsers);
		return "userList";
	}
}