<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<title>Users List</title>
</head>
<body>
	<a href="userEdit.html">Add New User</a>
	<table border="1px">
    <thead>
    <th>User Id</th>
    <th>User Name</th>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td><a href="userEdit.html?id=${user.id}">${user.username}</a></td>
        <td><a href="deleteUser.html?id=${user.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>