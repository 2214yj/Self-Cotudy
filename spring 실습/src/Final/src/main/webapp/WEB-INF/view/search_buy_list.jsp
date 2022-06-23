<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<html>
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="/css/nav.css" />
</head>
<body>
<c:if test="${empty authInfo}">
    <% request.setCharacterEncoding("UTF-8"); %>
    <nav class="navbar">
        <div class="navbar-container container">
            <input type="checkbox">
            <div class="hamburger-lines">
                <span class="line line1"></span>
                <span class="line line2"></span>
                <span class="line line3"></span>
            </div>
            <ul class="menu-items">
                <li><a href="./search/all">전체 상품 조회</a></li>
                <li>
                    <a href="./login">로그인</a>
                </li>
                <li>
                    <a href="./register">회원가입</a>
                </li>
            </ul>
            <h1 class="logo"><a href="/">숭실쇼핑몰</a></h1>
        </div>
    </nav>
    <section style="padding: 100px 60px 20px 60px">
        <div>
            <form:form action="/search" method="get" modelAttribute="searchBuyInfo">
                <p><label> <spring:message code="search"/><br>
                    <form:input type="text" path="keyword" placeholder="검색어"/> <form:errors path="keyword"/> </label>
                    <button class="btn" type="submit"><spring:message code="go"/></button>
                </p>
                <p><label> <spring:message code="startDate"/><br>
                    <form:input type="text" path="startDate" placeholder="시작날짜"/> <form:errors path="startDate"/> </label>
                    <label> <spring:message code="endDate"/><br>
                    <form:input type="text" path="endDate" placeholder="종료날짜"/> <form:errors path="endDate"/> </label>
                    <button class="btn" type="submit"><spring:message code="go"/></button>
                </p>
            </form:form>
        </div>
    </section>
</c:if>
<c:if test="${! empty authInfo}">
    <nav class="navbar">
        <div class="navbar-container container">
            <input type="checkbox" name="" id="">
            <div class="hamburger-lines">
                <span class="line line1"></span>
                <span class="line line2"></span>
                <span class="line line3"></span>
            </div>
            <ul class="menu-items">
                <li>${authInfo.userid}님 </li>
                <li><a href="/search/all">전체 상품 조회</a></li>
                <li><a href="/search/buy">구매이력 조회</a></li>
                <li><a href="/userInfo/${authInfo.userid}">회원정보 조회</a></li>
                <li><a href="/modifyUserInfo/${authInfo.userid}">회원정보 수정</a></li>
                <li><a href="/logout">로그아웃</a></li>
                <li><a href="/remove">회원탈퇴</a></li>
            </ul>
            <h1 class="logo"><a href="/">숭실쇼핑몰</a></h1>
        </div>
    </nav>
    <section style="padding: 100px 60px 20px 60px">
        <div>
            <h1>${authInfo.userid}님의 구매 이력을 조회해보세요. </h1><br>
            <form:form action="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}" method="get" modelAttribute="searchBuyInfo">
                <p><label> <spring:message code="search"/><br>
                    <form:input path="keyword" value="${keyword}"/> <form:errors path="keyword"/> </label>
                <p><label> <spring:message code="startDate"/><br>
                    <form:input type="date" path="startDate"/> <form:errors path="startDate"/> </label>
                <p><label> <spring:message code="endDate"/><br>
                    <form:input type="date" path="endDate"/> <form:errors path="endDate"/> </label><br>
                <br> <button class="btn" type="submit"><spring:message code="go"/></button></p>
            </form:form>
        </div>
    </section>
