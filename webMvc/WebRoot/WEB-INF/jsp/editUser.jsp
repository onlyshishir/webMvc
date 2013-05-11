<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit User</title>
</head>
<body>
	<div>
		<h3><spring:message code="label.title"/></h3>
		<span style="float: right">
		    <a href="?lang=en">en</a> 
		    | 
		    <a href="?lang=ban">ban</a>
		</span>
	</div>
	<form action="editUser" method="post">
	    <input type="hidden" name="id" value="${user.id}"/>
	    <table>
	        <tr>
	            <td>
	                User Name
	            </td>
	            <td>
	                <input type="text" name="username" value="${user.username}"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                Password
	            </td>
	            <td>
	                <input type="password" name="password" value="${user.password}"/>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2" style="text-align:center;">
	                <input type="submit" value="<spring:message code='add'/>"/>
	                <input type="reset"/>
	            </td>
	        </tr>
	    </table>
	</form>

</body>
</html>