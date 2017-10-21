<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../assets/reset/reset.css">
<link rel="stylesheet" type="text/css"
	href="../assets/register/style.css?1111">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Регистрация</title>
</head>
<body >

	<div id="main-container">
		<header id="header-section"> 
		<a href="../index.jsp" id="headerTitle" class="headerFontColor">Masichka.bg</a>
		</header>

		<div class="container">

			<form class="well form-horizontal" action=" " method="post"
				id="contact_form">
				<fieldset>

					<!-- Form Name -->
					<legend>
						<center>
							<h2>
								<b>Регистрация</b>
							</h2>
						</center>
					</legend>
					<br>

					<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label">Име</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="first_name"
										placeholder="Име" class="form-control" type="text">
								</div>
							</div>
						</div>

						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Фамилия</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="last_name"
										placeholder="Фамилия" class="form-control" type="text">
								</div>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Град</label>
							<div class="col-md-4 selectContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-list"></i></span> <select
										name="department" class="form-control selectpicker">
										<option>София</option>
										<option>Пловдив</option>
										<option>Варна</option>
										<option>Бургас</option>
										<option>Русе</option>
									</select>
								</div>
							</div>
						</div>


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Парола</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="user_password" placeholder="Парола" class="form-control"
										type="password">
								</div>
							</div>
						</div>

						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Потвърди парола</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										name="confirm_password" placeholder="Потвърди парола"
										class="form-control" type="password">
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label">E-Mail</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-envelope"></i></span> <input name="email"
										placeholder="E-Mail" class="form-control" type="text">
								</div>
							</div>
						</div>


						<!-- Text input-->

						<div class="form-group">
							<label class="col-md-4 control-label">Номер</label>
							<div class="col-md-4 inputGroupContainer">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-earphone"></i></span> <input
										name="contact_no" placeholder="(+359)" class="form-control"
										type="text">
								</div>
							</div>
						</div>
					


					<!-- upload photo -->
					<div class="row image-main-div">
					<label class="avatar-text">Моля изберете снимка за вашият аватар</label>
						<div class="col-xs-12 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<!-- image-preview-filename input [CUT FROM HERE]-->
							<div class="input-group image-preview">
								<input style= "background-color:white;"type="text" class="form-control image-preview-filename"
									disabled="disabled">
								<!-- don't give a name === doesn't send on POST/GET -->
								<span class="input-group-btn"> <!-- image-preview-clear button -->
									<button type="button"
										class="btn btn-default image-preview-clear"
										style="display: none;">
										<span class="glyphicon glyphicon-remove"></span> 
										Изчисти </button> <!-- image-preview-input -->
									<div class="btn btn-default image-preview-input">
										<span class="glyphicon glyphicon-folder-open"></span> 
										<span class="image-preview-input-title">Търси</span> 
										<input type="file" accept="image/png, image/jpeg, image/gif" name="input-file-preview" />
										<!-- rename it -->
									</div>
								</span>
							</div>
							<!-- /input-group image-preview [TO HERE]-->
						</div>
					</div>


					<div id="space-maker"></div>

					<!-- Birthday -->
					<div id="birthday-block">
							<b style="font-size:110%;">Рожден ден</b>
							 <div id = "year" class="birthday-field">
							 	<b>Година</b>
							 </div>
							 <div id = "month" class="birthday-field">
							 	<b>Месец</b>
							 </div>
							 <div id = "day" class="birthday-field">
							 	<b>Ден</b>
							 </div>
						</div>
					

					<!-- Success message -->
					<div class="alert alert-success" role="alert" id="success_message">
						Успешна регистрация<i class="glyphicon glyphicon-thumbs-up"></i>
						Успешна регистрация!
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<button type="submit" class="btn btn-warning">
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span
									class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>


	<!-- /.scripts -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js?2455"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js?42" /></script>
	<script src="../js/register/Wrapper.js?223"></script>
	<script src="../js/register/Avatar.js?99"></script>
	<script
		src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js"></script> -->
</body>
</html>