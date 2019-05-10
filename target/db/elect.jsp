<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/5/2
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./Common/JarLib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SHU数据库选课系统</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./lib/css/dasboard.css" rel="stylesheet">
</head>
<body>
<%
    session.removeAttribute("stat");
%>
<c:if test="${student == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%@include file="./Common/headbar.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li id="Profile"><a href="#">资料总览</a></li>
                <li class="active" id="Elective"><a href="#">选课界面 <span class="sr-only">(current)</span></a></li>
                <li id="Course"><a href="#">课程一览</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">选课界面</h1>
            <h3> ${student.xm}</h3>
            <form class="form-horizontal" role="form" action="Elect" method="get">
                <div class="form-group">
                    <label for="kh" class="col-sm-2 control-label">课程号</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="kh" id="kh" placeholder="请输入课程号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gh" class="col-sm-2 control-label">教师号</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="gh" id="gh" placeholder="请输入教师号">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
