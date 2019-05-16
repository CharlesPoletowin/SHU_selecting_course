<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/5/2
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./Common/JarLib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>SHU数据库选课系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./lib/css/dasboard.css" rel="stylesheet">
</head>
<c:if test="${teacher == null}">
    <c:redirect url="index.jsp" />
</c:if>
<%
    session.removeAttribute("admin");
    session.removeAttribute("student");
%>
<%@include file="./Common/headbar.jsp"%>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" id="Profile"><a href="#">学生成绩管理<span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">教师界面</h1>
            <h3>你好, ${teacher.xm}</h3>
            <h2 class="sub-header">上课记录</h2>
            <%--<div class="table-responsive">--%>
                <%--<table class="table table-striped">--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                        <%--<th>#</th>--%>
                        <%--<th>学期</th>--%>
                        <%--<th>课程号</th>--%>
                        <%--<th>学生</th>--%>
                        <%--<th>平时成绩</th>--%>
                        <%--<th>考试成绩</th>--%>
                        <%--<th>总评成绩</th>--%>
                        <%--<th>操作</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>

                    <%--<tbody>--%>
                    <%--<c:forEach items="${electiveList}" varStatus="status" var="item">--%>
                        <%--<tr>--%>
                                <%--<th></th>--%>
                                <%--<th name="${status.index}xq">${item.xq}</th>--%>
                                <%--<th name="kh">${item.kh}</th>--%>
                                <%--<th name="xh">${item.xh}</th>--%>
                                <%--<th><input type="text" name="pscj" value="${item.pscj}" style="width:20%"/></th>--%>
                                <%--<th><input type="text" name="kscj" value="${item.kscj}" style="width:20%"/></th>--%>
                                <%--<th>${item.zpcj}</th>--%>
                                <%--<th><a href="/teacher.jsp?idx=${status.index}">修改成绩</a></th>--%>
                        <%--</tr>--%>
                    <%--</c:forEach>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            <%--</div>--%>
<form class="table-responsive" action="UpdateScores">
平时成绩百分比0~1.0<input type="text" name="Percentage"  placeholder="0<x<1"/>
<br/>
    <div class="table table-striped table-hover table-bordered">
    <input type="text"  name="count" readonly="readonly" style="width:15px" value="${electiveList.size()}"/>
    <input type="text" value="学期" readonly="readonly" />
    <input type="text" value="课程号" readonly="readonly" />
    <input type="text"  readonly="readonly" value="学生学号"/>
    <input type="text"  readonly="readonly" value="平时成绩"/>
    <input type="text"  readonly="readonly" value="考试成绩"/>
    <a>总评成绩</a>
    </div>
<c:forEach items="${electiveList}" varStatus="status" var="item">
    <div class="table-responsive">
    <input type="text" readonly="readonly" style="width:15px" value="${status.index+1}"/>
    <input type="text" name="${status.index}xq" value="${item.xq}" readonly="readonly" />
    <input type="text" name="${status.index}kh" value="${item.kh}" readonly="readonly"/>
    <input type="text" name="${status.index}xh" readonly="readonly" value="${item.xh}"/>
    <input type="text" name="${status.index}pscj" value="${item.pscj}" />
    <input type="text" name="${status.index}kscj" value="${item.kscj}"/>
    <a>${item.zpcj}</a>
    </div>
</c:forEach>
<button type="submit" >提交</button>
</form>


            <%-- ↓↓成绩修改↓↓ --%>
            <c:if test="${param.get('idx') != null}">
                <h2 class="sub-header">成绩修改</h2>
                <form class="form-horizontal" role="form" action="Update" method="get">
                    <c:forEach items="${electiveList}" varStatus="status" var="item" begin="${param.idx}" end="${param.idx}">
                        <div class="form-group">
                            <label for="xq" class="col-sm-2 control-label">学期</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="xq" id="xq" value="${item.xq}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="kh" class="col-sm-2 control-label">课程号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="kh" id="kh" value="${item.kh}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="xh" class="col-sm-2 control-label">学生号</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="xh" id="xh" value="${item.xh}" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pscj" class="col-sm-2 control-label">平时成绩</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="pscj" id="pscj" value="${item.pscj}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="kscj" class="col-sm-2 control-label">考试成绩</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="kscj" id="kscj" value="${item.kscj}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="Percentage" class="col-sm-2 control-label">平时成绩占比</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="Percentage" id="Percentage" placeholder="请输入小数,如: 0.5" >
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </c:forEach>

                </form>
            </c:if>
            <%-- ↑↑成绩修改↑↑ --%>
            <c:if test="${param.get('idx') == null}">
                <h3>${updateStat}</h3>
            </c:if>
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
        location.href="/teacher.jsp"
    });
</script>
<body>

</body>
</html>
