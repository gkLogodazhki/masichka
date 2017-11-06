<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="loginUrl" value="/facebook"/>
<form:form action="facebook" name="sentMessage" modelAttribute="userFacebook">

    <%
        String user_name = request.getParameter("user_name");
        String user_email = request.getParameter("user_email");
    %>
    <form:input name="username" path="username" type="text" required="required" value="<%=user_name %>"/>
    <form:input name="email" path="email" type="text" required="required" value="<%=user_email %>"/>
</form:form>