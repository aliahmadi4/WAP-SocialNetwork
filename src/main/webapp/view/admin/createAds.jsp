<%--
  Created by IntelliJ IDEA.
  User: tungnd
  Date: 9/24/19
  Time: 00:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Create Ads</title>
    <!-- Bootstrap CSS -->
    <jsp:include page="../layout/head.jsp"/>
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
                            <a class="nav-link" href="createAds">Manage Ads</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="managePost">Manage Post</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="manageAccount">Manage Account</a>
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
        <div class="container-fluid  dashboard-content">
            <div class="row">
                <!-- ============================================================== -->
                <!-- horizontal form -->
                <!-- ============================================================== -->
                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                    <%--<form action="createAds" method="post">--%>
                    <div class="card">
                        <h5 class="card-header">Create Ads Form</h5>
                        <div class="card-body">
                            <form id="form" data-parsley-validate="" novalidate="" action="createAds" method="post">
                                <div class="form-group row">
                                    <label for="inputTitle"
                                           class="col-3 col-lg-2 col-form-label text-right">Title</label>
                                    <div class="col-9 col-lg-10">
                                        <input id="inputTitle" type="text" name="adsTitle" required=""
                                               data-parsley-type="text"
                                               placeholder="Please input the title" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputImage" class="col-3 col-lg-2 col-form-label text-right">Image
                                        URL</label>
                                    <div class="col-9 col-lg-10">
                                        <input id="inputImage" type="url" name="imageURL" required=""
                                               data-parsley-type="url"
                                               placeholder="Please input the URL of image" class="form-control">
                                    </div>
                                </div>
                                <div class="col-sm-5.5 pl-0">
                                    <p class="text-right">
                                        <button type="submit" class="btn btn-space btn-primary">Submit</button>
                                        <!--<button class="btn btn-space btn-secondary">Cancel</button>-->
                                    </p>
                                </div>
                            </form>
                        </div>
                    </div>
                    <%--</form>--%>
                </div>
                <!-- ============================================================== -->
                <!-- end horizontal form -->
                <!-- ============================================================== -->

                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12 col-lg-6 col-md-6 col-sm-12 col-12">
                    <div>
                        <h3 class="card-title" style="color: #b21f2d">Preview Ads</h3>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title">${adsTitle}</h3>
                        </div>
                        <img class="img-fluid" src="${image}" alt="Ads Image"/>
                    </div>
                </div>
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
<jsp:include page="../layout/footer.jsp"/>

<%--<script>
    $('#form').parsley();
</script>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>--%>
</body>

</html>
