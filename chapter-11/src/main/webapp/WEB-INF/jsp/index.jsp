<%--
  Created by IntelliJ IDEA.
  User: 50536
  Date: 3/14/2018
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my JSP page</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="提交上传">
</form>
<br>
<form action="/uploads" method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="file"><br>
    文件2: <input type="file" name="file"><br>
    文件3: <input type="file" name="file"><br>
    <input type="submit" value="上传多个文件">
</form>

</body>
</html>
