<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="DELETE" action="subject/${subjectId}"
		modelAttribute="subject">
		<form:hidden path="id" />
		<form:hidden path="header" />
		<form:hidden path="link" />
		<form:hidden path="note" />
		<form:hidden path="date" />
		<input type="submit" value="Delete">
	</form:form>

</body>
</html>