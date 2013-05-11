/**
 * 
 */
package com.neurosoft.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
// @RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "userList", method = RequestMethod.GET)
	protected ModelAndView getUserList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("userList", "users", userService.listAllUsers());
	}

	@RequestMapping(value = "deleteUser", method = RequestMethod.GET)
	protected ModelAndView deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			User user = userService.getUser(id);
			userService.deleteUser(user);
		}
		return new ModelAndView("userList", "users", userService.listAllUsers());
	}

	@RequestMapping(value="userEdit", method = RequestMethod.GET)
    protected ModelAndView editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	User user = null;
    	if (request.getParameter("id") != null) {
            try {
                Long id = new Long(request.getParameter("id"));
                user = userService.getUser(id);
            } catch (NumberFormatException ignored) {
            }
        }
    	Map<String, Object> model = new HashMap<String, Object>();
    	/*Map referenceData = new HashMap();
    	Map<String,String> country = new LinkedHashMap<String,String>();
    	country.put("US", "United Stated");
    	country.put("CHINA", "China");
    	country.put("SG", "Singapore");
    	country.put("MY", "Malaysia");
    	referenceData.put("countryList", country);*/
    	//model.addAllAttributes(referenceData);
    	List< String > countryList = new ArrayList<String>();
    	countryList.add("Bangladesh");
    	countryList.add("USA");
    	countryList.add("UK");
    	countryList.add("India");
    	model.put("user", user);
    	model.put("countryList", countryList);
        return new ModelAndView("userEdit", "model", model);
    }

	@RequestMapping(value = "userEdit", method = RequestMethod.POST)
	protected ModelAndView saveUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = new User();
		if (request.getParameter("id") != null
				&& request.getParameter("id") != "")
			user.setId(Long.parseLong(request.getParameter("id")));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		userService.addOrUpdateUser(user);
		return new ModelAndView("userList", "users", userService.listAllUsers());
	}

}
