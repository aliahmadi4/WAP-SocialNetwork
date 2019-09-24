<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/22/2019
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<h1>Create a new post!</h1>
<form action="createpost" method="post">
   <p> Post Title   : <input type="text" name="title"> </p>
    <p>Description : <textarea name="description"></textarea></p>
    <p><input type="file" name="fileupload" value="fileupload" id="fileupload"></p>
    <input type="submit" value="submit">
</form>
</body>
</html>
