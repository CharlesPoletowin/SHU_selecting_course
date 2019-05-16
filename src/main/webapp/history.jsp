<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/5/2
  Time: 21:32
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
                <li id="Profile"><a href="#">资料总览</a></li>
                <li id="Course"><a href="#">选课</a></li>
                <li id="DeleteCourse"><a href="#">退课</a></li>
                <li class="active" id="History"><a href="#">历史课程 <span class="sr-only">(current)</span></a></li>
                <li><a href="/Complete">学分完成情况</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">历史课程</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th style="text-align: center">#</th>
                        <th style="text-align: center">学期</th>
                        <th style="text-align: center">课程号</th>
                        <th style="text-align: center">老师</th>
                        <th style="text-align: center">平时成绩</th>
                        <th style="text-align: center">考试成绩</th>
                        <th style="text-align: center">总评成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${historyList}" varStatus="status" var="item">
                        <c:if test="${item.xq != '2018-2019春季'}">
                            <tr>
                                <td></td>
                                <td style="text-align: center">${item.xq}</td>
                                <td style="text-align: center">${item.kh}</td>
                                <td style="text-align: center">${item.gh}</td>
                                <td style="text-align: center">${item.pscj}</td>
                                <td style="text-align: center">${item.kscj}</td>
                                <td style="text-align: center">${item.zpcj}</td>
                            </tr>
                        </c:if>
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
        location.href="/course.jsp"
    });
    $('#History').click(function () {
        location.href="/history.jsp"
    });
</script>

</body>
</html>
