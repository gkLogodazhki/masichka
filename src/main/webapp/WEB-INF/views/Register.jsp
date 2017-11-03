<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Masichka.bg</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">--%>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <!-- Custom fonts for this template -->
    <link href="/static/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
          type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/static/assets/startPage/style.css?123">


    <link href="/static/assets/css/agency.min.css" rel="stylesheet">

</head>
<%@ include file="authheader.jsp" %>
<body id="page-top">
<style>.text-muted {
    color: #fff !important;
}</style>
<!-- Header -->
<header class="masthead">

    <%--
        <div class="container">
            <link rel="stylesheet" href="/static/assets/startPage/style.css?123">
            &lt;%&ndash;<div class="video-background">
                <div class="video-foreground">
                    <iframe src="https://www.youtube.com/embed/8S8bHhXjqVw?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=8S8bHhXjqVw"
                            frameborder="0" allowfullscreen></iframe>
                </div>
            </div>
    &ndash;%&gt;
        </div>--%>
</header>



<section class="bg-light" id="favoriteRestorant">
    <div class="container">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Регистрация</h2>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 portfolio-item">
                <form id="editProfile" name="sentMessage" novalidate>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class="badge">Нова парола*</span>
                                <input name="last_name"
                                       placeholder="Фамилия" class="form-control" type="text"
                                       onkeyUp="checkForIllegalName('lastName')"/>
                            </div>
                            <div class="form-group">
                                <span class="badge">Повтори нова парола*</span>
                                <span class="input-group-addon"><i
                                        class="glyphicon glyphicon-list"></i></span>
                                <select
                                        name="city" class="form-control selectpicker">
                                    <option value=1>София</option>
                                    <option value=2>Пловдив</option>
                                    <option value=3>Варна</option>
                                    <option value=4>Бургас</option>
                                    <option value=5>Русе</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <span class="badge">Текуща парола*</span>
                                <span class="input-group-addon"><i
                                        class="glyphicon glyphicon-user"></i></span>
                                <input
                                        name="user_password" placeholder="Парола" class="form-control"
                                        type="password"/>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                ПРОМЯНА НА ПАРОЛА
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <form id="contactForm" name="sentMessage" novalidate>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class="badge">Нов Email*</span>
                                <input class="form-control" id="name" type="text" required
                                       data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Повтори E-mail*</span>
                                <input class="form-control" id="email" type="email" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Парола*</span>
                                <input class="form-control" id="phone" type="tel" required
                                       data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                ПРОМЯНА НА E-MAIL
                            </button>
                        </div>
                    </div>
                </form>
                <div class="portfolio-caption">

                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <form id="contactForm" name="sentMessage" novalidate>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class="badge">Име</span>
                                <input class="form-control" id="name" type="text" required
                                       data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Фамилия</span>
                                <input class="form-control" id="email" type="email" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <div class="form-group">
                                    <span class="badge">Град</span>
                                    <select class="form-control" id="sel1">
                                        <option>София</option>
                                        <option>Хасково</option>
                                        <option>Перник</option>
                                        <option>Малу Бучино</option>
                                    </select>
                                </div>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Мобилен номер</span>
                                <input class="form-control" id="email" type="email" placeholder="(+359) 8xx-xxx-xxx"
                                       required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                                <script>
                                    $(function () {
                                        $("#datepicker").datepicker();
                                    });
                                </script>
                                <input type="text" id="datepicker">
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                ПРОМЯНА ЛИЧНИ ДАННИ
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>





<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <span class="copyright">Copyright &copy; Your Website 2017</span>
            </div>
            <div class="col-md-4">
                <ul class="list-inline social-buttons">
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fa fa-twitter"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fa fa-facebook"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">
                            <i class="fa fa-linkedin"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="col-md-4">
                <ul class="list-inline quicklinks">
                    <li class="list-inline-item">
                        <a href="#">Privacy Policy</a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#">Terms of Use</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- Portfolio Modals -->


<!-- Bootstrap core JavaScript -->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact form JavaScript -->
<script src="/static/js/jqBootstrapValidation.js"></script>
<script src=/static/js/contact_me.js"></script>

<!-- Custom scripts for this template -->
<script src="/static/js/agency.min.js"></script>

</body>

</html>
