<%--
  Created by IntelliJ IDEA.
  User: tungnd
  Date: 9/24/19
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">


<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Manage Account</title>
    <!-- Bootstrap CSS -->
    <jsp:include page="../layout/head.jsp"/>
    <%--<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/libs/css/style.css">
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href="assets/vendor/fonts/circular-std/CircularStd-Book.woff">
    <link rel="stylesheet" href="assets/vendor/fonts/circular-std/CircularStd-Medium.woff">--%>
</head>

<body>
<!-- ============================================================== -->
<!-- main wrapper -->
<!-- ============================================================== -->
<div class="dashboard-main-wrapper">
    <!-- ============================================================== -->
    <!-- navbar -->
    <!-- ============================================================== -->
    <div class="dashboard-header">
        <nav class="navbar navbar-expand-lg bg-white fixed-top">
            <a class="navbar-brand">ADMIN</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-right-top">
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">Administrator</a>
                        <div class="dropdown-menu dropdown-menu-right nav-user-dropdown"
                             aria-labelledby="navbarDropdownMenuLink2">
                            <!--<div class="nav-user-info">
                                <h5 class="mb-0 text-white nav-user-name">
                                    John Abraham</h5>
                            </div>-->
                            <a class="dropdown-item" href="#"><i class="fas fa-power-off mr-2"></i>Logout</a>
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
                            <a class="nav-link" href="createAds.jsp">Manage Ads</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="managePost.jsp">Manage Post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="manageAccount.jsp">Manage Account</a>
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
                        <h5 class="card-header">Account List</h5>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Country</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>jthorn</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>test@gmail.com</td>
                                    <td>United States</td>
                                    <td>Male</td>
                                    <td class="btn-group ml-auto">
                                        <button type="button" class="btn btn-outline-success" disabled>Enable</button>
                                    </td>
                                    <td class="btn-group ml-auto">
                                        <button type="button" class="btn btn-outline-danger">Disable</button>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>lBird</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>test@gmail.com</td>
                                    <td>United States</td>
                                    <td>Female</td>
                                    <td class="btn-group ml-auto">
                                        <button type="button" class="btn btn-outline-success" disabled>Enable</button>
                                    </td>
                                    <td class="btn-group ml-auto">
                                        <button type="button" class="btn btn-outline-danger">Disable</button>
                                    </td>
                                </tr>
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
<script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
<script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
<script src="assets/libs/js/main-js.js"></script>
<%--<script src="assets/vendor/shortable-nestable/Sortable.min.js"></script>
<script src="assets/vendor/shortable-nestable/sort-nest.js"></script>
<script src="assets/vendor/shortable-nestable/jquery.nestable.js"></script>--%>

</body>

</html>
