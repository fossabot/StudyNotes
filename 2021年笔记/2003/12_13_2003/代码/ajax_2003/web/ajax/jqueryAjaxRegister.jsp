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
			//var username = $(":text").val();
			//var password = $(":password").val();
			//请求的URL
			var url = "${pageContext.request.contextPath}/UserAjaxServlet?time=" + new Date().getTime();
			//传入服务器端的参数值（手动写json文本）
			/*var sendData = {
				"username":username,
				"password":password
			};*/
			//方式二
			var sendData = $("form").serialize();
			//从ajax异步对象中获取服务器响应的html数据
			$.post(url,sendData,function (backData,textStatus,jqXHR) {
				console.log(backData);
				console.log(textStatus);
				/**
				 * backData可以返回三种形式：
				 * 	1.如果服务器返回html，即backData就是String，不需要解析
				 * 	2.如果服务器端返回json，即backData就是Object，需要解析
				 * 	3.如果服务器端返回xml,即backData就是Object，需要解析
				 */
				//创建图片元素
				var $img = "<img src='" + backData + "' width='14px' height='14px' />";
				//将span元素的内容清空
				$("span").text("");
				//将图片插入到span标签
				$("span").append($img);
			});
		});
	</script>
	<!--
	<form action="" enctype="application/x-www-form-urlencoded"></form>
	 -->
</body>
</html>
