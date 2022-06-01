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
    <title>BOOK 정보 입력</title>
</head>
<body>
<form class="book" action="./book" method = "post">
책 이름: <input type = "text" class = "input" name = "name" placeholder="책 이름" required> <br>
출판사: <input type = "text" class = "input" name = "publisher" placeholder="출판사" required> <br>
가격: <input type = "text" class = "input" name = "price" placeholder="가격" required> <br>
    <br><br>
    <button class="btn" type="submit">제출</button>
</form>

</body>
</html>
