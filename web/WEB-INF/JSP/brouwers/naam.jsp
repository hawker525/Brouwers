<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/02/2017
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri= 'http://www.springframework.org/tags'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Brouwers op naam</title>
</head>
<body>
    <a href="/">Menu</a>
    <h1>Brouwers op naam</h1>

    <form:form action='/brouwers/naam' commandName='brouwerZoeken' method='get'>
        <form:label path='naam'>Begin van de naam: <form:errors path="naam"/> </form:label><br />
        <form:input path='naam' autofocus='autofocus' value="${param.naam}"/><br />
        <input type='submit' value='Zoeken'><br />
        <form:errors cssClass="fout"/>
    </form:form>
    <c:if test="${not empty brouwers}">
        <ul>
        <c:forEach var="brouwer" items="${brouwers}">
           <li>${brouwer.naam}</li>
        </c:forEach>
        </ul>
    </c:if>
</body>
</html>
