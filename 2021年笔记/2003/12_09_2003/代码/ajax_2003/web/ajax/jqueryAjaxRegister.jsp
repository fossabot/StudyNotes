<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检查注册用户名和密码是否存在</title>
<!-- 引入外部js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
	<!--
		在异步提交的方式下，form标签的action和method属性没有意义
	 -->
	<form action="" method="get">
		<table border="2" align="center">
			<tr>
				<th>用户名</th>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="检查" style="width: 111px"/>
				</td>
			</tr>
		</table>
	</form>

	<span></span>

	<script type="text/javascript">
		$(":button").click(function () {
			//获取用户名和密码
			var username = $(":text").val();
			var password = $(":password").val();

		});
	</script>
	<!--
	<form action="" enctype="application/x-www-form-urlencoded"></form>
	 -->
</body>
</html>
