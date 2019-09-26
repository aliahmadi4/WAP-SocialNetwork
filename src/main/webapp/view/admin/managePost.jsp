<%--
  Created by IntelliJ IDEA.
  User: tungnd
  Date: 9/24/19
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage Post</title>
    <!-- Bootstrap CSS -->
    <jsp:include page="../layout/header.jsp"/>
</head>

<body>
<%
    //allow access only if session exists
    if (session.getAttribute("loginedUser") == null) {
        response.sendRedirect("login");
    }
%>
<!-- ============================================================== -->
<!-- main wrapper -->
<!-- ============================================================== -->
<div class="dashboard-main-wrapper">
    <!-- ============================================================== -->
    <!-- navbar -->
    <!-- ============================================================== -->
    <div class="dashboard-header">
        <nav class="navbar navbar-expand-lg bg-white fixed-top">
            <a class="navbar-brand" href="admin">ADMIN</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-right-top">
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link" href="<c:url value='/home' />">Home</a>
                    </li>
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Administrator</a>
                        <div class="dropdown-menu dropdown-menu-right nav-user-dropdown"
                             aria-labelledby="navbarDropdownMenuLink2">
                            <!--<div class="nav-user-info">
                                <h5 class="mb-0 text-white nav-user-name">
                                    John Abraham</h5>
                            </div>-->
                            <a class="dropdown-item" href="logout"><i class="fas fa-power-off mr-2"></i>Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- ============================================================== -->
    <!-- end navbar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- left sidebar -->
    <!-- ============================================================== -->
    <div class="nav-left-sidebar sidebar-dark">
        <div class="menu-list">
            <nav class="navbar navbar-expand-lg navbar-light">
                <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav flex-column">
                        <li class="nav-divider">
                            Dashboard
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="createAds">Manage Ads</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loadPost">Manage Post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="loadAccount">Manage Account</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- end left sidebar -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- wrapper  -->
    <!-- ============================================================== -->
    <div class="dashboard-wrapper">
        <div class="container-fluid dashboard-content">
            <div class="dashboard-short-list">
                <!-- ============================================================== -->
                <!-- striped table -->
                <!-- ============================================================== -->
                <div class="col-sm-12">
                    <div class="card">
                        <h5 class="card-header">Post List</h5>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">User</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Picture</th>
                                    <th scope="col">Status</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="post" items="${postLists}">
                                    <tr>
                                        <td scope="row"><c:out value="${post.postId}"/></td>
                                        <td><c:out value="${post.user.username}"/></td>
                                        <td><c:out value="${post.description}"/></td>
                                        <td><img src="<c:url value='/images/post/${post.postPic}' />" alt="" height="100px" width="100px"></td>
                                        <td><c:out value="${post.status? 'Active' : 'Inactive'}"/></td>
                                        <form action="managePost" method="post">
                                            <input type="hidden" value="${post.postId}" name="postId">
                                            <td class="btn-group ml-auto">
                                                <c:if test="${post.status}">
                                                    <button type="submit" class="btn btn-outline-success" disabled>Enable</button>
                                                    <button type="submit" class="btn btn-outline-danger">Disable</button>
                                                </c:if>
                                                <c:if test="${!post.status}">
                                                    <button type="submit" class="btn btn-outline-success">Enable</button>
                                                    <button type="submit" class="btn btn-outline-danger" disabled>Disable</button>
                                                </c:if>
                                            </td>
                                        </form>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- ============================================================== -->
                <!-- end striped table -->
                <!-- ============================================================== -->
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- footer -->
        <!-- ============================================================== -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        Copyright © 2019 Concept. All rights reserved.
                        <!--Dashboard by <a href="https://colorlib.com/wp/">Colorlib</a>.-->
                    </div>
                    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                        <div class="text-md-right footer-links d-none d-sm-block">
                            <a href="javascript: void(0);">About</a>
                            <a href="javascript: void(0);">Support</a>
                            <a href="javascript: void(0);">Contact Us</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- end footer -->
        <!-- ============================================================== -->
    </div>
</div>
<!-- ============================================================== -->
<!-- end main wrapper -->
<!-- ============================================================== -->
<!-- Optional JavaScript -->
<!-- Optional JavaScript -->
<jsp:include page="../layout/footer.jsp"/>

</body>

</html>
