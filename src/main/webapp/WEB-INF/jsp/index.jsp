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
<title>MyList</title>
</head>
<body style="background-color: #F0F9FB;">
	<div class="container-fluid  col-md-12 mb-3" style="height: 100px;">
		<h1 class="text-white text-left pt-4 pl-5 text-info"
			style="font-size: 35px; font-weight: bold; text-shadow: 3px 3px 3px lightblue;">LinkHeaven</h1>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-3">

					<!-- Link deposu oluşturma,arama,sıralama bölümü -->
					<div class="card mb-2">
						<div class="card-header">
							<div class="row d-flex justify-content-around">
								<h5 class="text-left  font-weight-bold">Link Depoları</h5>
								<button class="btn btn-sm  btn-success font-weight-bold">Depo
									Oluştur</button>
							</div>
							<hr>
							<form>
								<div class="form-row">
									<div>
										<input type="search" class="form-control form-control-sm"
											placeholder="Link Deposu ara...">
									</div>
									<div>
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
						</a> <a href="#" class="list-group-item list-group-item-action">
							<div class="d-flex justify-content-between">
								<h6 class="text-left">Depo Adı</h6>
								<p class="text-right lead" style="font-size: 13px;">2 gün
									önce</p>
							</div>
						</a>
					</div>

				</div>
				
				<div class="col-md-9">
				</div>
			</div>
		</div>




	</div>

</body>
</html>