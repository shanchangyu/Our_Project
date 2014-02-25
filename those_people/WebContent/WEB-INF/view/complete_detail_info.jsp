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
<![endif]->
</head>
<title>title</title>
</head>
<jsp:include page="/WEB-INF/view/header.html" />
<body id="common_body">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>恭喜您已经成功注册！完善一下您的信息吧！以便我们更快的帮您找到组织。</h4>
					</div>
					<div class="panel-body">
						<table class="table">
							<tbody id="user_info_detail">
								<tr>
									<td colspan="4"
										style="padding-top: 50px; padding-bottom: 40px;">陈卓</td>
								</tr>
								<tr>
									<td>头像</td>
									<td><img src="../img/head-pic/headpic_default.jpg
									
									" alt="..."
										class="img-thumbnail"></td>
									<td>
										<button type="file" class="btn btn-primary btn-lg">选择头像</button>
									</td>
									<td></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">性別</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">男</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">女</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">教育经历</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="学校"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="专业"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">入学时间</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><select>
											<option value="volvo">Volvo</option>
											<option value="saab">Saab</option>
											<option value="opel">Opel</option>
											<option value="audi">Audi</option>
									</select> 年</td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">职业经历</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="公司或组织"></td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">居住地</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="目前居住地"></td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">写一句性感的签名呗</td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"><textarea
											class="form-control" rows="5" cols="20"></textarea></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">实名或匿名显示</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">匿名</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">实名</td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;">
										<button type="button" class="btn btn-primary btn-lg">保存设置</button>
									</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>