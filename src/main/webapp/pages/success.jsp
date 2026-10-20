<%--
  Created by IntelliJ IDEA.
  User: germa
  Date: 12.10.2026
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Заявка сохранена</title>
</head>
<body>

<h1>Заявка успешно сохранена</h1>

<ul>
    <li>Имя: <c:out value="${name}"/></li>
    <li>Email: <c:out value="${email}"/></li>
    <li>Сообщение: <c:out value="${message}"/></li>
</ul>

<a href="/form">Отправить ещё одну заявку</a>

</body>
</html>