<%--
  Created by IntelliJ IDEA.
  User: germa
  Date: 25.10.2026
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>Hello ${sessionScope.account.name} - ${sessionScope.account.profile.email}!</span>
<a href="/account/login">Login</a>
<a href="/account/reg">Registration</a>
<a href="/account/update">Update</a>
<a href="/account/delete">Delete</a>
<a href="/account/logout">Logout</a>
</body>
</html>
