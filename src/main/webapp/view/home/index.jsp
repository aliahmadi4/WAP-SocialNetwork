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
                                                <img src="<c:url value='/images/profile/${loginedUser.profilePic}' />" alt="" height="120px" width="120px"/>
                                            </div>
                                        </div><!--username-dt end-->
                                        <div class="user-specs">
                                            <h3>${loginedUser.firstName} ${loginedUser.lastName}</h3>
                                            <span>${loginedUser.description}</span>
                                        </div>
                                    </div><!--user-profile end-->
                                    <ul class="user-fw-status">
                                        <li>
                                            <h4>Following</h4>
                                            <span>34</span>
                                        </li>
                                        <li>
                                            <h4>Followers</h4>
                                            <span>155</span>
                                        </li>
                                        <li>
                                            <a href="../../my-profile.html" title="">View Profile</a>
                                        </li>
                                    </ul>
                                </div><!--user-data end-->
                                <div class="suggestions full-width">
                                    <div class="sd-title">
                                        <h3>Suggestions</h3>
                                        <i class="la la-ellipsis-v"></i>
                                    </div><!--sd-title end-->
                                    <div class="suggestions-list">
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s1.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Jessica William</h4>
                                                <span>Graphic Designer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s2.png" alt="">
                                            <div class="sgt-text">
                                                <h4>John Doe</h4>
                                                <span>PHP Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s3.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Poonam</h4>
                                                <span>Wordpress Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s4.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Bill Gates</h4>
                                                <span>C & C++ Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s5.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Jessica William</h4>
                                                <span>Graphic Designer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s6.png" alt="">
                                            <div class="sgt-text">
                                                <h4>John Doe</h4>
                                                <span>PHP Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="view-more">
                                            <a href="#" title="">View More</a>
                                        </div>
                                    </div><!--suggestions-list end-->
                                </div><!--suggestions end-->
                                <div class="tags-sec full-width">
                                    <ul>
                                        <li><a href="#" title="">Help Center</a></li>
                                        <li><a href="#" title="">About</a></li>
                                        <li><a href="#" title="">Privacy Policy</a></li>
                                        <li><a href="#" title="">Community Guidelines</a></li>
                                        <li><a href="#" title="">Cookies Policy</a></li>
                                        <li><a href="#" title="">Career</a></li>
                                        <li><a href="#" title="">Language</a></li>
                                        <li><a href="#" title="">Copyright Policy</a></li>
                                    </ul>
                                    <div class="cp-sec">
                                        <img src="../../images/logo2.png" alt="">
                                        <p><img src="../../images/cp.png" alt="">Copyright 2019</p>
                                    </div>
                                </div><!--tags-sec end-->
                            </div><!--main-left-sidebar end-->
                        </div>
                        <div class="col-lg-6 col-md-8 no-pd">
                            <div class="main-ws-sec">
                                <div class="post-topbar">
                                    <div class="user-picy">
                                        <img src="<c:url value='/images/profile/${loginedUser.profilePic}'/>" alt="" height="50px" width="50px">
                                    </div>
                                    <div class="post-st">
                                        <ul>
                                            <li><a class="post_project" href="#" title="">Post a Project</a></li>

                                        </ul>
                                    </div><!--post-st end-->
                                </div><!--post-topbar end-->
                                <div class="posts-section">

                                    <c:forEach var="i" items="${posts}">
                                        <div class="post-bar">
                                            <div class="post_topbar">
                                                <div class="usy-dt">
                                                    <img src="../../images/resources/us-pic.png" alt="">
                                                    <div class="usy-name">
                                                        <h3>John</h3>
                                                        <span><img src="../../images/clock.png" alt="">3 min ago</span>
                                                    </div>
                                                </div>
                                                <div class="ed-opts">
                                                    <a href="#" title="" class="ed-opts-open"><i
                                                            class="la la-ellipsis-v"></i></a>
                                                    <ul class="ed-options">
                                                        <li><a href="#" title="">Edit Post</a></li>
                                                        <li><a href="#" title="">Unsaved</a></li>
                                                        <li><a href="#" title="">Unbid</a></li>
                                                        <li><a href="#" title="">Close</a></li>
                                                        <li><a href="#" title="">Hide</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="epi-sec">

                                                &nbsp
                                            </div>
                                            <div class="job_descp">

                                                <p>${i.description}</p>

                                            </div>
                                            <c:if test="${i.postPic.length() >3}" >
                                                <div class="job_descp">
                                                    <img src="<c:url value='/images/post/${i.postPic}' />"/>
                                                </div>
                                            </c:if>
                                            <div class="job-status-bar">
                                                follow
                                            </div>
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
                                <div class="widget widget-about">
                                    <img src="../../images/wd-logo.png" alt="">
                                    <h3>Track Time on Workwise</h3>
                                    <span>Pay only for the Hours worked</span>
                                    <div class="sign_link">
                                        <h3><a href="../user/sign-in.html" title="">Sign up</a></h3>
                                        <a href="#" title="">Learn More</a>
                                    </div>
                                </div><!--widget-about end-->
                                <div class="widget widget-jobs">
                                    <div class="sd-title">
                                        <h3>Top Jobs</h3>
                                        <i class="la la-ellipsis-v"></i>
                                    </div>
                                    <div class="jobs-list">
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior Product Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior UI / UX Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Junior Seo Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior PHP Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior Developer Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                    </div><!--jobs-list end-->
                                </div><!--widget-jobs end-->
                                <div class="widget widget-jobs">
                                    <div class="sd-title">
                                        <h3>Most Viewed This Week</h3>
                                        <i class="la la-ellipsis-v"></i>
                                    </div>
                                    <div class="jobs-list">
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior Product Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Senior UI / UX Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                        <div class="job-info">
                                            <div class="job-details">
                                                <h3>Junior Seo Designer</h3>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit..</p>
                                            </div>
                                            <div class="hr-rate">
                                                <span>$25/hr</span>
                                            </div>
                                        </div><!--job-info end-->
                                    </div><!--jobs-list end-->
                                </div><!--widget-jobs end-->
                                <div class="widget suggestions full-width">
                                    <div class="sd-title">
                                        <h3>Most Viewed People</h3>
                                        <i class="la la-ellipsis-v"></i>
                                    </div><!--sd-title end-->
                                    <div class="suggestions-list">
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s1.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Jessica William</h4>
                                                <span>Graphic Designer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s2.png" alt="">
                                            <div class="sgt-text">
                                                <h4>John Doe</h4>
                                                <span>PHP Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s3.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Poonam</h4>
                                                <span>Wordpress Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s4.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Bill Gates</h4>
                                                <span>C &amp; C++ Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s5.png" alt="">
                                            <div class="sgt-text">
                                                <h4>Jessica William</h4>
                                                <span>Graphic Designer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="suggestion-usd">
                                            <img src="../../images/resources/s6.png" alt="">
                                            <div class="sgt-text">
                                                <h4>John Doe</h4>
                                                <span>PHP Developer</span>
                                            </div>
                                            <span><i class="la la-plus"></i></span>
                                        </div>
                                        <div class="view-more">
                                            <a href="#" title="">View More</a>
                                        </div>
                                    </div><!--suggestions-list end-->
                                </div>
                            </div><!--right-sidebar end-->
                        </div>
                    </div>
                </div><!-- main-section-data end-->
            </div>
        </div>
    </main>


    <div class="post-popup pst-pj">
        <div class="post-project">
            <h3>Post a project</h3>
            <div class="post-project-fields">
                <form method="post" action="<c:url value="/createpost" />" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-lg-12">
                            <textarea name="description" placeholder="Description"></textarea>
                        </div>
                        <div class="col-lg-12">
                            <ul>
                                <li><input type="file" name="file"></li>
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


    <div class="chatbox-list">
        <div class="chatbox">
            <div class="chat-mg">
                <a href="#" title=""><img src="../../images/resources/usr-img1.png" alt=""></a>
                <span>2</span>
            </div>
            <div class="conversation-box">
                <div class="con-title mg-3">
                    <div class="chat-user-info">
                        <img src="../../images/resources/us-img1.png" alt="">
                        <h3>John Doe <span class="status-info"></span></h3>
                    </div>
                    <div class="st-icons">
                        <a href="#" title=""><i class="la la-cog"></i></a>
                        <a href="#" title="" class="close-chat"><i class="la la-minus-square"></i></a>
                        <a href="#" title="" class="close-chat"><i class="la la-close"></i></a>
                    </div>
                </div>
                <div class="chat-hist mCustomScrollbar" data-mcs-theme="dark">
                    <div class="chat-msg">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum congue leo eget
                            malesuada. Vivamus suscipit tortor eget felis porttitor.</p>
                        <span>Sat, Aug 23, 1:10 PM</span>
                    </div>
                    <div class="date-nd">
                        <span>Sunday, August 24</span>
                    </div>
                    <div class="chat-msg st2">
                        <p>Cras ultricies ligula.</p>
                        <span>5 minutes ago</span>
                    </div>
                    <div class="chat-msg">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum congue leo eget
                            malesuada. Vivamus suscipit tortor eget felis porttitor.</p>
                        <span>Sat, Aug 23, 1:10 PM</span>
                    </div>
                </div><!--chat-list end-->
                <div class="typing-msg">
                    <form>
                        <textarea placeholder="Type a message here"></textarea>
                        <button type="submit"><i class="fa fa-send"></i></button>
                    </form>
                    <ul class="ft-options">
                        <li><a href="#" title=""><i class="la la-smile-o"></i></a></li>
                        <li><a href="#" title=""><i class="la la-camera"></i></a></li>
                        <li><a href="#" title=""><i class="fa fa-paperclip"></i></a></li>
                    </ul>
                </div><!--typing-msg end-->
            </div><!--chat-history end-->
        </div>
        <div class="chatbox">
            <div class="chat-mg">
                <a href="#" title=""><img src="../../images/resources/usr-img2.png" alt=""></a>
            </div>
            <div class="conversation-box">
                <div class="con-title mg-3">
                    <div class="chat-user-info">
                        <img src="../../images/resources/us-img1.png" alt="">
                        <h3>John Doe <span class="status-info"></span></h3>
                    </div>
                    <div class="st-icons">
                        <a href="#" title=""><i class="la la-cog"></i></a>
                        <a href="#" title="" class="close-chat"><i class="la la-minus-square"></i></a>
                        <a href="#" title="" class="close-chat"><i class="la la-close"></i></a>
                    </div>
                </div>
                <div class="chat-hist mCustomScrollbar" data-mcs-theme="dark">
                    <div class="chat-msg">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum congue leo eget
                            malesuada. Vivamus suscipit tortor eget felis porttitor.</p>
                        <span>Sat, Aug 23, 1:10 PM</span>
                    </div>
                    <div class="date-nd">
                        <span>Sunday, August 24</span>
                    </div>
                    <div class="chat-msg st2">
                        <p>Cras ultricies ligula.</p>
                        <span>5 minutes ago</span>
                    </div>
                    <div class="chat-msg">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec rutrum congue leo eget
                            malesuada. Vivamus suscipit tortor eget felis porttitor.</p>
                        <span>Sat, Aug 23, 1:10 PM</span>
                    </div>
                </div><!--chat-list end-->
                <div class="typing-msg">
                    <form>
                        <textarea placeholder="Type a message here"></textarea>
                        <button type="submit"><i class="fa fa-send"></i></button>
                    </form>
                    <ul class="ft-options">
                        <li><a href="#" title=""><i class="la la-smile-o"></i></a></li>
                        <li><a href="#" title=""><i class="la la-camera"></i></a></li>
                        <li><a href="#" title=""><i class="fa fa-paperclip"></i></a></li>
                    </ul>
                </div><!--typing-msg end-->
            </div><!--chat-history end-->
        </div>
        <div class="chatbox">
            <div class="chat-mg bx">
                <a href="#" title=""><img src="../../images/chat.png" alt=""></a>
                <span>2</span>
            </div>
            <div class="conversation-box">
                <div class="con-title">
                    <h3>Messages</h3>
                    <a href="#" title="" class="close-chat"><i class="la la-minus-square"></i></a>
                </div>
                <div class="chat-list">
                    <div class="conv-list active">
                        <div class="usrr-pic">
                            <img src="../../images/resources/usy1.png" alt="">
                            <span class="active-status activee"></span>
                        </div>
                        <div class="usy-info">
                            <h3>John Doe</h3>
                            <span>Lorem ipsum dolor <img src="../../images/smley.png" alt=""></span>
                        </div>
                        <div class="ct-time">
                            <span>1:55 PM</span>
                        </div>
                        <span class="msg-numbers">2</span>
                    </div>
                    <div class="conv-list">
                        <div class="usrr-pic">
                            <img src="../../images/resources/usy2.png" alt="">
                        </div>
                        <div class="usy-info">
                            <h3>John Doe</h3>
                            <span>Lorem ipsum dolor <img src="../../images/smley.png" alt=""></span>
                        </div>
                        <div class="ct-time">
                            <span>11:39 PM</span>
                        </div>
                    </div>
                    <div class="conv-list">
                        <div class="usrr-pic">
                            <img src="../../images/resources/usy3.png" alt="">
                        </div>
                        <div class="usy-info">
                            <h3>John Doe</h3>
                            <span>Lorem ipsum dolor <img src="../../images/smley.png" alt=""></span>
                        </div>
                        <div class="ct-time">
                            <span>0.28 AM</span>
                        </div>
                    </div>
                </div><!--chat-list end-->
            </div><!--conversation-box end-->
        </div>
    </div><!--chatbox-list end-->

</div><!--theme-layout end-->


<%--<script type="text/javascript" src="../../js/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/popper.js"></script>--%>
<%--<script type="text/javascript" src="../../js/bootstrap.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/jquery.mCustomScrollbar.js"></script>--%>
<%--<script type="text/javascript" src="../../lib/slick/slick.min.js"></script>--%>
<%--<script type="text/javascript" src="../../js/scrollbar.js"></script>--%>
<%--<script type="text/javascript" src="../../js/script.js"></script>--%>

<jsp:include page="../layout/footerScript.jsp"/>

</body>

<!-- Mirrored from gambolthemes.net/workwise-new/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 22 Sep 2019 14:24:55 GMT -->
</html>
