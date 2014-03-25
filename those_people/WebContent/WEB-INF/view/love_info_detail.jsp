<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css"
	href="../css/love_info_detail.css">
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
</head>
<title>交友详细信息</title>
</head>
<c:choose>
	<c:when test="${!empty sessionScope.userInfo}">
		<jsp:include page="/WEB-INF/view/login_header.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="/WEB-INF/view/header.jsp" />
	</c:otherwise>
</c:choose>
<body id="common_body">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>工作信息详情</h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="col-md-8">公司：北极光通信 地点：建国门内大街23号</div>
								<div class="col-md-4">
									发布时间：2014-3-20 <br> <br> 浏览人数：100人
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						<p>自我描述：</p>
						<p>1)独立负责浏览器重要功能的产品设计，包括撰写需求文档、原型设计文档及组织实施产品开发等；
							2)推动产品的上线、运营，并根据数据分析、用户反馈，持续优化； 3)负责浏览器功能产品的调研、分析及竞品研究；
							4)与设计、开发、测试和商务团队紧密合作，推动产品快速发展；</p>

						<br> <br>
						<p>期望对方：</p>
						<p>1)独立负责浏览器重要功能的产品设计，包括撰写需求文档、原型设计文档及组织实施产品开发等；
							2)推动产品的上线、运营，并根据数据分析、用户反馈，持续优化； 3)负责浏览器功能产品的调研、分析及竞品研究；
							4)与设计、开发、测试和商务团队紧密合作，推动产品快速发展；</p>
						<hr class="featurette-divider">
						<button type="button" class="btn btn-info" id="collectBtn">收藏</button>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<span class="glyphicon glyphicon-comment"></span> 说两句 <br>
						<textarea class="form-control" rows="5"></textarea>
						<div class="row">
							<button type="button" class="btn btn-info" id="commentBtn">评论</button>
						</div>
						<h4>评论</h4>
						<br>
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">哇塞，美女哦！真心不错，男同胞们快来吧！</div>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>