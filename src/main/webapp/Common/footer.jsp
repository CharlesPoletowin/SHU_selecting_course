<%--
  Created by IntelliJ IDEA.
  User: PoleToWin
  Date: 2019/4/22
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<style type="text/css">
    html{height:100%;}
    body{min-height:100%;margin:0;padding:0;position:relative;}

    .header{position:absolute;width:100%;height:150px;}
    .main{padding-bottom:100px;background-color: #bdb76b;}/* main的padding-bottom值要等于或大于footer的height值 */
    .footer{position:absolute;bottom:0;width:100%;height:150px;background-color: #ffffff;}
</style>
<body>
<!-- 关于 -->
<div class="footer">
<div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                <h4 class="modal-title" id="modal-label">开发者详情</h4>
            </div>
            <div class="modal-body">
                <p>	 这是2019年Spring 数据库项目 </p>
                <p>  <a href="https://github.com/CharlesPoletowin"> 个人github  </a> </p>
                <p>  联系我 1409985968@qq.com</p>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">了解了</button>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
