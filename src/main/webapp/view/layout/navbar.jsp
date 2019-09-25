   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <header>
        <div class="container">
        <div class="header-data">
        <div class="logo">
        <a href="../../index.html" title=""><img src="<c:url value='/images/logo.png' />" alt="userPic"></a>
        </div><!--logo end-->
        <div class="search-bar">
        <form>
        <input type="text" name="search" placeholder="Search...">
        <button type="submit"><i class="la la-search"></i></button>
        </form>
        </div><!--search-bar end-->
        <nav>
        <ul>
        <li>
        <a href="home" title="">
        <span><img src="../../images/icon1.png" alt=""></span>
        Home
        </a>
        </li>

        <li>
        <a href="<c:url value='/profile'/>" title="">
        <span><img src="../../images/icon4.png" alt=""></span>
        Profiles
        </a>
        </li>

        <li>
        <a href="#" title="">
        <span><img src="../../images/icon5.png" alt=""></span>
        Following
        </a>
        </li>



        </ul>
        </nav><!--nav end-->
        <div class="menu-btn">
        <a href="#" title=""><i class="fa fa-bars"></i></a>
        </div><!--menu-btn end-->
        <div class="user-account">
        <div class="user-info">
        <img src="<c:url value='/images/profile/${loginedUser.profilePic}' />" alt="" height="40px" width="40px">
        <a href="#" title="">${loginedUser.firstName}</a>
        <i class="la la-sort-down"></i>
        </div>
        <div class="user-account-settingss">


        <h3>Setting</h3>
        <ul class="us-links">
        <li><a href="../../profile-account-setting.html" title="">Account Setting</a></li>
        <li><a href="#" title="">Privacy</a></li>
        <li><a href="#" title="">Faqs</a></li>
        <li><a href="#" title="">Terms & Conditions</a></li>
        </ul>
        <h3 class="tc"><a href="logout" title="">Logout</a></h3>
        </div><!--user-account-settingss end-->
        </div>
        </div><!--header-data end-->
        </div>
        </header><!--header end-->
