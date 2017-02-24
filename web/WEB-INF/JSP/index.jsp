<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/02/2017
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri= 'http://www.springframework.org/tags'%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <a href="/brouwers">Brouwers</a>
    <a href="/brouwers/beginnaam">Brouwers op naam</a>
    <a href="/brouwers/toevoegen">Brouwer toevoegen</a>
    <h1><spring:message code="${msg}"/> </h1>
</body>
</html>
