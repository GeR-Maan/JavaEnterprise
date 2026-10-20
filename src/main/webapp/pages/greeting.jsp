<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${flag}">
    <p> Test = true</p>
    <p> Test = true</p>
    <p> Test = true</p>
</c:if>


<ul>
    <c:forEach items="${names}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>


<p> ${message}</p>

<%= 2+3 %>
</body>
</html>
