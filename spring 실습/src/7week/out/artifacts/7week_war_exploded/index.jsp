<%--
  Created by IntelliJ IDEA.
  User: kim-yeji
  Date: 2022/04/18
  Time: 3:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>test.Animal</title>
</head>
<body>
<%@page import="test.*" %>
반려동물 정보를 알아 봅니다.<br>
<%
    Owner owner = new Owner("박명수", 2);
    Animal animal1 = new Animal("포유류", "Cat");
    Animal animal2 = new Animal("포유류", "Dog");
%>
<%=owner.getName()%>씨는 <%=owner.getCount()%> 마리의 반려동물을 키우고 있습니다. <br>
반려동물의 종류는 <%=animal1.getType()%>인 <%=animal1.getClassName()%>과 <%=animal2.getType()%>인 <%=animal2.getClassName()%>입니다.
<br>
<%
    Dog dog = new Dog("두두", 'm', 2);
    Cat cat = new Cat("다다", 'g', 3);
%>
강아지의 이름은 <%=dog.getName()%>, 나이는 <%=dog.getAge()%>살, 성별은
<%if (dog.getGender() == 'm') {%>
남자입니다.<br>
<%} else {%>
여자입니다.<br><%}%>
고양이의 이름은 <%=cat.getName()%>, 나이는 <%=cat.getAge()%>살, 성별은
<%if (cat.getGender() == 'm') {%>
남자입니다.<br>
<%} else {%>
여자입니다.<br><%}%>

</body>
</html>
