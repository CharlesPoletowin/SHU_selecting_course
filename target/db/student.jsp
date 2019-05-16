<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/5/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.*,com.shu.db.entity.*" %>
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
<c:if test="${student == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%
    session.removeAttribute("admin");
    session.removeAttribute("teacher");
%>

<%@include file="./Common/headbar.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" id="Profile"><a href="#">资料总览<span class="sr-only">(current)</span></a></li>
                <li id="Course"><a href="#">选课</a></li>
                <li id="DeleteCourse"><a href="#">退课</a></li>
                <li id="History"><a href="#">历史课程</a></li>
                <li><a href="/Complete">学分完成情况</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">学生界面</h1>
            <h3>你好, ${student.xm}</h3>
            <form action="Complete" method="get"><button type="submit" class="btn btn-default">查询毕业情况</button>
            <h2 class="sub-header">已选课程</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th style="text-align: center">编号</th>
                        <th style="text-align: center">学期</th>
                        <th style="text-align: center">课程号</th>
                        <th style="text-align: center">教师</th>
                        <th style="text-align: center">平时成绩</th>
                        <th style="text-align: center">考试成绩</th>
                        <th style="text-align: center">总评成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${MapElectiveList}" varStatus="status" var="item">
                        <tr>
                            <td style="text-align: center">${item.mapper}</td>
                            <td style="text-align: center">${item.elective.xq}</td>
                            <td style="text-align: center">${item.elective.kh}</td>
                            <td style="text-align: center">${item.elective.gh}</td>
                            <td style="text-align: center">${item.elective.pscj}</td>
                            <td style="text-align: center">${item.elective.kscj}</td>
                            <td style="text-align: center">${item.elective.zpcj}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <h3>${stat}</h3>
            <h2 class="sub-header">课程表</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th style="text-align: center"></th>
                        <th style="text-align: center">周一</th>
                        <th style="text-align: center">周二</th>
                        <th style="text-align: center">周三</th>
                        <th style="text-align: center">周四</th>
                        <th style="text-align: center">周五</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${CourseTable}" var="item" varStatus="status">
                        <tr>
                            <td style="text-align: center">第${item.getRowIndex()}节</td>

                            <c:forEach items="${item.tablerow}" varStatus="substatus" var="subitem">
                                <td style="text-align: center">${subitem}</td>
                            </c:forEach>
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
        location.href="/student.jsp"
    });
    $('#Course').click(function () {
        $.get('${pageContext.request.contextPath}' + '/course',function(data, status) {
            location.href="/course.jsp"
        });
    });
    $('#History').click(function () {
        location.href="/history.jsp"
    });
</script>
</body>
</html>
