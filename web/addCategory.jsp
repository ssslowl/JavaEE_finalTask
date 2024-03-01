<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%@include file="imports.jsp" %>

    <style>

        body {
            display: flex;
            height: 100vh;
            width: 100vw;
        }

        .main {
            width: 100%;
        }

    </style>
</head>
<body>
<%@include file="sidebar.jsp" %>


<div class="main">
    <%@include file="header.jsp" %>

    <form action="addCategory" method="post">
        <div class="container-fluid">
            <div class="row">
                <div class="form-group mb-3">
                    <input type="text" class="form-control mb-3" name="category" id="category"
                           placeholder="Enter the name of category">
                    <%String result = (String) request.getAttribute("result");%>
                    <%if (result != null) {%>
                    <div class="alert alert-success"><%=result%>
                    </div>
                    <%}%>
                    <input type="submit" value="Add category" class="btn btn-primary" style="width: fit-content">
                </div>


            </div>
        </div>
    </form>

</div>


</body>
</html>