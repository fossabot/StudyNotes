<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表达式</title>
</head>
<body>
	<%
		//定义变量
		String name = "yiming";
		int a = 10;
		int b = 20;
	%>
	<%=name %><br/>
	<%=(a+b) %>
</body>
</html>