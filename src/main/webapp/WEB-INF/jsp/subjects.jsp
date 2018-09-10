<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table List</title>
</head>
<body>
	<div class="container-fluid bg-info col-md-12" style="height: 200px;">
		<h1 class="text-white text-center pt-5"
			style="font-size: 55px; font-weight: bold;">MyList</h1>
	</div>
	<div class="col-sm-8 mt-4 ml-auto mr-auto">
		<h3 class="text-center mb-4">All Subjects</h3>
		<table class="table mb-5">
			<thead class="thead-dark">
				<tr>
					<th><a href="${pageContext.request.contextPath}/api/allSubjects/sortHeader">Header</a></th>
					<th>Link</th>
					<th>Note</th>
					<th><a href="${pageContext.request.contextPath}/api/allSubjects/sortDate">Date</a></th>
					<th>Table</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<c:forEach items="${subjects}" var="subject">
				<c:url var="updateLink"
					value="${pageContext.request.contextPath}/api/subject-form-update">
					<c:param name="tableId" value="${subject.subjectTable.id}"></c:param>
					<c:param name="subjectId" value="${subject.id}" />
				</c:url>
				<c:url var="deleteLink"
					value="${pageContext.request.contextPath}/api/subject-form-delete">
					<c:param name="subjectId" value="${subject.id}" />
				</c:url>
				<tr>
					<td>${subject.header}</td>
					<td><a href="${subject.link}">${subject.link}</a></td>
					<td>${subject.note}</td>
					<td>${subject.date}</td>
					<td><a href="/api/table/${subject.subjectTable.id}">${subject.subjectTable.header}</a></td>
					<td>
						<div class="btn-group" role="group" aria-label="Basic example">
							<button type="button" class="btn btn-success"
								onclick="window.location.href='${pageContext.request.contextPath}/api/subject/${subject.id}'">View</button>
							<button type="button" class="btn btn-primary"
								onclick="window.location.href='${updateLink}'">Modify</button>
							<button type="button" class="btn btn-danger"
								onclick="window.location.href='${deleteLink}'">Delete</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>