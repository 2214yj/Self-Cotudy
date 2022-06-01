<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/05/25
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getParameter("key")%>로 조회</title>
</head>
<body>
<p>
    <a href="<c:url value='/'/>">
        [<spring:message code="go.main" />]
    </a>
</p>
<h2><%=request.getParameter("key")%>로 회원 정보를 조회합니다.</h2>
<form:form action="search" modelAttribute="searchRequest">
    <input type="hidden" name="key" value=<%=request.getParameter("key")%> />
    <p>
    <label>조회할 <%=request.getParameter("key")%>를 입력하세요. :<br>
    <form:input path="keyword" />
    <form:errors path="keyword"/>
    </label>
    </p>
    <input type="submit" value="<spring:message code="search.btn" />">
</form:form>
</body>
</html>
