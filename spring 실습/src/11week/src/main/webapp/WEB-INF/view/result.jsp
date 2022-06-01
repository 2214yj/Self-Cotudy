<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>데이터 현황</title>
</head>
<body>
<a href="../../index.jsp">대문 페이지</a>
<br><br>
<caption>Book 테이블의 내용</caption>
<table width="50%" border="1">
    <thead>
    <tr>
        <th>아이디</th>
        <th>책 이름</th>
        <th>책 출판사</th>
        <th>책 가격</th>
    </tr>
    </thead>
    <tbody>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            String jdbcDriver = "jdbc:mysql://localhost:3306/jdbctest?useUnicode=true&characterEncoding=utf8";
            String dbUser = "root";
            String dbPwd = "Ga3785yj)!!#";

            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);

            pstmt = conn.prepareStatement("select * from Book");

            rs = pstmt.executeQuery();

            while(rs.next()){
    %>
    <tr>
        <td><%= rs.getInt("bookid") %></td>
        <td><%= rs.getString("bookname") %></td>
        <td><%= rs.getString("publisher") %></td>
        <td><%= rs.getString("price") %></td>
    </tr>
    <%
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    %>
    </tbody>
</table>
<br><br>
<caption>Customer 테이블의 내용</caption>
<table width="50%" border="1">
    <thead>
    <tr>
        <th>아이디</th>
        <th>고객 이름</th>
        <th>주소</th>
        <th>전화번호</th>
    </tr>
    </thead>
    <tbody>
    <%
        try{

            pstmt = conn.prepareStatement("select * from Customer");

            rs = pstmt.executeQuery();

            while(rs.next()){
    %>
    <tr>
        <td><%= rs.getInt("custid") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("address") %></td>
        <td><%= rs.getString("phone") %></td>
    </tr>
    <%
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    %>
    </tbody>
</table>
<br><br>
<caption>Orders 테이블의 내용</caption>
<table width="50%" border="1">
    <thead>
    <tr>
        <th>주문 아이디</th>
        <th>손님 아이디</th>
        <th>책 아이디</th>
        <th>판매 가격</th>
        <th>날짜</th>
    </tr>
    </thead>
    <tbody>
    <%
        try{

            pstmt = conn.prepareStatement("select * from Orders");

            rs = pstmt.executeQuery();

            while(rs.next()){
    %>
    <tr>
        <td><%= rs.getInt("orderid") %></td>
        <td><%= rs.getInt("custid") %></td>
        <td><%= rs.getInt("bookid") %></td>
        <td><%= rs.getInt("saleprice") %></td>
        <td><%= rs.getString("orderdate") %></td>
    </tr>
    <%
            }
        }catch(SQLException se){
            se.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }
    %>
    </tbody>
</table>
</body>
</html>

