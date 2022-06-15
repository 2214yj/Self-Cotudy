<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>조회 페이지</title>
</head>
<body>
<p>
    <a href="<c:url value='/search?key=email'/>">
        [<spring:message code="go.searchEmail" />]
    </a>
</p>
<p>
    <a href="<c:url value='/search?key=id'/>">
        [<spring:message code="go.searchId" />]
    </a>
</p>
<p>
    <a href="<c:url value='/search?key=hp'/>">
        [<spring:message code="go.searchHp" />]
    </a>
</p>
</body>
</html>
