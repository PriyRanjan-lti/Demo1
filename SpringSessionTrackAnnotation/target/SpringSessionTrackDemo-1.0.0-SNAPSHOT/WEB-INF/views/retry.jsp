<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h3>Welcome ${name} </h3><h4>You are Successfully Logged In ,But Exceeds the Max User Limit. Please try after Sometime!</h4>
	
	<a href="<c:url value='/logout' />">Click here to logout</a>
</body>
</html>