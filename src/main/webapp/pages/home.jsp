<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <c:forEach items="${posts}" var="post">
            <div class="card" style="width: 18rem;">
                <img src="${post.imageUrl}" class="card-img-top" alt="">
                <div class="card-body">
                    <h5 class="card-title">${post.title}</h5>
                    <p class="card-text">${post.content}</p>
                    <p class="card-text">${post.author.name}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
