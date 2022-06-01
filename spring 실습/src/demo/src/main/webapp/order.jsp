
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
  <title>ORDER 정보 입력</title>
</head>
<body>
<form class="order" action="./order" method = "post">
  고객 이름: <input type = "text" class = "input" name = "customerName" placeholder="고객 이름" required> <br>
  도서 이름: <input type = "text" class = "input" name = "bookName" placeholder="도서 이름" required> <br>
  가격: <input type = "text" class = "input" name = "publisher" placeholder="가격" required> <br>
  <br><br>
  <button class="btn" type="submit">제출</button>
</form>

</body>
</html>