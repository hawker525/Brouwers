<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/02/2017
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri= 'http://www.springframework.org/tags'%>
<html>
<head>
    <link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
    <title>Title</title>
</head>
<body>
<a href="/">Terug naar hoofdpagina</a>
<h1>Brouwers op alfabet <c:if test="${not empty letter}">${letter}</c:if></h1>
<ul>
    <c:forEach items="${alfabet}" var="letter">
        <li>
            <spring:url value="/brouwers/beginnaam/{letter}" var="letterURL">
                <spring:param name="letter" value="${letter}"/>
            </spring:url>
            <a href="${letterURL}">${letter}</a>
        </li>
    </c:forEach>
</ul>
<c:if test="${not empty brouwers}">
    <ul>
    <c:forEach items="${brouwers}" var="brouwer">
       <li>${brouwer.naam} (${brouwer.adres.gemeente})</li>
    </c:forEach>
    </ul>
</c:if>
</body>
</html>
