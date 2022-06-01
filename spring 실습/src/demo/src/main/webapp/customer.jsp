<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/05/10
  Time: 6:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CUSTOMER 정보 입력</title>
</head>
<body>
<form class="customer" action="./customer" method = "post">
    고객 이름: <input type = "text" class = "input" name = "name" placeholder="고객 이름" required> <br>
    주소: <input type = "text" class = "input" name = "address" placeholder="주소" required> <br>
    전화번호: <input type = "text" class = "input" name = "phone" placeholder="전화번호" required> <br>
    <br><br>
    <button class="btn" type="submit">제출</button>
</form>

</body>
</html>
