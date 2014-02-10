<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <link rel="stylesheet" type="text/css" href="../css/common_body.css">  
    <!-[if IE]>  
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-> </head>
<title>交友信息发布</title>
</head>
<jsp:include page="header.html"/>
<body id="common_body">
<div class="container">
    <div class="row">
      <div class="col-md-1"> </div>
      <div class="col-md-8">
   <div class="panel panel-default">
  <div class="panel-heading">
   <h3>发布交友信息</h3>  
  </div>
  <div class="panel-body">
    <div class="input-group input-group-lg">
  <span class="input-group-addon">标题</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<div class="input-group input-group-lg">
  <span class="input-group-addon">年龄</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<select class="form-control">
  <option>性别</option>
  <option>男</option>
  <option>女</option>
</select>
<br>
<h3><span class="label label-primary">自我描述（必填内容）</span></h3>
<textarea class="form-control" rows="10"></textarea>
<br>
<h3><span class="label label-primary">期望对方（必填内容）</span></h3>
<textarea class="form-control" rows="5"></textarea>
<br>
<h3><span class="label label-danger">无图无真相</span></h3>
 <input type="file">
 <br>
<div class="input-group input-group-lg">
  <span class="input-group-addon">联系方式</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<div class="row"> 
<div class="col-md-1"> </div>
<div class="col-md-8"> </div>
<div class="col-md-3">
  <button type="button" class="btn btn-warning btn-lg">取消</button>
  &nbsp&nbsp
<button type="button" class="btn btn-success btn-lg">发布</button>
 </div>
</div>
  </div>
</div>
      </div>
      <div class="col-md-3"> </div>
    </div>
  </div>
</body>
</html>