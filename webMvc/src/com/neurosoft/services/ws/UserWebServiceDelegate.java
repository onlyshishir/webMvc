package com.neurosoft.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import com.neurosoft.services.UserService;

@javax.jws.WebService(targetNamespace = "http://ws.services.neurosoft.com/", serviceName = "UserWebServiceService", portName = "UserWebServicePort", wsdlLocation = "WEB-INF/wsdl/UserWebServiceService.wsdl")
@javax.xml.ws.BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class UserWebServiceDelegate {

	com.neurosoft.services.ws.UserWebService userWebService = new com.neurosoft.services.ws.UserWebService();

	public void setUserService(UserService userService) {
		userWebService.setUserService(userService);
	}

	public Boolean usernameExists(String username) {
		return userWebService.usernameExists(username);
	}

}