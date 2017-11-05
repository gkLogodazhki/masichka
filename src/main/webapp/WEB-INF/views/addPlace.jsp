<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Masichka.bg</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
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
            <h2 class="section-heading text-uppercase">Добави ресторант</h2>
        </div>
        <form:form method="POST" modelAttribute="place" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
            <div class="row">
            <div class="col-md-4 col-sm-6 portfolio-item">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="col-md-3 control-lable" for="logo">Logo*</label>
                            <div>
                                <form:input type="text" path="logo" id="logo" class="form-control input-sm"/>
                                <div class="has-error"><form:errors path="logo" class="help-inline"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-lable" for="name">Name*</label>
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="name" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-lable" for="address">Address*</label>
                            <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="address" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-lable" for="placeType">Place Type*</label>
                            <form:select path="placeType" items="${placeTypes}" multiple="false" itemValue="id" itemLabel="name" class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="placeType" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-lable" for="infoPlace">Information*</label>
                            <form:input type="text" path="infoPlace" id="infoPlace" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="infoPlace" class="help-inline"/></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group" >
                            <span class="badge">Брой места*</span>
                            <form:input type="number" min="1" max="100" path="spots" id="spots" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="spots" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Map length*</span>
                            <form:input type="number" min="-90" max="90" path="mapLng" id="mapLng" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="mapLng" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Map Latitute</span>
                            <form:input type="number" min="-180" max="180" path="mapLat" id="mapLat" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="mapLat" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Path to gallary</span>
                            <form:input type="text" pattern="[A-Za-z0-9/]+" path="pathToGallery" id="pathToGallery" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="pathToGallery" class="help-inline"/></div>
                        </div>

                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div class="col-md-4 col-sm-6 portfolio-item">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <span class="badge">Extra*</span>
                            <form:select path="setups" items="${setups}" itemValue="id" itemLabel="name"
                                         class="selectpocker" multiple="true" data-width="auto"/>
                            <div class="has-error"><form:errors path="setups" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Region*</span>
                            <form:select path="region" items="${regions}" multiple="false" itemValue="id" itemLabel="name"
                                         class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="region" class="help-inline"/></div>
                        </div>


                        <div class="form-group">
                            <span class="badge" >Pay Methods</span>
                            <form:select path="payMethods" items="${payMethods}" multiple="true" itemValue="id" itemLabel="name"
                                         class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="payMethods" class="help-inline"/></div>
                        </div>

                        <div class="form-group">
                            <span class="badge">Средна сметка*</span>
                            <form:select path="avgBill" items="${avgBills}" multiple="false" itemValue="id" itemLabel="name"
                                         class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="avgBill" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Опции*</span>
                            <form:select path="options" items="${options}" multiple="true" itemValue="id" itemLabel="name" class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="options" class="help-inline"/></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-12 text-center">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update place" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Add place" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
                </c:otherwise>
            </c:choose>
        </div>
        </form:form>
    </div>
</section>


<!-- Portfolio Grid -->

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
