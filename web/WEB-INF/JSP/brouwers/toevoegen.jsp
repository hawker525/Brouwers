<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/02/2017
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
</head>
<body>
<a href="/">Menu</a>
<h1>Brouwer toevoegen</h1>
<form:form action='/brouwers/toevoegen' commandName='brouwer'>
    <form:label path='naam'>Naam:<form:errors path='naam'/></form:label><br />
    <form:input path='naam' autofocus='autofocus' required='required' maxlength='50'/>
    <form:label path='adres.straat'>Straat:<br />
        <form:errors path='adres.straat' delimiter=', '/></form:label>
    <form:input path='adres.straat' required='required' maxlength='50'/>
    <form:label path='adres.huisNr'>Huisnr.:<br />
        <form:errors path='adres.huisNr' delimiter=', '/></form:label>
    <form:input path='adres.huisNr' required='required' maxlength='7'/>
    <form:label path='adres.postcode'>Postcode:<br />
        <form:errors path='adres.postcode' delimiter=', '/></form:label>
    <form:input path='adres.postcode' required='required' type='number' min='1000'
                max='9999'/>
    <form:label path='adres.gemeente'>Gemeente:<br />
        <form:errors path='adres.gemeente' delimiter=', '/></form:label>
    <form:input path='adres.gemeente' required='required' maxlength='50'/>
    <form:label path='omzet'>Omzet:<br />
        <form:errors path='omzet' delimiter=', '/></form:label>
    <form:input path='omzet' required='required'/>
    <input type='submit' value='Toevoegen'>
</form:form>
</body>
</html>
