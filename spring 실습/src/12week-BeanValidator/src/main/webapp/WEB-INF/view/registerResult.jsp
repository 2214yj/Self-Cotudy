<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/05/23
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <a href="<c:url value='/'/>">
        [<spring:message code="go.main" />]
    </a>
</p>
    <p>
    <spring:message code="register.done">
        <spring:argument value="${registerRequest.name}" />
        <spring:argument value="${registerRequest.email}" />
    </spring:message>
    </p>
</body>
</html>
