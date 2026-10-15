<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 17.09.2026
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container ">
  <div class="row justify-content-center mt-5">
    <div class="col-4">
      <p>Create Post</p>
    </div>
  </div>
  <div class="row justify-content-center mt-5">
    <div class="col-4">
      <form action="/post/create" method="post">
        <div class="mb-3">
          <label for="exampleInputEmail2" class="form-label">Title</label>
          <input name="title" type="text" class="form-control" id="exampleInputEmail2"
                 aria-describedby="emailHelp2">
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Content</label>
          <input name="content" type="text" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword2" class="form-label">Image URL</label>
          <input name="imageUrl" type="text" class="form-control" id="exampleInputPassword2">
        </div>
        <button type="submit" class="btn btn-primary w-100">Create post</button>
      </form>
    </div>
  </div>

</div>
</body>
</html>
