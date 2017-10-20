<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../assets/resetCss/Reset.css">
<link rel="stylesheet" type="text/css" href="../assets/register/Header.css?232">
<link rel="stylesheet" type="text/css" href="../assets/register/Wrapper.css?655">
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
<script src="https://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js?2455"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js?42" /></script>
<script src="../js/register/Wrapper.js?223"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="dist_files/jquery.form.js"></script>
<script src="functions.js"></script>
<script src="../js/register/ImgFrame.js"></script>
<title>Регистрация</title>
</head>
<body>

	<div id="main-container">
		<header id="header-section">
		 <a href="#" id="logo" class="headerFontColor">LOGO</a>
		<h1 id="headerTitle" class="headerFontColor">Masichka.bg</h1>
		<a href="#" id="home" class="headerFontColor">Home</a> </header>

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
				<div id="main-options">
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
									class="glyphicon glyphicon-list"></i></span> <select name="department"
									class="form-control selectpicker">
									<option value="">Твоето местоположение</option>
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
				</div>
				
				
				
				
				
					<div>
						<img class="img-circle" id="profile_picture" height="128"
							data-src="default.jpg" data-holder-rendered="true"
							style="width: 140px; height: 140px;" src="default.jpg" /> <br>
						<br> <a type="button" class="btn btn-primary"
							id="change-profile-pic">Change Profile Picture</a>
					</div>


					<div id="profile_pic_modal" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h3>Change Profile Picture</h3>
								</div>
								<div class="modal-body">
									<form id="cropimage" method="post"
										enctype="multipart/form-data" action="change_pic.php">
										<strong>Upload Image:</strong> <br>
										<br> <input type="file" name="profile-pic"
											id="profile-pic" /> <input type="hidden"
											name="hdn-profile-id" id="hdn-profile-id" value="1" /> <input
											type="hidden" name="hdn-x1-axis" id="hdn-x1-axis" value="" />
										<input type="hidden" name="hdn-y1-axis" id="hdn-y1-axis"
											value="" /> <input type="hidden" name="hdn-x2-axis" value=""
											id="hdn-x2-axis" /> <input type="hidden" name="hdn-y2-axis"
											value="" id="hdn-y2-axis" /> <input type="hidden"
											name="hdn-thumb-width" id="hdn-thumb-width" value="" /> <input
											type="hidden" name="hdn-thumb-height" id="hdn-thumb-height"
											value="" /> <input type="hidden" name="action" value=""
											id="action" /> <input type="hidden" name="image_name"
											value="" id="image_name" />
										<div id='preview-profile-pic'></div>
										<div id="thumbs" style="padding: 5px; width: 600p"></div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button type="button" id="save_crop" class="btn btn-primary">Crop
										& Save</button>
								</div>
							</div>
						</div>
					</div>



					<!-- Select Basic -->

					<!-- Success message -->
					<div class="alert alert-success" role="alert" id="success_message">
						Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<br>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							<button type="submit" class="btn btn-warning">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT
								<span
									class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</button>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
	</div>
<<<<<<< HEAD
	<!-- /.container -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

=======
	<a></a>
>>>>>>> a3d5df5e6fdc443ed1e60f7e2e227bb24bce1f89
</body>
</html>