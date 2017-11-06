<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container text-center">
    <div class="panel panel-default text-center">
        <!-- Default panel contents -->
        <div class="panel-heading text-center"><span class="lead">List of Places </span></div>
        <table class="table table-hover text-center">
            <thead>
            <tr>
                <th>Name</th>
                <th>Address</th>
                <th>City</th>
                <sec:authorize access="hasRole('ADMIN')">
                    <th width="100"></th>
                    <th width="100"></th>
                </sec:authorize>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.name}</td>
                    <td>${place.address}</td>
                    <td>${place.region.city.name}</td>
                    <sec:authorize access="hasRole('ADMIN')">
                        <td><a href="<c:url value='/admin/edit-place-${place.name}' />" class="btn btn-success custom-width">edit</a></td>
                        <td><a href="<c:url value='/admin/delete-place-${place.name}' />" class="btn btn-danger custom-width">delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <sec:authorize access="hasRole('ADMIN')">
        <div class="well">
            <a href="<c:url value='/admin/addPlace' />">Add New Place</a>
        </div>
    </sec:authorize>
</div>
</body>
</html>