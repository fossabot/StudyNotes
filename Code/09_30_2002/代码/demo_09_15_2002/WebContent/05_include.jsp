<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include指令</title>
</head>
<body>
	<!-- 在当前页面中包含其它页面 静态包含 -->
	<%-- <%@include file="common/header.jsp" %> --%>
	<!-- jsp动作标签 动态包含 -->
	<jsp:include page="common/header.jsp"></jsp:include>
	首页的内容
</body>
</html>