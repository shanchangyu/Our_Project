<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">
<!-- 配置文件 -->
<script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../ueditor/ueditor.all.js"></script>
<!-- 语言包文件(建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败) -->
<script type="text/javascript" src="../ueditor/lang/zh-cn/zh-cn.js"></script>
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
</head>
<jsp:include page="/WEB-INF/view/header.html" />
<body>
<body id="common_body">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-body">
						<script id="container" name="content" type="text/plain">
                                                                            这里写你的初始化内容
                         </script>
						<script type="text/javascript">
							var editor = UE.getEditor('container')
						</script>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<table class="table">
					<tbody id="right-tool-bar">
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-eye-open"></span> 关注（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-heart"></span> 赞（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-edit"></span> 文章（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-bullhorn"></span> 发布信息
								</h3> <br>
								<h4>
									<a href="../StaticView/post_job_info.html">房屋信息</a>
								</h4> <br>
								<h4>
									<a href="../StaticView/post_love_info.jsp">交友信息</a>
								</h4> <br>
								<h4>
									<a href="../StaticView/post_job_info.jsp">工作信息</a>
								</h4> <br>
								<h4>
									<a href="">活动信息</a>
								</h4>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-plus"></span> 加关注
								</h3>
							</td>
						</tr>
						<tr>
							<td>可能感兴趣的人</td>
						<tr>
							<td>热门话题</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>