<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LinkHeaven</title>
</head>
<body>
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

	<div class="col-md-8 ml-auto mr-auto">
		<div>
			<br> <br>
			<h4>${subject.header }</h1>
				<hr>
				<h6>
					Not : <span style="font-weight: normal">${subject.note}</span>
				</h6>
				<hr>
				<h6>
					Link : <a href="${subject.link}">${subject.link}</a>
				</h6>
				<hr>
				<h6>
					Ait oldugu depo : <span style="font-weight: normal">${subject.subjectTable.header}</span>
				</h6>
				<hr>
				<h6>
					Oluşturulma tarihi : <span style="font-weight: normal">${subject.date}</span>
				</h6>
				<hr>
		</div>
	</div>

</body>
</html>