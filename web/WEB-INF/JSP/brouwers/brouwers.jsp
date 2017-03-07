<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/02/2017
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri= 'http://www.springframework.org/tags'%>
<html>
<head>
    <title>Brouwers</title>
</head>
<body>
<a href="/">Terug naar hoofdpagina</a>
<h1>Alle brouwers</h1>
<table>
    <tr>
        <th>Nummer</th>
        <th>Naam</th>
        <th>Straat</th>
        <th>HuisNr</th>
        <th>Postcode</th>
        <th>Gemeente</th>
        <th>Omzet</th>
    </tr>
<c:forEach items="${brouwers}" var="brouwer">
    <tr>
        <td>${brouwer.id}</td>
        <td>${brouwer.naam}</td>
        <td>${brouwer.adres.straat}</td>
        <td>${brouwer.adres.huisNr}</td>
        <td>${brouwer.adres.postcode}</td>
        <td>${brouwer.adres.gemeente}</td>
        <td>${brouwer.omzet}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
