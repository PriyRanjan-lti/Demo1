<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Logged In Users:</h3>
<form>
	<c:forEach var="user" items="${users}">

		<li>${user}</li>

	</c:forEach>
</form>