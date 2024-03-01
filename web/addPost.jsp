<%@ page import="db.DbManager" %>
<%@ page import="java.util.List" %>
<%@ page import="models.NewsCategory" %>
<%@ page import="java.sql.SQLException" %>
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

        .form-group * {
            margin-bottom: 10px;
        }

    </style>
</head>
<body>
<%@include file="sidebar.jsp" %>


<div class="main">
    <%@include file="header.jsp" %>

    <form action="addPost" method="post">
        <div class="container-fluid">
            <div class="row">
                <div class="form-group mb-3 col-md-10">
                    <label for="title">Title</label>
                    <input type="text" class="form-control mb-3" name="title" id="title"
                           placeholder="Enter the title of post">


                    <label for="category">Category</label>
                    <select class="form-select" id="category" name="category" aria-label="Default select example">
                        <option selected>Select category</option>
                        <%
                            List<NewsCategory> categories = DbManager.categoryList();
                            for (NewsCategory i : categories) {%>
                        <option value="<%=i.getId()%>"><%=i.getName()%>
                        </option>
                        <%}%>
                        %>
                    </select>

                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control" name="description" id="description" rows="5"></textarea>
                    </div>


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