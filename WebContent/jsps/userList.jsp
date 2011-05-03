<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
Hello There..
<br>
Here are the list of users:
<br>
<c:forEach var="x" items="${listOfUsers}" >
  ${x.printbadge}
  <hr>
</c:forEach>
</body>
</html>