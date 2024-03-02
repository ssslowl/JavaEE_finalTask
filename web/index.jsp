<%@ page import="models.Post" %>
<%@ page import="java.util.List" %>
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

    <%
        List<Post> posts = (List<Post>) request.getAttribute("posts");
    %>


    <div class="container-fluid">
        <%for (Post p : posts) {%>
        <div class="row">
            <div class="col-md-10 d-flex justify-content-center right-bck">
                <div class="registration-right w-100">

                    <div class="event-list">
                        <div class="card flex-row mb-3"><img class="card-img-left img-fluid"
                                                             src="https://via.placeholder.com/150"/>
                            <div class="card-body">
                                <h4 class="card-title h5 h4-sm"><i class="fas fa-caret-right"
                                                                   aria-hidden="true"></i><span><%=p.getTitle()%></span><i
                                        class="fas fa-caret-right"
                                        aria-hidden="true"></i><span> <%=p.getPost_date()%></span></h4>
                                <p class="card-text"><%=p.getContent()%>></p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <%}%>
    </div>
</div>

</div>


</body>
</html>