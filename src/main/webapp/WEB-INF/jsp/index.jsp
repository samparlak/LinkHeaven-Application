<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<script type="text/javascript">
	function sortByKey(array, key) {
		return array.sort(function(a, b) {
			var x = a[key];
			var y = b[key];
			return ((x < y) ? -1 : ((x > y) ? 1 : 0));
		});
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MyList</title>
</head>
<body style="background-color: #F4F8F7;">

	<!--Logo ve Navigasyon-->
	<nav
		class="navbar navbar-expand-lg navbar-light text-left pt-4 pl-5 mb-2 "
		style="background-color: #F4F8F7;">
	<div class="col-3">
		<a class="navbar-brand" href="#">
			<h1 class=" text-info"
				style="font-size: 35px; font-weight: bold; text-shadow: 3px 3px 3px lightblue;">LinkHeaven</h1>
		</a>
	</div>
	<div class=" navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info" href="#">Anasayfa</a></li>
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info ml-5 mr-5" href="#">Link Depoları</a></li>
			<li class="nav-item active font-weight-bold "><a
				class="nav-link text-info" href="#">Linkler</a></li>
		</ul>
	</div>
	</nav>

	<div class="container-fluid">
		<div class="col-md-12 row">
			<div class="col-md-3">

				<!-- Link deposu oluşturma,arama,sıralama-->
				<div class="card mb-2 bg-info">
					<div class="card-header">
						<div class="row d-flex justify-content-around">
							<h5 class="text-left text-white font-weight-bold">Link
								Depoları</h5>
							<button class="btn btn-sm  btn-success font-weight-bold">Depo
								Oluştur</button>
						</div>
						<hr>
						<form>
							<div class="form-row d-flex-justify-content-around">
								<div class="col-7">
									<input type="search" class="form-control form-control-sm"
										placeholder="Link deposu ara...">
								</div>
								<div class="col-5">
									<select class="custom-select custom-select-sm">
										<option value="1">Alfabetik</option>
										<option value="2">Kronolojik</option>
									</select>
								</div>
							</div>
						</form>
					</div>
				</div>

				<!-- Link depoları listesi -->
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action">
						<div class="d-flex justify-content-between">
							<h6 class="text-left">Depo Adı</h6>
							<p class="text-right lead" style="font-size: 13px;">2 gün
								önce</p>
						</div>
					</a>
				</div>

			</div>

			<div class="col-md-9">

				<!-- Link Listesi Başlık -->
				<div class="card mb-2">
					<div class="card-header bg-info">
						<div>
							<h5 class="text-center text-white  font-weight-bold">Tüm
								Linkler</h5>
						</div>
						<hr>
						<form>
							<div class="form-row ">
								<div class="col-9 ml-3">
									<input type="search" class="form-control "
										placeholder="Link konu başlığı ara...">
								</div>
								<div class="col-2 ml-3">
									<div class="dropdown text-info font-weight-bold">
										<a
											class="btn btn-light dropdown-toggle text-info font-weight-bold"
											href="#" role="button" id="dropdownMenuLink"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false"> Sıralama Ölçütü </a>

										<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
											<a class="dropdown-item"
												href="${pageContext.request.contextPath}/mvc/home">Alfabetik</a>
											<a class="dropdown-item"
												href="${pageContext.request.contextPath}/mvc/home-sortByDate-subjects">Kronolojik</a>
											<a
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

				<!--Link Listesi -->
				<c:forEach items="${subjects}"  var="subject">
					<div style="cursor: pointer"
						onclick="window.location.href='${pageContext.request.contextPath}/api/home/#'"
						class="card">
						<div class="card-body">
							<div class="d-flex justify-content-around">
								<div class="col-2">
									<h5 class="card-title">${subject.header}</h5>
								</div>
								<div class="col-8">
									<p class="card-text">${subject.note}</p>
								</div>
								<div class="col-2">
									<div class="btn-group">
										<button class="btn  btn-primary">Düzenle</button>
										<button class="btn  btn-danger">Sil</button>
									</div>
								</div>
							</div>
							<br>
							<div class="d-flex justify-content-around">
								<div class="col-2">
									<h6 class="card-subtitle mb-2 text-muted">
										<a href="#">${subject.subjectTable.header}</a>
									</h6>
								</div>
								<div class="col-8">
									<a style="font-size: 15px; text-decoration: underline"
										href="${subject.link}" class="card-link">${subject.link}/</a>
								</div>
								<div class="col-2">
									<p class="lead text-right" style="font-size: 15px;">
										${subject.date}</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>

</body>
</html>