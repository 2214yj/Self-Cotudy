<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/05/23
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
<h2><spring:message code="member.info" /></h2>
<form:form action="registerResult" modelAttribute="registerRequest">
    <p>
        <label><spring:message code="id" />:<br>
            <form:input path="id" />
            <form:errors path="id"/>
        </label>
    </p>
    <p>
        <label><spring:message code="name" />:<br>
            <form:input path="name" />
            <form:errors path="name"/>
        </label>
    </p>
    <p>
        <label><spring:message code="email" />:<br>
            <form:input path="email" />
            <form:errors path="email"/>
        </label>
    </p>
    <p>
        <label><spring:message code="address" />:<br>
            <form:input path="address" />
            <form:errors path="address"/>
        </label>
    </p>
    <p>
        <label><spring:message code="hp" />:<br>
            <form:input path="hp" />
            <form:errors path="hp"/>
        </label>
    </p>



    <input type="submit" value="<spring:message code="register.btn" />">
</form:form>
</body>
</html>
