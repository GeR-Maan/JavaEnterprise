<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${flag}">
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
</c:if>

<ul>
    <c:forEach items="${names}" var="name">
        <li>${name}</li>
    </c:forEach>
</ul>

<p>${message}</p>

</body>
</html>
