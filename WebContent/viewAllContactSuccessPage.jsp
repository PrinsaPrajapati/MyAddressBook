<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all Contact Success Page</title>
</head>
<body>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<c:set var="emaillist" value="${sessionScope.emaillist}"/> 
	
	<table border="2" cellpadding="1" cellspacing="0" width="100%">
		<tr>
			<th>Email Id</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Home Phone</th>
			<th>Work Phone </th>
			<th>Mobile Phone</th>
			<th>Group ID</th>
		</tr>
		<c:forEach var="email" items="${emaillist}">
		<tr>
		    <td>${email.eMailID}</td>
			<td>${email.fName}</td>
		    <td>${email.mName}</td>	
		    <td>${email.lName}</td>
		    <td>${email.hPhone}</td>
			<td>${email.wPhone}</td>
			<td>${email.mPhone}</td>
			<td>${email.groupID}</td>
		</tr>
		</c:forEach>
	</table>

	
<%@include file="footer.html"%>
	</body>

</html>
