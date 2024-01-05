<%@include file="header.html"%>
<html>
<head>
<title>View by Group</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

<h2>View by Group</h2>

<!--  <c:set var="emailList" value="${sessionScope.eMailList}"/> -->
	
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
		<c:forEach var="group" items="${eMailList}">
		<tr>
		    <td>${group.eMailID}</td>
			<td>${group.fName}</td>
		    <td>${group.mName}</td>	
		    <td>${group.lName}</td>
		    <td>${group.hPhone}</td>
			<td>${group.wPhone}</td>
			<td>${group.mPhone}</td>
			<td>${group.groupID}</td>
		</tr>
		</c:forEach>
	</table>

	</body>
	</html>
<%@include file="footer.html"%>

	
	</body>
	</html>

	
