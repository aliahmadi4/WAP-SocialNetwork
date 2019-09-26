<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/23/2019
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<!-- Mirrored from gambolthemes.net/workwise-new/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 22 Sep 2019 14:24:44 GMT -->
<head>
    <jsp:include page="../layout/head.jsp"/>
    <script type="text/javascript" src="<c:url value='/js/scroll.js' />"></script>
</head>

<body>

<div class="wrapper">

    <jsp:include page="../layout/navbar.jsp"/>

    <main>
        <div class="main-section">
            <div class="container">
                <div class="main-section-data">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 pd-left-none no-pd">
                            <div class="main-left-sidebar no-margin">
                                <div class="user-data full-width">
                                    <div class="user-profile">
                                        <div class="username-dt">
                                            <div class="usr-pic">
                                                <img src="<c:url value='/images/profile/${loginedUser.profilePic.length()>4 ? loginedUser.profilePic : "user.jpg"}' />"
                                                     alt="" height="120px" width="120px"/>
                                            </div>
                                        </div><!--username-dt end-->
                                        <div class="user-specs">
                                            <h3>${loginedUser.firstName} ${loginedUser.lastName}</h3>
                                            <span>${loginedUser.description}</span>
                                        </div>
                                    </div><!--user-profile end-->
                                    <ul class="user-fw-status">
                                        <%--<li>
                                            <h4>Following</h4>
                                            <span>34</span>
                                        </li>
                                        <li>
                                            <h4>Followers</h4>
                                            <span>155</span>
                                        </li>--%>
                                        <li>
                                            <a href="<c:url value='/profile' />" title="">View Profile</a>
                                        </li>
                                    </ul>
                                </div><!--user-data end-->
                                <div class="suggestions full-width">
                                    <div class="sd-title">
                                        <h3>Suggestions</h3>
                                        <%--                                        <i class="la la-ellipsis-v"></i>--%>
                                    </div><!--sd-title end-->
                                    <div id="follow" class="suggestions-list">

                                        <c:forEach var="u" items="${userList}">
                                            <div class="suggestion-usd">
                                                <img src="<c:url value='/images/profile/${u.profilePic.length()>4 ? u.profilePic : "user.jpg"}'/>"
                                                     alt=""
                                                     width="45px" height="45px">
                                                <div class="sgt-text">
                                                    <h4>${u.firstName}</h4>
                                                    <span>${u.lastName}</span>
                                                </div>
                                                <span data-id="${u.userId}"><i class="la la-plus"></i></span>

                                            </div>
                                        </c:forEach>

                                        <%--                                        <div class="view-more">--%>
                                        <%--                                            <a href="#" title="">View More</a>--%>
                                        <%--                                        </div>--%>
                                    </div><!--suggestions-list end-->
                                </div><!--suggestions end-->

                            </div><!--main-left-sidebar end-->
                        </div>
                        <div class="col-lg-6 col-md-8 no-pd">
                            <div class="main-ws-sec">
                                <div class="post-topbar">
                                    <div class="user-picy">
                                        <img src="<c:url value='/images/profile/${loginedUser.profilePic.length()>4 ? loginedUser.profilePic : "user.jpg"}'/>"
                                             alt=""
                                             height="50px" width="50px">
                                    </div>
                                    <div class="post-st">
                                        <ul>
                                            <li><a class="post_project" href="#" title="">Post</a></li>

                                        </ul>
                                    </div><!--post-st end-->
                                </div><!--post-topbar end-->
                                <div class="posts-section">

                                    <c:forEach var="i" items="${posts}">
                                        <div class="post-bar">
                                            <div class="post_topbar">
                                                <div class="usy-dt">
                                                    <img src="<c:url value='/images/profile/${i.user.profilePic.length()>4 ? i.user.profilePic : "user.jpg"}'/>"
                                                         alt="" width="45px" height="45px">
                                                    <div class="usy-name">
                                                        <a href="<c:url value='/profile?userId=${i.user.userId}' />">
                                                            <h3>${i.user.firstName} ${i.user.lastName}</h3></a>
                                                        <span><img src="../../images/clock.png"
                                                                   alt="">${i.user.description}</span>
                                                    </div>
                                                </div>
                                                    <%--                                                <div class="ed-opts">--%>
                                                    <%--                                                    <a href="#" title="" class="ed-opts-open"><i--%>
                                                    <%--                                                            class="la la-ellipsis-v"></i></a>--%>
                                                    <%--                                                    <ul class="ed-options">--%>
                                                    <%--                                                        <li><a href="#" title="">Delete</a></li>--%>
                                                    <%--                                                    </ul>--%>
                                                    <%--                                                </div>--%>
                                            </div>
                                            <div class="epi-sec">

                                                &nbsp
                                            </div>
                                            <div class="job_descp">

                                                <p>${i.description}</p>

                                            </div>
                                            <c:if test="${i.postPic.length() >3}">
                                                <div class="job_descp">
                                                    <img src="<c:url value='/images/post/${i.postPic}' />"/>
                                                </div>
                                            </c:if>

                                        </div>
                                        <!--post-bar end-->
                                    </c:forEach>


                                    <div class="process-comm">
                                        <div class="spinner">
                                            <div class="bounce1"></div>
                                            <div class="bounce2"></div>
                                            <div class="bounce3"></div>
                                        </div>
                                    </div><!--process-comm end-->
                                </div><!--posts-section end-->
                            </div><!--main-ws-sec end-->
                        </div>
                        <div class="col-lg-3 pd-right-none no-pd">
                            <div class="right-sidebar">

                                <div class="widget widget-ads">
                                    <div>${ads.adsTitle}</div>
                                    <img src="${ads.imageURL}"/>
                                </div><!--widget-jobs end-->
                                <div class="widget widget-weather">
                                    <a style="width: 200px; margin-left: auto; margin-right: auto"
                                       class="weatherwidget-io" href="https://forecast7.com/en/41d01n91d96/fairfield/"
                                       data-label_1="FAIRFIELD"
                                       data-label_2="WEATHER" data-font="Roboto Slab" data-icons="Climacons Animated"
                                       data-theme="clear">FAIRFIELD
                                        WEATHER</a>
                                </div><!--widget-about end-->
                            </div><!--right-sidebar end-->
                        </div>
                    </div>
                </div><!-- main-section-data end-->
            </div>
        </div>
    </main>


    <div class="post-popup pst-pj">
        <div class="post-project">
            <h3>New Post</h3>
            <div class="post-project-fields">
                <form method="post" action="<c:url value="/createpost" />" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-12">
                            <textarea name="description" placeholder="Description"></textarea>
                        </div>
                        <div class="col-lg-12">
                            <ul>
                                <li>
                                    <button class="active" type="submit" value="post">Post</button>
                                </li>
                                <div class="add-pic-box">

                                    <div class="row no-gutters">
                                        <div class="col-lg-12 col-sm-12">
                                            <input type="file" name="file" id="file">
                                            <label for="file">Select Image</label>
                                        </div>
                                    </div>

                                </div>
                            </ul>
                        </div>
                    </div>
                </form>
            </div><!--post-project-fields end-->
            <a href="#" title=""><i class="la la-times-circle-o"></i></a>
        </div><!--post-project end-->
    </div><!--post-project-popup end-->

    <div class="post-popup job_post">
        <div class="post-project">
            <h3>Post a job</h3>
            <div class="post-project-fields">
                <form>
                    <div class="row">
                        <div class="col-lg-12">
                            <input type="text" name="title" placeholder="Title">
                        </div>
                        <div class="col-lg-12">
                            <div class="inp-field">
                                <select>
                                    <option>Category</option>
                                    <option>Category 1</option>
                                    <option>Category 2</option>
                                    <option>Category 3</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <input type="text" name="skills" placeholder="Skills">
                        </div>
                        <div class="col-lg-6">
                            <div class="price-br">
                                <input type="text" name="price1" placeholder="Price">
                                <i class="la la-dollar"></i>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="inp-field">
                                <select>
                                    <option>Full Time</option>
                                    <option>Half time</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <textarea name="description" placeholder="Description"></textarea>
                        </div>
                        <div class="col-lg-12">
                            <ul>
                                <li>
                                    <button class="active" type="submit" value="post">Post</button>
                                </li>
                                <li><a href="#" title="">Cancel</a></li>
                            </ul>
                        </div>
                    </div>
                </form>
            </div><!--post-project-fields end-->
            <a href="#" title=""><i class="la la-times-circle-o"></i></a>
        </div><!--post-project end-->
    </div><!--post-project-popup end-->


</div><!--theme-layout end-->


<%--<script type="text/javascript" src="../../js/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/popper.js"></script>--%>
<%--<script type="text/javascript" src="../../js/bootstrap.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/jquery.mCustomScrollbar.js"></script>--%>
<%--<script type="text/javascript" src="../../lib/slick/slick.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/scrollbar.js"></script>--%>
<%--<script type="text/javascript" src="../../js/script.js"></script>--%>

<jsp:include page="../layout/footerScript.jsp"/>
<script>
    !function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (!d.getElementById(id)) {
            js = d.createElement(s);
            js.id = id;
            js.src = 'https://weatherwidget.io/js/widget.min.js';
            fjs.parentNode.insertBefore(js, fjs);
        }
    }(document, 'script', 'weatherwidget-io-js');
</script>
</body>

<!-- Mirrored from gambolthemes.net/workwise-new/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 22 Sep 2019 14:24:55 GMT -->
</html>
