<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LinkHeaven</title>
</head>
<body>

	<!--Logo ve Navigasyon-->
	<nav
		class="navbar navbar-expand-lg navbar-light text-left pt-4 pl-5 mb-2 "
		style="background-color: #F4F8F7;">
	<div class="col-3">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/mvc/home">
			<h1 class=" text-info"
				style="font-size: 35px; font-weight: bold; text-shadow: 3px 3px 3px lightblue;">LinkHeaven</h1>
		</a>
	</div>
	<div class=" navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info"
				href="${pageContext.request.contextPath}/mvc/home">Anasayfa</a></li>
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info ml-5 mr-5"
				href="${pageContext.request.contextPath}/mvc/allTables">Link
					Depoları</a></li>
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info"
				href="${pageContext.request.contextPath}/mvc/allSubjects">Linkler</a></li>
		</ul>
	</div>
	</nav>

	<c:url var="postLink" value="subject">
		<c:param name="tableId" value="${tableId}"></c:param>
	</c:url>
	<div class="mt-3">
		<form:form method="POST" action="${postLink}" modelAttribute="subject">
			<div class="col-6 mr-auto ml-auto mt-4">
				<h5 class="text-center">Link Oluştur</h5>
				<form:hidden path="id" />
				<div class="form-group">
					<label>Link Başlığı</label>
					<form:input cssClass="form-control" path="header" />
				</div>
				<div class="form-group">
					<label>Link</label>
					<form:input cssClass="form-control" path="link" />
				</div>
				<div class="form-group">
					<label>Note</label>
					<form:textarea cssClass="form-control" path="note" />
				</div>
				<form:hidden path="date" />
				<input type="submit" class="btn btn-primary" value="Kaydet">
			</div>
		</form:form>
	</div>

</body>
</html>