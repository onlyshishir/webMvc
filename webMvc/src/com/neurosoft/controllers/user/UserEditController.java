/**
 * 
 */
package com.neurosoft.controllers.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.neurosoft.entities.User;
import com.neurosoft.services.UserService;

/**
 * @author Adnan
 * 
 */
@SuppressWarnings("deprecation")
public class UserEditController extends SimpleFormController {

	UserService userService;

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserEditController() {
		setCommandClass(User.class);
		setCommandName("user");
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		User user = (User) super.formBackingObject(request);
		if (request.getParameter("id") != null && user.getId() == null) {
			try {
				Long id = new Long(request.getParameter("id"));
				user = userService.getUser(id);
			} catch (NumberFormatException ignored) {
			}
		}
		return user;
	}

	@Override
	protected ModelAndView onSubmit(Object o, BindException e) throws Exception {
		User user = (User) o;
		try {
			userService.addOrUpdateUser(user);
		} catch (Exception ignore) {
		}
		return new ModelAndView(new RedirectView(getSuccessView()), "users",
				userService.listAllUsers());
	}

}
