<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/job_info.css">
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
</head>
<title>工作信息</title>
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
					<div class="panel-body">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="jobinfotitle">
									忒各色发布了 <a href="">Java开发工程师</a> <span class="label label-info"
										style="font-size: 15px;">社会招聘</span>
								</div>
								<div class="row" id="jobinfohead">公司：北极光通信 地点：建国门内大街23号</div>
								&nbsp
								<div class="row" id="jobinfocontent">
									<p>工作职责：1.熟练掌握java,精通J2EE框架。2.有Mysql数据库使用经验，能够根据业务对MySQL进行优化。3.对数据结构和算法有一定的基础，并且能熟练写出基础算法。</p>
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="jobinfotitle">
									忒各色发布了 <a href="">Java开发工程师</a> <span class="label label-info"
										style="font-size: 15px;">实习生内推</span>
								</div>
								<div class="row" id="jobinfohead">公司：北极光通信 地点：建国门内大街23号</div>
								&nbsp
								<div class="row" id="jobinfocontent">
									<p>工作职责：1.熟练掌握java,精通J2EE框架。2.有Mysql数据库使用经验，能够根据业务对MySQL进行优化。3.对数据结构和算法有一定的基础，并且能熟练写出基础算法。</p>
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="jobinfotitle">
									忒各色发布了 <a href="">Java开发工程师</a> <span class="label label-info"
										style="font-size: 15px;">校招内推</span>
								</div>
								<div class="row" id="jobinfohead">公司：北极光通信 地点：建国门内大街23号</div>
								&nbsp
								<div class="row" id="jobinfocontent">
									<p>工作职责：1.熟练掌握java,精通J2EE框架。2.有Mysql数据库使用经验，能够根据业务对MySQL进行优化。3.对数据结构和算法有一定的基础，并且能熟练写出基础算法。</p>
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="jobinfotitle">
									忒各色发布了 <a href="">Java开发工程师</a>
								</div>
								<div class="row" id="jobinfohead">公司：北极光通信 地点：建国门内大街23号</div>
								&nbsp
								<div class="row" id="jobinfocontent">
									<p>工作职责：1.熟练掌握java,精通J2EE框架。2.有Mysql数据库使用经验，能够根据业务对MySQL进行优化。3.对数据结构和算法有一定的基础，并且能熟练写出基础算法。</p>
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="jobinfotitle">
									忒各色发布了 <a href="">Java开发工程师</a>
								</div>
								<div class="row" id="jobinfohead">公司：北极光通信 地点：建国门内大街23号</div>
								&nbsp
								<div class="row" id="jobinfocontent">
									<p>工作职责：1.熟练掌握java,精通J2EE框架。2.有Mysql数据库使用经验，能够根据业务对MySQL进行优化。3.对数据结构和算法有一定的基础，并且能熟练写出基础算法。</p>
								</div>
							</div>
						</div>
					</div>
					<a href="">
						<div class="panel-footer" style="text-align: center">更多</div>
					</a>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
</html>