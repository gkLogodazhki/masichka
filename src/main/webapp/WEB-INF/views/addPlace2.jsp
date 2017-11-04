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
<div class="container">
    <%-- <%@include file="authheader.jsp" %>--%>

    <div class="well lead"><p>Add place</p></div>
    <form:form method="POST" modelAttribute="place" class="form-control">
        <form:input type="hidden" path="id" id="id"/>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="form-group col-md-offset-4">
                    <label for="logo">Logo</label>
                    <form:input type="text" path="logo" id="logo" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="logo" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="logo">Name</label>
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="name" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="logo">Address</label>
                    <form:input type="text" path="address" id="address" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="address" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="logo">Map Lat</label>
                    <form:input type="number" path="mapLat" id="mapLat" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="mapLat" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="logo">Map Lng</label>
                    <form:input type="number" path="mapLng" id="mapLng" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="mapLng" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="logo">Spots</label>
                    <form:input type="number" path="spots" id="spots" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="spots" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="placeType" >Place Type</label>
                    <form:select path="placeType" items="${placeTypes}" multiple="false" itemValue="id" itemLabel="name"
                                 class="selectpicker"/>
                    <div class="has-error">
                        <form:errors path="placeType" class="help-inline"/>
                    </div>
                </div>
                <div class="form-group col-md-offset-4">
                    <label for="placeType">Setups</label>
                    <form:select path="setups" items="${setups}" multiple="false" itemValue="id" itemLabel="name"
                                 class="selectpicker"/>
                    <div class="has-error">
                        <form:errors path="setups" class="help-inline"/>
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div>
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
                <label class="col-md-3 control-lable" for="infoPlace">Info place</label>
                <div class="col-md-7">
                    <form:textarea path="infoPlace" id="infoPlace" class="form-control" rows="4"/>
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
                            href="<c:url value='/' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
                            href="<c:url value='/' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="infoPlace">info place</label>
                <div class="col-md-7">
                    <table id="example" class="display" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th>Day</th>
                            <th>Morning</th>
                            <th>Afternoon</th>
                            <th>Evening</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Monday</td>
                            <td><input id="mondayMornig" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="mondayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="mondayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Tuesday</td>
                            <td><input id="tuesdayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="tuesdayafternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="tuesdayevening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Wednesday</td>
                            <td><input id="wednesdayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="wednesdayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="wednesdayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Thursday</td>
                            <td><input id="thursdayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="thursdayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="thursdayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Friday</td>
                            <td><input id="fridayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="fridayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="fridayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Saturday</td>
                            <td><input id="saturdayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="saturdayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="saturdayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        <tr>
                            <td>Sunday</td>
                            <td><input id="sundayMorning" name="morning" value="0" type="number" min="0" max="100"></td>
                            <td><input id="sundayAfternoon" name="afternoon" value="0" type="number" min="0" max="100"></td>
                            <td><input id="sundayEvening" name="evening" value="0" type="number" min="0" max="100"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>