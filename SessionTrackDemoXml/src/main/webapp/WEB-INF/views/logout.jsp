<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
	<h4>Please Try Login After Sometime !!</h4>
	<a href="<c:url value='/login' />">Click here to Login Again</a>
</body>
</html>
