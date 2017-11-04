<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Masichka.bg регистрация</title>

    <!-- Bootstrap core CSS -->
    <link href="static/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <%--<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">--%>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


    <!-- Custom fonts for this template -->
    <link href="static/assets/register/style.css?23" rel="stylesheet" type="text/css">
    <link href="static/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet'
          type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="static/assets/startPage/style.css?24">


    <link href="static/assets/css/agency.min.css" rel="stylesheet">


</head>
<div class="authbar">
    <%--<span>Dear <strong>${loggedinuser}</strong>, Welcome to CrazyUsers.</span> <span class="floatRight"></span>--%>
    <!-- Navigation -->


    <div class="container">
        <%--<div class="video-background">
            <div class="video-foreground">
                <iframe src="https://www.youtube.com/embed/8S8bHhXjqVw?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=8S8bHhXjqVw"
                        frameborder="0" allowfullscreen></iframe>
            </div>--%>
    </div>


</div>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">

        <a class="navbar-brand js-scroll-trigger" href="#page-top">Masichka.bg</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">Menu<i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            </li>
        </div>
        <sec:authorize access="!hasRole('USER') AND !hasRole('ADMIN')">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value='/' />">Начало </a></li>
                <li class="dropdown">

                    <ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
                        <li>
                            <div class="row">
                                <div class="col-md-12">
                                    <c:url var="loginUrl" value="/login"/>
                                    <form class="form" role="form" method="post" action="${loginUrl}"
                                          accept-charset="UTF-16" id="login-nav">
                                        <c:if test="${param.error != null}">
                                            <div class="alert alert-danger">
                                                <p>Invalid username and password.</p>
                                            </div>
                                        </c:if>
                                        <c:if test="${param.logout != null}">
                                            <div class="alert alert-success">
                                                <p>You have been logged out successfully.</p>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label class="sr-only" for="username"><i class="fa fa-user"></i></label>
                                                <%--<label class="sr-only" for="username">Вашият никнейм</label>--%>
                                            <input type="text" class="form-control" id="username" name="ssoId"
                                                   placeholder="Enter Username" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="password">Password</label>
                                            <input type="password" class="form-control" id="password" name="password"
                                                   placeholder="Enter Password" required>
                                        </div>
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Remember me</label>
                                        </div>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <div class="form-group">
                                            <button type="submit" class="btn btn-success btn-block">Sign in</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>

                            <center>
                                <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
                                <script>
                                    // This is called with the results from from FB.getLoginStatus().
                                    function statusChangeCallback(response) {
                                        console.log('statusChangeCallback');
                                        console.log(response);
                                        // The response object is returned with a status field that lets the
                                        // app know the current login status of the person.
                                        // Full docs on the response object can be found in the documentation
                                        // for FB.getLoginStatus().
                                        if (response.status === 'connected') {
                                            // Logged into your app and Facebook.
                                            testAPI();
                                        } else if (response.status === 'not_authorized') {
                                            // The person is logged into Facebook, but not your app.
                                            document.getElementById('status').innerHTML = 'Login with Facebook ';
                                        } else {
                                            // The person is not logged into Facebook, so we're not sure if
                                            // they are logged into this app or not.
                                            document.getElementById('status').innerHTML = 'Login with Facebook ';
                                        }
                                    }

                                    // This function is called when someone finishes with the Login
                                    // Button. See the onlogin handler attached to it in the sample
                                    // code below.
                                    function checkLoginState() {
                                        FB.getLoginStatus(function (response) {
                                            statusChangeCallback(response);
                                        });
                                    }

                                    window.fbAsyncInit = function () {
                                        FB.init({
                                            appId: '388104551618860',
                                            cookie: true, // enable cookies to allow the server to access
                                            // the session
                                            xfbml: true, // parse social plugins on this page
                                            version: 'v2.2' // use version 2.2
                                        });
                                        // Now that we've initialized the JavaScript SDK, we call
                                        // FB.getLoginStatus(). This function gets the state of the
                                        // person visiting this page and can return one of three states to
                                        // the callback you provide. They can be:
                                        //
                                        // 1. Logged into your app ('connected')
                                        // 2. Logged into Facebook, but not your app ('not_authorized')
                                        // 3. Not logged into Facebook and can't tell if they are logged into
                                        // your app or not.
                                        //
                                        // These three cases are handled in the callback function.

                                        FB.getLoginStatus(function (response) {
                                            statusChangeCallback(response);
                                        });
                                    };
                                    // Load the SDK asynchronously
                                    (function (d, s, id) {
                                        var js, fjs = d.getElementsByTagName(s)[0];
                                        if (d.getElementById(id)) return;
                                        js = d.createElement(s);
                                        js.id = id;
                                        js.src = "//connect.facebook.net/en_US/sdk.js";
                                        fjs.parentNode.insertBefore(js, fjs);
                                    }(document, 'script', 'facebook-jssdk'));

                                    // Here we run a very simple test of the Graph API after login is
                                    // successful. See statusChangeCallback() for when this call is made.
                                    function testAPI() {
                                        console.log('Welcome! Fetching your information.... ');
                                        FB.api('/me?fields=name,email', function (response) {
                                            console.log('Successful login for: ' + response.name);

                                            document.getElementById("status").innerHTML = '<p>Welcome ' + response.name + '! <a href=index.jsp?user_name=' + response.name.replace(" ", "_") + '&user_email=' + response.email + '>Continue with facebook login</a></p>'
                                        });
                                    }
                                </script>
                                <!--
                                 Below we include the Login Button social plugin. This button uses
                                 the JavaScript SDK to present a graphical Login button that triggers
                                 the FB.login() function when clicked.
                                -->
                                <br><br>
                                <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                </fb:login-button>
                                <div id="status">
                                </div>
                                <script type="text/javascript">
                                </script>
                            </center>
                            <meta name="google-signin-client_id"
                                  content="1085941757281-1jg7a8680fh771alnh5odn5fgftqu6tl.apps.googleusercontent.com">

                            <script>
                                function onSignIn(googleUser) {
                                    // Useful data for your client-side scripts:
                                    var profile = googleUser.getBasicProfile();
                                    console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                                    console.log('Full Name: ' + profile.getName());
                                    console.log('Given Name: ' + profile.getGivenName());
                                    console.log('Family Name: ' + profile.getFamilyName());
                                    console.log("Image URL: " + profile.getImageUrl());
                                    console.log("Email: " + profile.getEmail());

                                    // The ID token you need to pass to your backend:
                                    var id_token = googleUser.getAuthResponse().id_token;
                                    console.log("ID Token: " + id_token);
                                }
                            </script>
                        </li>
                    </ul>
            </ul>
        </sec:authorize>

        <sec:authorize access="hasRole('USER')">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav text-uppercase ml-auto">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#myRezervation"><i class="fa fa-calendar"
                                                                                       aria-hidden="true"></i>&nbsp;Моите
                            Резервации</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#favoriteRestorant"><i
                                class="fa fa-calendar-check-o" aria-hidden="true"></i>&nbsp;Любими ресторанти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#history"><i class="fa fa-book"
                                                                                 aria-hidden="true"></i>&nbsp;Ресторанти
                            дневник</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#comments"><i class="fa fa-commenting-o"
                                                                                  aria-hidden="true"></i>&nbsp;Оставете
                            коментар</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#lastReservation"><i class="fa fa-clock-o"
                                                                                         aria-hidden="true"></i>&nbsp;Минали
                            резервации</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#editProfile"><i class="fa fa-wrench"
                                                                                     aria-hidden="true"></i>&nbsp;Промяна
                            профил</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="<c:url value="/logout" />"><i
                                class="fa fa-power-off" aria-hidden="true"></i>&nbsp;Изход</a>
                    </li>
                </ul>
                </li>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav text-uppercase ml-auto">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#MyReservation"><i class="fa fa-calendar"
                                                                                       aria-hidden="true"></i>&nbsp;Редактирай
                            ресторанти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="<c:url value="/logout" />"><i
                                class="fa fa-power-off" aria-hidden="true"></i>&nbsp;Изход</a>
                    </li>
                </ul>
                </li>
            </div>
        </sec:authorize>

    </div>
