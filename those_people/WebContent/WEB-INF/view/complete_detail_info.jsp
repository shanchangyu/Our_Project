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
										style="padding-top: 50px; padding-bottom: 40px;">${realName}</td>
								</tr>
								<tr>
									<td>头像</td>
									<td><img
										src="../img/head-pic/headpic_default.jpg
									
									"
										alt="..." class="img-thumbnail"></td>
									<td>
										<button type="file" class="btn btn-primary btn-lg">选择头像</button>
									</td>
									<td></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">性別(必填)</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">男</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="radio">女</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">教育经历</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="学校">（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" class="form-control" placeholder="专业"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">入学时间（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><select>
											<option value="volvo">2014</option>
											<option value="saab">2013</option>
											<option value="opel">2012</option>
											<option value="audi">2011</option>
											<option value="audi">2010</option>
											<option value="audi">2009</option>
											<option value="audi">2008</option>
											<option value="audi">2007</option>
											<option value="audi">2006</option>
											<option value="audi">2005</option>
											<option value="audi">2004</option>
											<option value="audi">2003</option>
											<option value="audi">2002</option>
											<option value="audi">2001</option>
											<option value="audi">2000</option>
											<option value="audi">1999</option>
											<option value="audi">1998</option>
											<option value="audi">1997</option>
											<option value="audi">1996</option>
											<option value="audi">1995</option>
											<option value="audi">1994</option>
											<option value="audi">1993</option>
											<option value="audi">1992</option>
											<option value="audi">1991</option>
											<option value="audi">1990</option>
											<option value="audi">1989</option>
											<option value="audi">1988</option>
											<option value="audi">1987</option>
											<option value="audi">1986</option>
											<option value="audi">1985</option>
											<option value="audi">1984</option>
											<option value="audi">1983</option>
											<option value="audi">1982</option>
											<option value="audi">1981</option>
											<option value="audi">1980</option>
											<option value="audi">1979</option>
											<option value="audi">1978</option>
											<option value="audi">1977</option>
											<option value="audi">1976</option>
											<option value="audi">1975</option>
											<option value="audi">1974</option>
											<option value="audi">1973</option>
											<option value="audi">1972</option>
											<option value="audi">1971</option>
											<option value="audi">1970</option>
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
									<td style="padding-top: 50px; padding-bottom: 40px;">居住地（必填）</td>
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
									<td style="padding-top: 50px; padding-bottom: 40px;">实名或匿名显示（必填）</td>
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