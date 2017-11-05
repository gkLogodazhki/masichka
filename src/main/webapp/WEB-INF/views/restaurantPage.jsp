<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw=="
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="static/assets/restaurantPage/style.css?351">
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
                <li><a id = "goToIndex" href="<c:url value='/login' />">Начало </a></li>
			</ul>
		</div>
	</nav>


	<div id="wrapper">
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

		<div id="detailInfo">
			<div id="logoAndTitleRow">
				<img id="smallLogo" src="static/img/restaurantPage/logo.jpg"
					alt="logo">
				<div id="restNameDiv">
					<p id="restaurantName">Име на ресторанта</p>
					<b>адрес</b>
				</div>

			</div>
			<div id="addToFavouriteDiv">
				<input id="addToFavourite" type="button" value="добави в любими"
					name="addToFavourite">
			</div>

			<div id="moreInfo">
				<span class="glyphicon glyphicon-cutlery"></span> <b>Кухня: </b> <span>видове
					кухня</span>
			</div>
			<div class="moreInfo-space">
				<span class="glyphicon glyphicon-home"></span> <b>Район: </b> <span>да
					речем Перник</span>
			</div>
			<div class="moreInfo-space">
				<span class="glyphicon glyphicon-euro"></span> <b>Средна сметка:
				</b> <span>от 50 до 100лв</span>
			</div>
			<div>
				<span style="font-size: 90%;">(цената е само ориентировъчна)</span>
			</div>
			<div id="welcomeMessage">
				<h3>Заповядайте при нас</h3>
			</div>
		</div>

		<div id="">
			<div style="width: 70%; height: 10px; float: left;"></div>
			<div id="map"></div>
		</div>
		<div style="width: 70%; height: 10px; float: left;"></div>

		<div id="bottomOptions">



			<div id="bottomForRestaurant">
				<h2 class="bottomTitle">За ресторанта</h2>
				<p>Djanam Steak House Restaurant е единственият по рода си Steak
					House ресторант в София. Уютната и елегантна обстановка, в
					съчетание с ненатрапчив лукс, без излишна претрупаност, са
					предпоставка за комфортно и приятно преживяване по време на обяд
					или вечеря. Ресторантът не отстъпва по нищо на най-добрите стек
					ресторанти в световен мащаб – разполага с DRY AGED витрина, в която
					месото зрее 28 дни, преди да бъде приготвено от майстор готвачи
					Част от комплекс DJANAM е новооткритият Steak & Nargile Lounge.
					Почерпихме вдъхновение от ориенталската екзотиката, съчетахме го с
					модерна обстановка, удобни меки дивани, комфортни сепарета,
					автентични дървени маси и получихме истински градски оазис.
					Цялостната концепция за Djanam Steak & Nargile е изградена около
					идеята да съберем на едно място уникалната кухня на комплекса,
					включваща приготвените по неповторим начин меса, салати и десерти
					от нашите майстори и страхотните ориенталски наргилета, приготвени
					по начин , който ще гарантира пълното удоволствие от пушенето на
					ароматните димове и ще бъде уникален за Българският пазар.</p>
			</div>
			<div id="bottomAdditionalInfo">
				<h2 class="bottomTitle">Удобства</h2>
				<div class="bottomInnerInfos">
					<span class="	glyphicon glyphicon-plus"></span> <b>Допълнителни
						опции: </b> <span>Домашни любимци, Бебешко столче, Телевизор и
						Лятна градина/тераса</span>
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
						време: </b> <span>10:00 - 23:00</span>
				</div>
			</div>
		</div>

		
			<div id="commentsSection">
				<h2 style="display: inline-block;">Коментари</h2>
				<input type="button" name="addComent" value="Добави коментар" 
					id="addCommentButton">
				<div id="commentsStraightLine"></div>
			</div>
	</div>

	<div id="commentDiv">
		<form>
			<input type="button" id="closeCommentWindow" value = "Затвори"
				class="btn-danger glyphicon glyphicon-remove-circle">
			<span id = "commentBlankText">Дайте своят коментар</span>
			
		</form>
	</div>
	
	
	<div style = "float:left; width:100%; height:100px"></div>

	
	<script src = "static/js/restaurantPage/mapsAPI.js?2f"></script>
	<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCp8-kC6BmMpDbH03rGS-PTAYxHiXdlTZM&callback=initMap">
    </script>
	<script src = "static/js/restaurantPage/functionality.js?12"></script>
	

</body>
</html>