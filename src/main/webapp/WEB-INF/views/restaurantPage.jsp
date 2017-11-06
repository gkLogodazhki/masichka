<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha256-KXn5puMvxCw+dAYznun+drMdG1IFl3agK0p/pqT9KAo= sha512-2e8qq0ETcfWRI4HJBzQiA3UoyFk6tbNyG+qSaIBZLyW9Xf3sWZHN/lxe9fTh1U45DpPf07yj94KsUHHWe4Yk1A=="
	crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw=="
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="static/assets/restaurantPage/style.css?14">
<link href="static/assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Masichka.bg</a>
		<ul class="nav navbar-nav navbar-right">
			<li><a id="goToIndex" href="<c:url value = "/"/>">Начало </a></li>
		</ul>
	</div>
	</nav>


	<div id="wrapper">


		<div id="detailInfo">
			<div id="logoAndTitleRow">
				<img id="smallLogo" src="static/img/restaurantPage/logo.jpg"
					alt="logo">
				<div id="restNameDiv">
					<p id="restaurantName">${place.name}</p>
					<b>адрес</b>
				</div>

			</div>
			<div id="addToFavouriteDiv">
				<input id="addToFavourite" type="button" value="добави в любими"
					name="addToFavourite">
			</div>

			<div id="moreInfo">
				<span class="glyphicon glyphicon-cutlery"></span> <b>Кухня: </b> 
				<c:forEach items="${place.options}" var="option">
				${option.name} ,
				</c:forEach>
			</div>
			<div class="moreInfo-space">
				<span class="glyphicon glyphicon-home"></span> <b>Район: </b> <span>${place.region.name}</span>
			</div>
			<div class="moreInfo-space">
				<span class="glyphicon glyphicon-euro"></span> <b>Средна сметка:
				</b> <span>${place.avgBill.name}</span>
			</div>
			<div>
				<span style="font-size: 90%;">(цената е само ориентировъчна)</span>
			</div>
			<div id="welcomeMessage">
				<h3>Заповядайте при нас</h3>
			</div>
		</div>



		<div id="photoSection">
			<div id='carousel-custom' class='carousel slide' data-ride='carousel'>
				<div class='carousel-outer'>
					<!-- Wrapper for slides -->
					<div class='carousel-inner'>
						<div class='item active imgSize'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item '>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>

						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>

						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
						<div class='item'>
							<img src='static/img/restaurantPage/resPhoto.jpg' alt='' />
						</div>
					</div>


				</div>
				<!-- Controls -->
				<a class='left carousel-control' href='#carousel-custom'
					data-slide='prev'> <span
					class='glyphicon glyphicon-chevron-left'></span>
				</a> <a class='right carousel-control' href='#carousel-custom'
					data-slide='next'> <span
					class='glyphicon glyphicon-chevron-right'></span>
				</a>
				<!-- Indicators -->
				<ol class='carousel-indicators'>
					<li data-target='#carousel-custom' data-slide-to='0' class='active'><img
						src='http://placehold.it/100x50&text=slide1' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='1'><img
						src='http://placehold.it/100x50&text=slide2' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='2'><img
						src='http://placehold.it/100x50&text=slide3' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='3'><img
						src='http://placehold.it/100x50&text=slide4' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='4'><img
						src='http://placehold.it/100x50&text=slide5' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='5'><img
						src='http://placehold.it/100x50&text=slide6' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='6'><img
						src='http://placehold.it/100x50&text=slide7' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='7'><img
						src='http://placehold.it/100x50&text=slide8' alt='' /></li>
					<li data-target='#carousel-custom' data-slide-to='8'><img
						src='http://placehold.it/100x50&text=slide9' alt='' /></li>
				</ol>
			</div>
		</div>



			<div id="makeRegForRest">
				<form:form method = "post" name="sentMessage" modelAttribute="reservation">
					<div id = "reservationInfoDiv">
						<p style = "font-size:130%;">Искате да направите резервация при нас?</p>
						<p>направете го още сега попълвайки кратката форма</p>
					</div>
					
					<div style = "width:100%; padding-top:8%;"></div>
						
					<div class = "reservationDivWrapper">
						<div class = "reservationDivText">
							<p>Дата на резервацията:</p>
						</div>
						<div class = "reservationDivInput">
							<form:input type="text" id="datepicker" class = "reservationInputSize" path = "date" name = "date"/>
							<div class="has-error error">
			                        <form:errors path="date" class="help-inline"/>
			                    </div>	
						</div>
					</div>
					
					<div class = "spaceMaker"></div>
					
					<div class = "reservationDivWrapper">
						<div class = "reservationDivText">
							<p>Час на резервазията:</p>
						</div>
						<div class = "reservationDivInput">
							<form:select name = "hour" path="hour" items="${hours}" multiple="false" itemValue="id" itemLabel="name" 
                                 class="selectPicker reservationInputSize" data-width="auto"/>
						</div>
					</div>
					
					<div class = "spaceMaker"></div>
					
					<div class = "reservationDivWrapper">
						<div class = "reservationDivText">
							<p>Брой хора: </p>
						</div>
						<div class = "reservationDivInput">
							 <form:input type = "number" class = "reservationInputSize" path = "spots" name = "spots" />
							<div class="has-error error">
			                        <form:errors path="spots" class="help-inline"/>
			                    </div>	
						</div>
					</div>
					
					<div class = "spaceMaker"></div>
					
					<div class = "reservationDivWrapper">
						<div class = "reservationDivText">
							<p>Отстъпка при резервация: </p>
						</div>
						<div class = "reservationDivText">
							 <p>$(place.discount)</p>
						</div>
					</div>
					
					<div id = "reservationSubmitDiv">
						<input type = "submit" name = "submit" value = "РЕЗЕРВИРАЙ" id = "reservationId"/>
					</div>
					
				</form:form>
			</div>


			<div id="">
				<div style="width: 70%; height: 10px; float: left;"></div>
				<div id="map"></div>
			</div>
			<div style="width: 70%; height: 10px; float: left;"></div>

			<div id="bottomOptions">



				<div id="bottomForRestaurant">
					<h2 class="bottomTitle">За ресторанта</h2>
					<p>$(place.infoPlace)</p>
				</div>
				<div id="bottomAdditionalInfo">
					<h2 class="bottomTitle">Удобства</h2>
					<div class="bottomInnerInfos">
						<span class="	glyphicon glyphicon-plus"></span> <b>Допълнителни
							опции: </b> 
							<c:forEach items="$(place.setups)" var="setup"><span> ${setup} ,</span> </c:forEach>
						
					</div>

					<div class="bottomInnerInfos">
						<span class="	glyphicon glyphicon-usd"></span> <b>Начини за
							плащане: </b> <span>American Express, Borica, Maestro,
							MasterCard, V Pay, VISA Eletron, VISA и в брой</span>
					</div>

					<div class="bottomInnerInfos">
						<span class="	glyphicon glyphicon-list-alt"></span> <b>Разполага
							с: </b> <span>Wi-Fi, Лятна градина, Паркинг</span>
					</div>

					<div class="bottomInnerInfos">
						<span class="	glyphicon glyphicon-play-circle"></span> <b>Работно
							време: </b> <span>09:00 - 23:00</span>
					</div>
				</div>
			</div>


			<div id="commentsSection">
				<h2 style="display: inline-block;">Коментари</h2>
				<sec:authorize access="hasRole('USER')">
					<input type="button" name="addComent" value="Добави коментар"
						id="addCommentButton">
				</sec:authorize>
				<div id="commentsStraightLine"></div>
			</div>
		</div>

		<div id="commentDiv">
			<form>
				<input type="button" id="closeCommentWindow" value="Затвори"
					class="btn-danger glyphicon glyphicon-remove-circle"> <span
					id="commentBlankText">Поставете коментарат си тук</span>
				<textarea style="width: 60%;" rows=5 cols=20></textarea>
				<div style="width: 100%; padding-top: 9%;">
					<input type="submit" value="Добави коментар" name="addComment"
						class="btn-success">
				</div>

			</form>
		</div>
	</div>

	<div style="float: left; width: 100%; height: 100px"></div>


	<script src="static/js/restaurantPage/mapsAPI.js?2f"></script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCp8-kC6BmMpDbH03rGS-PTAYxHiXdlTZM&callback=initMap">
    </script>
	<script src="static/js/restaurantPage/functionality.js?12"></script>

	<script>
        $(function () {
            $("#datepicker").datepicker();
        });
	</script>
</body>
</html>