package com.softbeacon.webapp.servlets;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softbeacon.webapp.beans.User;
import com.softbeacon.webapp.dao.UserDAO;

@Controller
@RequestMapping("/insertUser.html")
public class NewUserController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(final ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "newUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(final ModelMap model, @Valid final User user,
			final BindingResult result) {

		if (result.hasErrors()) {
			return "newUser";
		}

    	UserDAO dao = new UserDAO();
    	dao.createUser(user);
    	
		return "redirect:/showUserlist.html";
	}
}