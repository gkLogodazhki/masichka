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
<!-- Portfolio Grid -->
<section class="bg-light" id="myRezervation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Моите резервации</h2>
            </div>
        </div>
        <div class="well well-sm">
            <strong>Покажи</strong>
            <div class="btn-group">
                <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>Лист</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                    class="glyphicon glyphicon-th"></span>Решетка</a>
            </div>
        </div>
        <div id="products" class="row list-group">
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-danger" href="http://www.jquery2dotnet.com">Отмени резервация</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<style>

    .glyphicon {
        margin-right: 5px;
    }

    .thumbnail {
        margin-bottom: 20px;
        padding: 0px;
        -webkit-border-radius: 0px;
        -moz-border-radius: 0px;
        border-radius: 0px;
    }

    .item.list-group-item {
        float: none;
        width: 100%;
        background-color: #fff;
        margin-bottom: 10px;
    }

    .item.list-group-item:nth-of-type(odd):hover, .item.list-group-item:hover {
        background: #428bca;
    }

    .item.list-group-item .list-group-image {
        margin-right: 10px;
    }

    .item.list-group-item .thumbnail {
        margin-bottom: 0px;
    }

    .item.list-group-item .caption {
        padding: 9px 9px 0px 9px;
    }

    .item.list-group-item:nth-of-type(odd) {
        background: #eeeeee;
    }

    .item.list-group-item:before, .item.list-group-item:after {
        display: table;
        content: " ";
    }

    .item.list-group-item img {
        float: left;
    }

    .list-group-item-text {
        margin: 0 0 11px;
    }

    .item.grid-group-item {
        width: 30% !important;
    }

    #products.list-group {
        flex-direction: row !important;
    }

    .grid-group-item > .thumbnail > img {
        width: 90%;
        padding: 5%;
    }

    .grid-group-item > .thumbnail > caption {
        width: 90%;
        padding: 5%;
    }
</style>
<!-- Portfolio Grid -->
<section class="bg-light" id="favoriteRestorant">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Любими ресторанти</h2>
            </div>
        </div>
        <%-- <div class="well well-sm">
             <strong>Покажи</strong>
             <div class="btn-group">
                 <a href="#" id="list1" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"></span>Лист</a>
                 <a href="#" id="grid1" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Решетка</a>
             </div>
         </div>--%>
        <div id="products" class="row list-group">
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-danger" href="http://www.jquery2dotnet.com">Премахни от любими</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Services -->
<section id="history">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Ресторанти дневник</h2>
            </div>
        </div>
        <div id="products" class="row list-group">
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">Саса</h4>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    Дата - > </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="item  col-lg-12 list-group-item">
                <div class="thumbnail">
                    <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">
                            Product title</h4>
                        <p class="group inner list-group-item-text">
                            Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                            sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="lead">
                                    $21.000</p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Portfolio Grid -->
<section id="lastReservation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Минали резервации</h2>
                <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">
            <div id="products" class="row list-group">
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">Саса</h4>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        Дата - > </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                Product title</h4>
                            <p class="group inner list-group-item-text">
                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                volutpat.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                Product title</h4>
                            <p class="group inner list-group-item-text">
                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                volutpat.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                Product title</h4>
                            <p class="group inner list-group-item-text">
                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                volutpat.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                Product title</h4>
                            <p class="group inner list-group-item-text">
                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                volutpat.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item  col-lg-12 list-group-item">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                Product title</h4>
                            <p class="group inner list-group-item-text">
                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                volutpat.</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        $21.000</p>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="bg-light" id="favoriteRestorant">
    <div class="container">
        <div class="col-lg-12 text-center">
            <h2 class="section-heading text-uppercase">Промяна профил</h2>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 portfolio-item">
                <form id="editProfile" name="sentMessage" novalidate>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <span class="badge">Нова парола*</span>
                                <input class="form-control" id="name" type="text" required
                                       data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Повтори нова парола*</span>
                                <input class="form-control" id="email" type="email" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Текуща парола*</span>
                                <input class="form-control" id="phone" type="tel" required
                                       data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
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
                                <span class="badge">Телефон</span>
                                <input class="form-control" id="email" type="email" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <span class="badge">Парола</span>
                                <input class="form-control" id="email" type="email" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
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

<!-- Portfolio Grid -->
<%--<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading text-uppercase">Contact Us</h2>
                <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <form id="contactForm" name="sentMessage" novalidate>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input class="form-control" id="name" type="text" placeholder="Your Name *" required
                                       data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <input class="form-control" id="email" type="email" placeholder="Your Email *" required
                                       data-validation-required-message="Please enter your email address.">
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <input class="form-control" id="phone" type="tel" placeholder="Your Phone *" required
                                       data-validation-required-message="Please enter your phone number.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                Send Message
                            </button>
                        </div>
                    </div>
                </form>
                        <div class="col-md-6">
                            <div class="form-group">
                                <form id="contactForm" name="sentMessage" novalidate>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <input class="form-control" id="name" type="text" placeholder="Your Name *" required
                                                       data-validation-required-message="Please enter your name.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" id="email" type="email" placeholder="Your Email *" required
                                                       data-validation-required-message="Please enter your email address.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control" id="phone" type="tel" placeholder="Your Phone *" required
                                                       data-validation-required-message="Please enter your phone number.">
                                                <p class="help-block text-danger"></p>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="col-lg-12 text-center">
                                            <div id="success"></div>
                                            <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                                Send Message
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form id="contactForm" name="sentMessage" novalidate>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input class="form-control" id="name" type="text" placeholder="Your Name *" required
                                               data-validation-required-message="Please enter your name.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" id="email" type="email" placeholder="Your Email *" required
                                               data-validation-required-message="Please enter your email address.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" id="phone" type="tel" placeholder="Your Phone *" required
                                               data-validation-required-message="Please enter your phone number.">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                                <div class="col-lg-12 text-center">
                                    <div id="success"></div>
                                    <button id="sendMessageButton" class="btn btn-primary btn-xl text-uppercase" type="submit">
                                        Send Message
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>--%>

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

<script type="text/javascript">
    $(document).ready(function () {
        $('#list').click(function (event) {
            event.preventDefault();
            $('#products .item').addClass('list-group-item').addClass('col-lg-12').removeClass('col-lg-4');
            $('#products .item').removeClass('grid-group-item');

        });

        $('#grid').click(function (event) {
            event.preventDefault();
            $('#products .item').removeClass('list-group-item');
            $('#products .item').addClass('grid-group-item').removeClass('col-lg-12').addClass('.col-lg-4');
        });
    });
</script>


</body>

</html>
