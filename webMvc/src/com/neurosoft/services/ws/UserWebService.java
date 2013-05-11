/**
 * 
 */
package com.neurosoft.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.neurosoft.services.UserService;

/**
 * @author Adnan
 * 
 */
@WebService
public class UserWebService extends SpringBeanAutowiringSupport {

	private UserService userService;

	@Required
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@WebMethod
	public Boolean usernameExists(
			@WebParam(name = "username", targetNamespace = "") String username) {
		return userService.getUserByUsername(username) != null;
	}

}
