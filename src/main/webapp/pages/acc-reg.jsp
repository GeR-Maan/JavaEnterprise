<%--
  Created by IntelliJ IDEA.
  User: germa
  Date: 25.10.2026
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account/reg" method="post">
    <input type="text" name="name" placeholder="Enter your name" />
    <input type="email" name="email" placeholder="Enter your email" />
    <input type="text" name="username" placeholder="Enter your username" />
    <input type="text" name="password" placeholder="Enter your password" />
    <button type="submit">Отправить</button>
</form>
</body>
</html>
