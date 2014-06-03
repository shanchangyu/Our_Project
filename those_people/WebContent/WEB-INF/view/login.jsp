<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <link rel="stylesheet" type="text/css" href="../css/login.css"> 
    <link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css"> 
    <!-[if IE]>  
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-> </head>
<title>登录</title>
</head>
<body id="common_body">
   <!--导航条开始-->
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">那些人</a>
        </div>
     </div>
    </div>
   <!-- 导航条结束 -->
 <div class="container">
    <div class="row">
       <div class="col-md-2"></div>
        <div class="col-md-8">
        <form class="form-signin" role="form">
        <h2 class="form-signin-heading">请登录</h2>
        <input type="text" class="form-control" placeholder="注册邮箱" required autofocus>
        <input type="password" class="form-control" placeholder="密码" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me">记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <BR/>
        <label class="forgetPassWord">
        <a href="/those_people/user/forgetPassword.do">忘记密码？</a>
        </label>
       </form>
        </div>
        <div class="col-md-2"></div>
    </div>
  </div>
</body>
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</html>