<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=""></script>
</head>
<body>
	<form action="" method="POST">
		<table border="2" align="center">
			<caption>用户注册</caption>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<th>月薪</th>
				<td><input type="text" name="salary" value="7000"/></td>
			</tr>
			<tr>
				<th>入职时间(yyyy-MM-dd)</th>
				<td><input type="text" name="hiredate"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册" style="width: 111px"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>