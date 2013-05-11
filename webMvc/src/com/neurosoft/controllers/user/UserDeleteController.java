/**
 * 
 */
package com.neurosoft.controllers.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.neurosoft.entities.User;
import com.neurosoft.services.UserService;

/**
 * @author Adnan
 * 
 */
public class UserDeleteController extends AbstractController {

	UserService userService;
	private String view;

	@Required
	public void setView(String view) {
		this.view = view;
	}

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	final Logger log = LoggerFactory.getLogger(UserDeleteController.class);

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			User user = userService.getUser(id);
			userService.deleteUser(user);
		}
		return new ModelAndView(view, "users", userService.listAllUsers());
	}

}
