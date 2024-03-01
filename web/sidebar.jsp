<%@ page import="models.User" %><%
    User user = (User) request.getSession().getAttribute("user");

    if(user == null){
        response.sendRedirect("login");
        return;
    }
%>
<div class="d-flex flex-column  p-3 bg-light h-100" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
        <img src="imgs/bitlab.png" style="width: 40px; margin-right: 5px;" alt="">
        <span class="fs-4">BITLAB news</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="home" class="nav-link active" aria-current="page">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#home"></use>
                </svg>
                Home
            </a>
        </li>
        <%if(user.getRole() == 1){%>
        <li>
            <a href="#" class="nav-link link-dark">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#speedometer2"></use>
                </svg>
                Create a news post
            </a>
        </li>
        <li>
            <a href="addCategory" class="nav-link link-dark">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#table"></use>
                </svg>
                Add news category
            </a>
        </li>
        <%}%>
    </ul>
    <hr>
    <div class="dropdown">
        <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle"
           id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
            <strong><%=user.getFullName()%></strong>
        </a>
        <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2" style="">
            <li><a class="dropdown-item" href="/login">login</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li>
                <hr class="dropdown-divider">
            </li>

            <li><a class="dropdown-item" href="/logout">Sign out</a></li>
        </ul>
    </div>
</div>