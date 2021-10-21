<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小脚本</title>
</head>
<body>
	<%
		//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//实例化当前日期
		Date date = new Date();
		//格式化当前日期
		String currentDate = sdf.format(date);
		//将当前日期输出在浏览器
		PrintWriter pw = response.getWriter();
		pw.write(currentDate);
		pw.flush();
		pw.close();
	%>
</body>
</html>