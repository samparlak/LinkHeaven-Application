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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
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

<script type="text/javascript">
	$(document).ready(function() {
		// executes when HTML-Document is loaded and DOM is ready
		console.log("document is ready");

		$(".card-body").hover(function() {
			$(this).addClass('card-hover');
		}, function() {
			$(this).removeClass('card-hover');
		});

		// document ready  
	});
</script>
<style type="text/css">
.card-hover {
	background-color: #f2f2f2;
	transform: scale(1.01);
	border: 1px #17A2B8 solid;
	border-radius: 5px 5px 5px 5px;
	box-shadow: 0px 0px 10px 2px #17A2B8;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>LinkHeaven</title>
</head>
<body style="background-color: #F4F8F7;">

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

	<div class="container-fluid">
		<div class="col-md-12 row mb-5">
			<div class="col-md-10 ml-auto mr-auto">

				<!-- Link Repository List Header -->
				<div class="card">
					<div class="card-header bg-info">
						<div>
							<h5 class="text-center text-white  font-weight-bold">Tüm
								Link Depoları</h5>
						</div>
						<hr>
						<div class="d-flex justify-content-around">
							<div>
								<button
									onclick="window.location.href='${pageContext.request.contextPath}/mvc/table-form-create'"
									class="btn btn-success font-weight-bold">Depo Oluştur</button>
							</div>
							<div class="col-8 ml-3">
								<form:form
									action="${pageContext.request.contextPath}/mvc/search-subjectTables"
									modelAttribute="search" method="POST">
									<div class="input-group">
										<form:input path="word" type="text" class="form-control"
											placeholder="Link deposu ara..." />
										<div class="input-group-append">
											<button class="btn btn-light  text-info font-weight-bold"
												type="submit">
												<i class="fas fa-search"></i>
											</button>
										</div>
									</div>
								</form:form>
							</div>
							<div class="ml-3">
								<div class="dropdown text-info font-weight-bold">
									<a
										class="btn btn-light dropdown-toggle text-info font-weight-bold"
										href="#" role="button" id="dropdownMenuLink"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> Sıralama Ölçütü </a>

									<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/mvc/allTables">Alfabetik</a>
										<a class="dropdown-item"
											href="${pageContext.request.contextPath}/mvc/allTables-sortByDate">Kronolojik</a>
										<a
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--Link Repository List -->
				<c:forEach items="${tables}" var="table">
					<c:url var="updateTableLink"
						value="${pageContext.request.contextPath}/mvc/table-form-update">
						<c:param name="id" value="${table.id}"></c:param>
					</c:url>
					<c:url var="deleteTableLink"
						value="${pageContext.request.contextPath}/mvc/table-form-delete">
						<c:param name="id" value="${table.id}"></c:param>
					</c:url>
					<div style="cursor: pointer"
						onclick="window.open('${pageContext.request.contextPath}/mvc/table/${table.id}','_blank')"
						class="card border-info ">
						<div class="card-body">
							<div class="d-flex justify-content-around">
								<div class="col-9">
									<h5 class="card-title">${table.header}</h5>
								</div>
								<div class="col-2 mr-4">
									<div class="btn-group">
										<button class="btn  btn-success"
											onclick="window.open('${pageContext.request.contextPath}/mvc/table/${table.id}','_blank')">İncele</button>
										<button class="btn  btn-primary"
											onclick="window.open('${updateTableLink}','_blank')">Düzenle</button>
										<button class="btn  btn-danger"
											onclick="window.open('${deleteTableLink}','_blank')">Sil</button>
									</div>
								</div>
							</div>
							<br>
							<p class="lead text-right" style="font-size: 15px;">
								${table.date}</p>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>

</body>
</html>