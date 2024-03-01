<%--
  Created by IntelliJ IDEA.
  User: erasi
  Date: 23.02.2024
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="container  d-flex justify-content-center align-items-center">
    <div class="form d-flex flex-column  justify-content-center align-items-center ">
        <img src="imgs/bitlab-logo.png" alt="" id="logo">
        <form action="/register" method="post">

            <input type="text" id="login" name="username" class="form-control w-100 p-2 mb-3 rounded-3 " style="font-size: 25px;"
                   placeholder="login">

            <input type="text" id="fullname" name="fullname" class="form-control w-100 p-2 mb-3 rounded-3 " style="font-size: 25px;"
                   placeholder="your fullname">

            <input type="password" id="Password" name = "password" class="form-control w-100 p-2 mb-3 rounded-3" style="font-size: 25px;"
                   placeholder="password">

            <input type="password" id="Password" name = "confirm password" class="form-control w-100 p-2 mb-3 rounded-3" style="font-size: 25px;"
                   placeholder="confirm password">

            <%String result = (String) request.getAttribute("result");%>
            <%if (result != null) {%>
            <div class="alert alert-danger"><%=result%>
            </div>
            <%}%>

            <input type="submit" class="btn btn-primary p-3 pb-1  pt-1 rounded-3  " style="font-size: 25px;"
                   value="register">
        </form>
    </div>


</div>

</body>
</html>
