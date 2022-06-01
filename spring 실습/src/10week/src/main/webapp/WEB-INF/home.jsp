
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
  <title>Home</title>
</head>
<body>
<h1> 고객 정보와 도서 정보를 알 수 있는 사이트 입니다. </h1>
<p>고객의 수는 ${customerCount}입니다.</p>   <a href="./search/customer">고객 정보</a>
<p>책 개수는 ${bookCount}입니다.</p>  <a href="./search/book">책 정보</a>

</body>
</html>