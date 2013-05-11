/**
 * 
 */
package com.neurosoft.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neurosoft.entities.User;
import com.neurosoft.services.UserService;

/**
 * @author Adnan
 *
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping(value="login", method = RequestMethod.POST)
    protected ModelAndView loginUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//User user = new User();
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	User user = userService.getUserByUsername(username);
    	if(user.getPassword().equals(password))
    		return new ModelAndView("userList", "users", userService.listAllUsers());
    	else
    		return new ModelAndView("login");
    }
	
	@RequestMapping(value="login", method = RequestMethod.GET)
    protected ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	return new ModelAndView("login");
    }
	
}