<section style="padding: 100px 60px 20px 60px">
    <c:if test="${empty searchBuyingResult}">
    <br>
    <h2>조회 가능한 상품이 없습니다.</h2>
    <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=최신순">최신순</a>
    <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=오래된순">오래된순</a>
    <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=저렴한순">저렴한순</a>
    <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=비싼순">비싼순</a>
    <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=인기순">인기순</a>
    <br>
    </c:if>
    <c:if test="${! empty searchBuyingResult}">
    <br>
    <h2>"구매 이력 조회 결과"</h2>
        <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=최신순">최신순</a>
        <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=오래된순">오래된순</a>
        <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=저렴한순">저렴한순</a>
        <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=비싼순">비싼순</a>
        <a href="/search/buy/${authInfo.userid}/list?keyword=${keyword}&startDate=${startDate}&endDate=${endDate}&searchType=인기순">인기순</a>
    <table style="border-style: dashed; padding: 20px 20px 20px 20px; text-align: center; width: 70%">
        <thead>
        <tr style="border-style: dashed">
            <th>카테고리</th>
            <th>이름</th>
            <th>가격</th>
            <th>구매일자</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${searchBuyingResult}" var="result">
            <tr>
                <td>${result.category}</td>
                <td><a href="/search/${result.id}">${result.name}</a></td>
                <td>${result.price}</td>
                <td>${result.buyingDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    </c:if>

</c:if>
</body>
</html>



<style>
    *,
    *::after,
    *::before{
        box-sizing: border-box;
        padding: 0;
        margin: 0;
    }

    .html{
        font-size: 62.5%;
    }

    .navbar input[type="checkbox"],
    .navbar .hamburger-lines{
        display: none;
    }

    .container{
        max-width: 1200px;
        width: 90%;
        margin: auto;
    }

    .navbar{
        box-shadow: 0px 5px 10px 0px #aaa;
        position: fixed;
        width: 100%;
        background: #fff;
        color: #000;
        opacity: 0.85;
        z-index: 100;
    }

    .navbar-container{
        display: flex;
        justify-content: space-between;
        height: 64px;
        align-items: center;
    }

    .menu-items{
        order: 2;
        display: flex;
    }
    .logo{
        order: 1;
        font-size: 2.3rem;
    }

    .menu-items li{
        list-style: none;
        margin-left: 1.5rem;
        font-size: 1.3rem;
    }

    .navbar a{
        color: #444;
        text-decoration: none;
        font-weight: 500;
        transition: color 0.3s ease-in-out;
    }

    .navbar a:hover{
        color: #117964;
    }

    @media (max-width: 768px){
        .navbar{
            opacity: 0.95;
        }

        .navbar-container input[type="checkbox"],
        .navbar-container .hamburger-lines{
            display: block;
        }

        .navbar-container{
            display: block;
            position: relative;
            height: 64px;
        }

        .navbar-container input[type="checkbox"]{
            position: absolute;
            display: block;
            height: 32px;
            width: 30px;
            top: 20px;
            left: 20px;
            z-index: 5;
            opacity: 0;
            cursor: pointer;
        }

        .navbar-container .hamburger-lines{
            display: block;
            height: 28px;
            width: 35px;
            position: absolute;
            top: 20px;
            left: 20px;
            z-index: 2;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .navbar-container .hamburger-lines .line{
            display: block;
            height: 4px;
            width: 100%;
            border-radius: 10px;
            background: #333;
        }

        .navbar-container .hamburger-lines .line1{
            transform-origin: 0% 0%;
            transition: transform 0.3s ease-in-out;
        }

        .navbar-container .hamburger-lines .line2{
            transition: transform 0.2s ease-in-out;
        }

        .navbar-container .hamburger-lines .line3{
            transform-origin: 0% 100%;
            transition: transform 0.3s ease-in-out;
        }

        .navbar .menu-items{
            padding-top: 100px;
            background: #fff;
            height: 100vh;
            max-width: 300px;
            transform: translate(-150%);
            display: flex;
            flex-direction: column;
            margin-left: -40px;
            padding-left: 40px;
            transition: transform 0.5s ease-in-out;
            box-shadow:  5px 0px 10px 0px #aaa;
            overflow: scroll;
        }

        .navbar .menu-items li{
            margin-bottom: 1.8rem;
            font-size: 1.1rem;
            font-weight: 500;
        }

        .logo{
            position: absolute;
            top: 10px;
            right: 15px;
            font-size: 2.5rem;
        }

        .navbar-container input[type="checkbox"]:checked ~ .menu-items{
            transform: translateX(0);
        }

        .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line1{
            transform: rotate(45deg);
        }

        .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line2{
            transform: scaleY(0);
        }

        .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line3{
            transform: rotate(-45deg);
        }

    }

    @media (max-width: 500px){
        .navbar-container input[type="checkbox"]:checked ~ .logo{
            display: none;
        }
    }
</style>

