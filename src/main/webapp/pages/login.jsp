<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container ">
    <div class="row justify-content-center mt-5">
        <div class="col-4">
            <p>Login</p>
        </div>
    </div>
    <c:if test="${message != null}">
        <div class="row justify-content-center">
            <div class="alert alert-warning col-4" role="alert">
                    ${message}
            </div>
        </div>
    </c:if>
    <div class="row justify-content-center mt-5">
        <div class="col-4">
            <form action="/login" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail2" class="form-label">Username</label>
                    <input name="username" type="text" class="form-control" id="exampleInputEmail2"
                           aria-describedby="emailHelp2">
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary w-100">Submit</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>
