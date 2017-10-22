<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>Админски панел</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../assets/admin_panel/admin_panel.css">
	<link rel="script" href="../../js/admin_panel/AdminPanel.js">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha256-3dkvEK0WLHRJ7/Csr0BZjAWxERc5WH7bdeUya2aXxdU= sha512-+L4yy6FRcDGbXJ9mPG8MT/3UCDzwR9gPeyFNMCtInsol++5m3bk2bXWKdZjvybmohrAsn3Ua5x8gfLnbE1YkOg==" crossorigin="anonymous">
	<!-- Bootstrap Core CSS -->
	<!--     <link href="css/bootstrap.min.css" rel="stylesheet"> -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">

</head>
<body>

<div class="container">

	<h2>Добави обект</h2>
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">Основна информация</a></li>
		<li><a data-toggle="tab" href="#gallery">Галерия</a></li>
		<li><a data-toggle="tab" href="#map">Карта</a></li>
		<li><a data-toggle="tab" href="#comments">Коментари</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
				<div class="row">
					<div class="col-md-10 ">
						<form class="form-horizontal">
							<fieldset>

								<div class="form-group">
									<label class="col-md-4 control-label" for="Name">Име</label>
									<div class="col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-user">
												</i>
											</div>
											<input id="Name" name="Name" type="text" placeholder="Име" class="form-control input-md">
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="Region">Квартал</label>
									<div class="col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-clock-o"></i>
											</div>
											<input id="Region" name="Region" type="text" placeholder="адрес" class="form-control input-md">
										</div>
									</div>
								</div>

								<!-- File Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Upload photo">Добави снимка</label>
									<div class="col-md-4">
										<input id="Upload photo" name="Upload photo" class="input-file" type="file">
									</div>
								</div>


								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Availability time">работно време</label>
									<div class="col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-clock-o"></i>
											</div>
											<input id="Availability time" name="Availability time" type="text" placeholder="работно време" class="form-control input-md">
										</div>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Citizenship No.">Citizenship No.</label>
									<div class="col-md-4">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-sticky-note-o"></i>

											</div>

											<input id="Citizenship No." name="Citizenship No." type="text" placeholder="Citizenship No." class="form-control input-md">

										</div>

									</div>
								</div>

								<!-- Multiple Checkboxes -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Place type">Тип на обекта</label>
									<div class="col-md-4">
										<div class="checkbox">
											<label for="Place type-0">
												<input type="checkbox" name="Place type" id="Place type-0" value="1">
												клуб
											</label>
										</div>
										<div class="checkbox">
											<label for="Place type-1">
												<input type="checkbox" name="Place type" id="Place type-1" value="2">
												ресторант
											</label>
										</div>
									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label">допълнителни екстри</label>
									<div class="col-md-4">
										<br/>
										<script type="javascript">
                                            var options = [];

                                            $( '.dropdown-menu a' ).on( 'click', function( event ) {

                                                var $target = $( event.currentTarget ),
                                                    val = $target.attr( 'data-value' ),
                                                    $inp = $target.find( 'input' ),
                                                    idx;

                                                if ( ( idx = options.indexOf( val ) ) > -1 ) {
                                                    options.splice( idx, 1 );
                                                    setTimeout( function() { $inp.prop( 'checked', false ) }, 0);
                                                } else {
                                                    options.push( val );
                                                    setTimeout( function() { $inp.prop( 'checked', true ) }, 0);
                                                }

                                                $( event.target ).blur();

                                                console.log( options );
                                                return false;
                                            });
										</script>
										<div class="button-group">
											<button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span> <span class="caret"></span> </button>
											<ul class="dropdown-menu">
												<li><a href="#" class="small" data-value="option1" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 1</a></li>
												<li><a href="#" class="small" data-value="option2" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 2</a></li>
												<li><a href="#" class="small" data-value="option3" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 3</a></li>
												<li><a href="#" class="small" data-value="option4" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 4</a></li>
												<li><a href="#" class="small" data-value="option5" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 5</a></li>
												<li><a href="#" class="small" data-value="option6" tabIndex="-1"><input type="checkbox"/>&nbsp;Option 6</a></li>
											</ul>
										</div>
									</div>
								</div>

								<!-- Textarea -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="Overview (max 200 words)">Overview (max 200 words)</label>
									<div class="col-md-4">
										<textarea class="form-control" rows="10"  id="Overview (max 200 words)" name="Overview (max 200 words)">Overview</textarea>
									</div>
								</div>


								<div class="form-group">
									<label class="col-md-4 control-label" ></label>
									<div class="col-md-4">
										<a href="#" class="btn btn-success"><span class="glyphicon glyphicon-thumbs-up"></span> Submit</a>
										<a href="" class="btn btn-danger" value=""><span class="glyphicon glyphicon-remove-sign"></span> Clear</a>

									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-2 hidden-xs">
						<img src="http://websamplenow.com/30/userprofile/images/avatar.jpg" class="img-responsive img-thumbnail ">
					</div>


				</div>

			<!-- jQuery Version 1.11.1 -->
			<script src="js/jquery.js"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="js/bootstrap.min.js"></script>
		</div>
		<div id="menu1" class="tab-pane fade">

			<script type="text/javascript">
                $(":file").filestyle({btnClass: "btn-primary"});
			</script>

			<input type="file" class="filestyle" data-btnClass="btn-primary">

			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner">
					<div class="item active">
						<img src="la.jpg" alt="Los Angeles">
					</div>

					<div class="item">
						<img src="chicago.jpg" alt="Chicago">
					</div>

					<div class="item">
						<img src="ny.jpg" alt="New York">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div id="menu2" class="tab-pane fade">
			<h3>Menu 2</h3>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
		</div>
		<div id="menu3" class="tab-pane fade">
			<h3>Menu 3</h3>
			<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
		</div>
	</div>
</div>

</body>
</html>