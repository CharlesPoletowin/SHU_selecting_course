<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/4/22
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.lang.*"%>
<%
  System.gc();
%>
<html>
  <head>
    <title>SHU数据库选课系统</title>
    <!-- Bootstrap -->
    <link href="./lib/css/bootstrap.min.css" rel="stylesheet">
    <link href="./lib/css/style.css" rel="stylesheet">
    <link href="./lib/css/signin.css" rel="stylesheet">
  </head>
  <style type="text/css">
    .div1{
      /*background-color: blue;*/
      position:relative;
      height:300px;
      top:160px;
      margin:0 auto;
    }
    .div2{
      background-color: orangered;
    }
  </style>
  <body>
  <%
    session.invalidate();
  %>

  <%@include file="./Common/headbar.jsp"%>
  <div class="div1">
  <div class="container">
    <div class="text" style=" text-align:center;">
    <form class="form-signin" action="Login">
      <h2 class="form-signin-heading">登录界面</h2>
      <label for="inputID" class="sr-only">用户名</label>
      <input type="text" id="inputID" class="form-control" placeholder="请输入用户名" required autofocus id="username" name="username">
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required id="password" name="password">
      <div class="checkbox">
      </div>
      <div>
        ${alert}
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    </div>
  </div>
  </div><!-- /container -->


  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="./lib/js/bootstrap.min.js"></script>

  <%@include file="./Common/footer.jsp"%>


  </body>
</html>
