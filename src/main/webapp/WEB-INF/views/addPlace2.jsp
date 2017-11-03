<%--
  Created by IntelliJ IDEA.
  User: gklogodazhki
  Date: 11/1/17
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Add Place</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <%-- <%@include file="authheader.jsp" %>--%>

    <div class="well lead">Add place</div>

    <form:form method="POST" modelAttribute="place" class="form-horizontal">

        <form:input type="hidden" path="id" id="id"/>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="logo">Logo</label>
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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
                <div class="col-md-7">
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

    </form:form>
</div>
</body>
</html>