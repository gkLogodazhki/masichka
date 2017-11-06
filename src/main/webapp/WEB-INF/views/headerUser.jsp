<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="authbar">
	<%--<span>Dear <strong>${loggedinuser}</strong>, Welcome to CrazyUsers.</span> <span class="floatRight"></span>--%>
	<!-- Navigation -->


    <div class="container">
        <link rel="stylesheet" href="/static/assets/startPage/style.css?123">
		<div class="video-background">
			<div class="video-foreground">
				<iframe src="https://www.youtube.com/embed/--AgEMm0ZAw?controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=2mXKf9azmgY"
						frameborder="0" allowfullscreen></iframe>
			</div>
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
					<li><a href="<c:url value="/reg"/>">Регистрация</a></li>
					<li class="dropdown">
						<a href="http://www.jquery2dotnet.com" class="dropdown-toggle" data-toggle="dropdown">&nbsp;|
							Вход <b
									class="caret"></b></a>
						<ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
							<li>
								<div class="row">
									<div class="col-md-12">
										<div class="login-form">
											<c:url var="loginUrl" value="/login"/>
											<form action="${loginUrl}" method="post" class="form-horizontal">
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
												<div class="input-group input-sm">
													<label class="input-group-addon" for="username"><i
															class="fa fa-user"></i></label>
													<input type="text" class="form-control" id="username" name="ssoId"
														   placeholder="Enter Username" required>
												</div>
												<div class="input-group input-sm">
													<label class="input-group-addon" for="password"><i
															class="fa fa-lock"></i></label>
													<input type="password" class="form-control" id="password"
														   name="password" placeholder="Enter Password" required>
												</div>
												<div class="input-group input-sm">
													<div class="checkbox">
														<label><input type="checkbox" id="rememberme"
																	  name="remember-me"> Remember Me</label>
													</div>
												</div>
												<input type="hidden" name="${_csrf.parameterName}"
													   value="${_csrf.token}"/>

												<div class="form-actions">
													<input type="submit"
														   class="btn btn-block btn-primary btn-default" value="Log in">
												</div>
											</form>
										</div>
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

                                                document.getElementById("status").innerHTML = '<p>Welcome ' + response.name + '! <a href=fblogincontroller.jsp?user_name=' + response.name.replace(" ", "_") + '&user_email=' + response.email + '>Continue with facebook login</a></p>'
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
							<a class="nav-link js-scroll-trigger" href="<c:url value="/profile" />"><i
									class="fa fa-wrench" aria-hidden="true"></i>&nbsp;Промяна профил</a>
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
