<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<%--<style>--%>
    <%--video{--%>
        <%--position: fixed;--%>
        <%--right:0;--%>
        <%--top:100px;--%>
        <%--width: 100%;--%>
        <%--height: auto;--%>
        <%--z-index: -9999;--%>
        <%--text-align: center;--%>
    <%--}--%>
<%--</style>--%>
<body class="gray-bg">
<%--<video id="v1" autoplay muted loop style="width: 100%">--%>
    <%--<source  src="${pageContext.request.contextPath}/video/douyin.mp4">--%>
<%--</video>--%>


<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div style="top:200px">
            <img src="${pageContext.request.contextPath}/img/douyinlogo.png" width="150">
            <!--    <h1 class="logo-name">h</h1> -->

        </div>
        <h3>${msg}</h3>
        <form class="m-t" role="form"  action="${pageContext.request.contextPath}/LoginController/login">
            <div class="form-group">
                <input type="text" name="login_user_name" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="login_pass_word" class="form-control" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
            </p>

        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>




</body>

</html>