</nav>
</div>

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
        <form:form id="editProfile" name="sentMessage" modelAttribute="user" action="makeRegister">
        <form:input type="hidden" path="id" id="id"/>
            <div class="col-md-4 col-sm-6 portfolio-item centerDiv">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                            	<span class = "error">*</span>
                                <span class="badge">Първо име</span>
                                <form:input name="firstName" path="firstName"
                                   placeholder="Име" class="form-control" type="text"
                                   onkeyUp="checkForIllegalName('firstName')" tabindex="1" required="required" />
                            </div>
                            <div class="form-group">
                                <span class = "error">*</span>
                                <span class="badge">E-Mail</span>
                                <i class="glyphicon glyphicon-list"></i></span>
                                <form:input name="email" path = "email"
                                   placeholder="E-Mail" class="form-control" type="text" tabindex="4" required="required"/>
                            </div>
                            <div class="form-group">
                                <span class = "error">*</span>
                                <span class="badge">Номер</span>
                                <form:input name="contact_no" placeholder="(+359)" class="form-control"  path = "phoneNumber" tabindex="7"
                                    type="text" onClick="phoneCode()" onkeyUp="phoneCode(); checkForAlphabetic()" required="required"/> 
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <b>В случай че правите резервация, ще ви бъде изпратено съобщение
                        за потвърждениe на даденият номер</b>
                        </div>
                    </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item centerDiv">
                    <div class="row ">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class = "error">*</span>
                                <span class="badge">Фамилия</span>
                                <form:input name="last_name"
                                   placeholder="Фамилия" class="form-control" type="text" path = "lastName" tabindex="2"
                                   onkeyUp="checkForIllegalName('lastName')" required="required"/>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                 <span class = "error">*</span>
                                <span class="badge">Парола</span>
                                <form:input name="user_password" placeholder="Парола" class="form-control" type="password" path = "password" required="required" tabindex="5"/>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                 <span class = "error">*</span>
                                <span class="badge">Град</span>
                                <i class="glyphicon glyphicon-user"></i></span>
                                 <form:select style = "width:100%;" path="city" items="${cities}" multiple="false" itemValue="id" itemLabel="name" tabindex="8"
                                 class="selectpicker" data-width="auto"/>
                            </div>
                        </div>
                    </div>
                <div class="portfolio-caption">

                </div>
            </div>
            <div class="col-md-4 col-sm-6 portfolio-item centerDiv">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class = "error">*</span>
                                <span class="badge">Потребителско име(служи за вход)</span>
                                <form:input name="ss_od"
                                   placeholder="потребителско име" class="form-control" type="text" path = "ssoId" required="required" tabindex="3"/>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                 <span class = "error">*</span>
                                <span class="badge">Потвърди парола</span>
                                <input name="confirm_password" placeholder="Потвърди парола"
                                    class="form-control" type="password" onkeyUp="checkPassword()" required="required" tabindex="6"/>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <div class="form-group">
                                <span class="badge">Код за сигурност</span>
                                  <input id="code-generator" name="securityCode" class="form-control" disabled />
                                	<button id="refreshButton" type="button" class="glyphicon glyphicon-refresh btn-danger"
                                    onClick="refreshSecurityCode()"></button>
                                </div>
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                            	<span class = "error">*</span>
                                <span class="badge">Потвърдете кода</span>
                                <input name="userSecutityCode" class="form-control"
                                   type="text" onkeyUp="isCorrectSecurityCode()" required="required" tabindex="9">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
            </div>
            <div id="submitButtonDiv">
                           <input type = "submit" value = "Регистрирай" class="btn btn-primary btn-xl text-uppercase" tabindex="10" />
                     </div>
            </form:form>
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
<script src="static/vendor/jquery/jquery.min.js"></script>
<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Contact form JavaScript -->
<script src="static/js/jqBootstrapValidation.js"></script>

<!-- Custom scripts for this template -->
<script src="static/js/agency.min.js"></script>

</body>

</html>
