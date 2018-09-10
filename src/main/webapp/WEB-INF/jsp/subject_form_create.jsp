<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:url var="postLink" value="subject" >
	<c:param name="tableId" value="${tableId}" ></c:param>
</c:url>

<form:form method="POST" action="${postLink}" modelAttribute="subject">
	<label>Header</label>
	<form:input path="header" />
	<label>Link</label>
	<form:input path="link"/>
	<label>Note</label>
	<form:input path="note"/>
	<label>Date</label>
	<form:input path="date"/>
	<input type="submit" value="Save" >
</form:form>
</body>
</html>