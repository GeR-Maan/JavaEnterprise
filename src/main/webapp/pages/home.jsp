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
<span>Hello ${sessionScope.account.name}!</span>
<a href="/account/reg">Sing UP</a>
<a href="/account/login">Sing IN</a>
<a href="/account/logout">Sing OUT</a>

</body>
</html>
