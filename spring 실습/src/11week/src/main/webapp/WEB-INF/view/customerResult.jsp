<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/05/18
  Time: 3:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Result</title>
</head>
<body>
<a href="../../index.jsp">대문 페이지</a>
<p>Customer table에 새롭게 저장된 정보는 다음과 같습니다.</p>
<p> 이름: ${customerInfo.name}</p>
<p> 주소: ${customerInfo.address}</p>
<p> 전화번호: ${customerInfo.phone}</p>
</body>
</html>
