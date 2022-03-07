<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<!-- 引入外部js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
</head>
<body>
	<form id="loginFm">
		<table border="2" align="center">
			<tr>
				<th>用户名</th>
				<td><input id="name" type="text" name="name"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="password" type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input id="btn" type="button" value="提交" />
				</td>
			</tr>
		</table>
	</form>
	<div id="message"></div>
	
	<script type="text/javascript">
		//为按钮绑定单击事件
		$("#btn").click(function () {
			//获取用户名
			var name = $("#name").val();
			//获取密码
			var password = $("#password").val();
			//通过AJAXz向服务器端发送请求
			$.ajax({
				//请求类型
				type:"POST",
				//服务器预期返回的数据类型
				dataType:"text",
				//请求URL
				url:"${pageContext.request.contextPath}/LoginAjaxServlet?time=" + new Date().getTime(),
				//传入服务器的参数值
				data:{name:name,password:password},
				//从ajax异步对象中获取服务器响应的html数据
				success:function (data,textStatus,jqXHR) {
					//判断是否成功
					if (data=="success"){
						//跳转到选查询页面
						window.location.href = "${pageContext.request.contextPath}/jsp/goodsJqueryAjaxList.jsp";
					} else {
						//登陆失败
						$("#message").html("账号或密码错误，请重新登陆！").css("color","red");
					}
				},
				error:function () {
					alert("请求失败...");
				}
			});
		});
	</script>
</body>
</html>