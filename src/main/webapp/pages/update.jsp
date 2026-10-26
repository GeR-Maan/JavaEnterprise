<%--
  Created by IntelliJ IDEA.
  User: germa
  Date: 26.10.2026
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/account/update" method="post">
  <input type="text" name="name" placeholder=${sessionScope.account.name} />
  <input type="text" name="username" placeholder=${sessionScope.account.username} />
  <input type="text" name="password" placeholder=${sessionScope.account.password} />
  <button type="submit">Обновить</button>

</form>
</body>
</html>
