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
<%--<form:form method="POST" modelAttribute="place" class="form-horizontal">

    <form:input type="hidden" path="id" id="id"/>

    <div class="row">
        <div class="form-group col-md-12">

            <span class="badge">Logo</span>
            <div class="col-md-12">
                <form:input type="text" path="logo" id="logo" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="logo" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="name">Name</label>
            <div class="col-md-12">
                <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="name" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="address">Address</label>
            <div class="col-md-12">
                <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="address" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="mapLat">Map Lat</label>
            <div class="col-md-12">
                <form:input type="number" path="mapLat" id="mapLat" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="mapLat" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="mapLng">Map Lng</label>
            <div class="col-md-12">
                <form:input type="number" path="mapLng" id="mapLng" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="mapLng" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="spots">Spots</label>
            <div class="col-md-12">
                <form:input type="number" path="spots" id="spots" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="spots" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="placeType">Place Type</label>
            <div class="col-md-12">
                <form:select path="placeType" items="${placeTypes}" multiple="false" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="placeType" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="placeType">Setups</label>
            <div class="col-md-12">
                <form:select path="setups" items="${setups}" multiple="false" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="setups" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="region">Region</label>
            <div class="col-md-12">
                <form:select path="region" items="${regions}" multiple="false" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="region" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="avgBill">Avg Bill</label>
            <div class="col-md-12">
                <form:select path="avgBill" items="${avgBills}" multiple="false" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="avgBill" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="options">Options</label>
            <div class="col-md-12">
                <form:select path="options" items="${options}" multiple="true" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="options" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="payMethods">Pay Methods</label>
            <div class="col-md-7">
                <form:select path="payMethods" items="${payMethods}" multiple="true" itemValue="id" itemLabel="name"
                             class="selectpicker" data-width="auto"/>
                <div class="has-error">
                    <form:errors path="payMethods" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="pathToGallery">Path to gallery</label>
            <div class="col-md-7">
                <form:input type="text" path="pathToGallery" id="pathToGallery" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="pathToGallery" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="infoPlace">info place</label>
            <div class="col-md-7">
                <form:input type="text" path="infoPlace" id="infoPlace" class="form-control input-sm"/>
                <div class="has-error">
                    <form:errors path="infoPlace" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-actions floatRight">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
                        href="<c:url value='/list' />">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                        href="<c:url value='/list' />">Cancel</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


</form:form>--%>
<section class="bg-light" id="favoriteRestorant">
    <div class="container">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Добави ресторант</h2>
        </div>

        <div class="generic-container">

        </div>
        <form:form method="POST" modelAttribute="place" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
            <div class="row">
            <div class="col-md-4 col-sm-6 portfolio-item">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="badge" for="logo">Лого*</label>
                            <div>
                                <form:input type="text" path="logo" id="logo" class="form-control input-sm"/>
                                <div class="has-error">
                                    <form:errors path="logo" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Име*</span>
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="name" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Адрес*</span>
                            <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="address" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Тип на мястото*</span>
                            <form:select path="placeType" items="${placeTypes}" multiple="false" itemValue="id" itemLabel="name" class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="placeType" class="help-inline"/></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 portfolio-item">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <span class="badge">Брой места*</span>
                            <form:input type="number" path="spots" id="spots" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="spots" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Map length*</span>
                            <form:input type="number" path="mapLng" id="mapLng" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="mapLng" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Фамилия</span>
                            <form:input type="number" path="mapLat" id="mapLat" class="form-control input-sm"/>
                            <div class="has-error"><form:errors path="mapLat" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Фамилия</span>
                            <form:input type="text" path="pathToGallery" id="pathToGallery" class="form-control input-sm"/>
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
                            <span class="badge">Екстри*</span>
                            <form:select path="setups" items="${setups}" itemValue="id" itemLabel="name"
                                         class="selectpocker" multiple="true" data-width="auto"/>
                            <div class="has-error"><form:errors path="setups" class="help-inline"/></div>
                        </div>
                        <div class="form-group">
                            <span class="badge">Квартал*</span>
                            <form:select path="region" items="${regions}" multiple="false" itemValue="id" itemLabel="name"
                                         class="selectpicker" data-width="auto"/>
                            <div class="has-error"><form:errors path="region" class="help-inline"/></div>
                        </div>


                        <div class="form-group">
                            <span class="badge">Фамилия</span>
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

<!-- Portfolio Modals -->

<!-- Modal 1 -->
<div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/01-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Threads</li>
                                <li>Category: Illustration</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal 2 -->
<div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/02-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Explore</li>
                                <li>Category: Graphic Design</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal 3 -->
<div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/03-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Finish</li>
                                <li>Category: Identity</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal 4 -->
<div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/04-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Lines</li>
                                <li>Category: Branding</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal 5 -->
<div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/05-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Southwest</li>
                                <li>Category: Website Design</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal 6 -->
<div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl"></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="modal-body">
                            <!-- Project Details Go Here -->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img class="img-fluid d-block mx-auto" src="img/portfolio/06-full.jpg" alt="">
                            <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt
                                repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae,
                                nostrum, reiciendis facere nemo!</p>
                            <ul class="list-inline">
                                <li>Date: January 2017</li>
                                <li>Client: Window</li>
                                <li>Category: Photography</li>
                            </ul>
                            <button class="btn btn-primary" data-dismiss="modal" type="button">
                                <i class="fa fa-times"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


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
