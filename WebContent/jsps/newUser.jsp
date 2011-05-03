<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head><link rel="stylesheet" type="text/css" href="css/main.css" /></head>
<body>
	<h1>Insert New Person</h1>

	<form:form method="post" commandName="user">

		<table>
			
			<tr><td>Username:</td><td><form:input path="username"/> <form:errors path="username" cssClass="error"/></td>
			<tr><td>First Name:</td><td><form:input path="firstname"/> <form:errors path="firstname" cssClass="error"/></td>
			<tr><td>Last Name:</td><td><form:input path="lastname"/> <form:errors path="lastname" cssClass="error"/></td>
			<tr><td>Sex:</td><td><form:input path="sex" maxlength="1"/> <form:errors path="sex" cssClass="error"/></td>
			<tr><td>Age:</td><td><form:input path="age"/> <form:errors path="age" cssClass="error"/></td>
			<tr><td>Zipcode:</td><td><form:input path="zipcode"/> <form:errors path="zipcode" cssClass="error"/></td>
			<tr><td>Email:</td><td><form:input path="email"/> <form:errors path="email" cssClass="error"/></td>
			<tr><td></td><td><input type="submit" value="Submit"> </td></tr>

		</table>
	</form:form>
</body>
</html>