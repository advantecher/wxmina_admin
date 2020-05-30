<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>微信小程序后台管理系统</title>
<link rel="stylesheet" type="text/css" href="css/loginstyle.css" />
<script type="text/javascript">
	window.onload=function(){
		
		if(window.parent != window){// 如果是在框架中
			//就让框架页面跳转到登陆页面
			window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
		}
		
	};
</script>
</head>

<body>
	<div class="main">
		<div class="mainin">
			<h1 align="center" id="title" style="font-size:30px;color:white;">微信小程序·后台管理</h1>
			<form action="${pageContext.request.contextPath }/UserAction_login" method="post">
				<div class="mainin1">
					<ul>
						<li><font color="red" ><s:property value="exception.message" /> </font></li>
						<li><span>用户名：</span><input name="user_name" type="text"
							id="loginName" placeholder="登录名" class="SearchKeyword"></li>
						<li><span>密码：</span><input type="password" name="user_password"
							id="Possword" placeholder="密码" / class="SearchKeyword2"></li>
						<li><button class="tijiao">提交</button></li>
					</ul>
				</div>
			</form>
			<div class="footpage">
				<span style="" font-family:arial;""="">Copyright @NJUPT 2020
			</div>
		</div>
	</div>
	<img src="images/loading.gif" id="loading"
		style="display: none; position: absolute;" />
	<div id="POPLoading" class="cssPOPLoading">
		<div style="height: 110px; border-bottom: 1px solid #9a9a9a">
			<div class="showMessge"></div>
		</div>
		<div style="line-height: 40px; font-size: 14px; letter-spacing: 1px;">
			<a onclick="puc()">确定</a>
		</div>
	</div>
	<div style="text-align: center;"></div>
</body>
</html>