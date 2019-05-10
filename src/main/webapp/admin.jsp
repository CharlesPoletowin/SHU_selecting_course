<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/5/1
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*,com.shu.db.entity.*" %>
<%@ page import="java.lang.*"%>
<%
    System.gc();
%>
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
<c:if test="${admin == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%
    session.removeAttribute("student");
    session.removeAttribute("teacher");
%>
<%@include file="./Common/headbar.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" id="Profile"><a href="#">查询总览 <span class="sr-only">(current)</span></a></li>
                <li id="Query"><a href="#">查课界面</a> </li>
                <%--<li id="Course"><a href="#">加课界面</a></li>--%>
                <%--<li id="Open"><a href="#">开课界面</a></li>--%>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">管理员界面</h1>
            <h3>你好, 管理员</h3>
            <h2 class="sub-header">学生名单</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>密码</th>
                        <th>生日</th>
                        <th>手机</th>
                        <th>城市</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentList}" varStatus="status" var="item">
                        <tr>
                            <td></td>
                            <td>${item.xh}</td>
                            <td>${item.xm}</td>
                            <td>${item.xb}</td>
                            <td>${item.pwd}</td>
                            <td>${item.csrq}</td>
                            <td>${item.sjhm}</td>
                            <td>${item.jg}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <h2 class="sub-header">教师名单</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>教师号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>密码</th>
                        <th>生日</th>
                        <th>职位</th>
                        <th>薪水</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${teacherList}" varStatus="status" var="item">
                        <tr>
                            <td></td>
                            <td>${item.gh}</td>
                            <td>${item.xm}</td>
                            <td>${item.xb}</td>
                            <td>${item.pwd}</td>
                            <td>${item.csrq}</td>
                            <td>${item.xl}</td>
                            <td>${item.jbgz}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <h2 class="sub-header">院系名单</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>院系号</th>
                        <th>院系名</th>
                        <th>地址</th>
                        <th>电话</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${departmentList}" varStatus="status" var="item">
                        <tr>
                            <td></td>
                            <td>${item.yxh}</td>
                            <td>${item.mc}</td>
                            <td>${item.dz}</td>
                            <td>${item.lxdh}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="./lib/js/holder.min.js"></script>
<script>
    $('#Profile').click(function () {
        location.href="/admin.jsp"
    });
    $('#Query').click(function () {
        $.get('${pageContext.request.contextPath}' + '/course',function(data, status) {
            location.href="/admincourse.jsp"
        });
    });
</script>
</body>
</html>
