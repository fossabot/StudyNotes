<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<%
		String name = "mingxin";
		//将name放入域对象中
		pageContext.setAttribute("name", name);
	%>
	<%=name %><br/>
	<!-- 从四个域对象中依次搜索 -->
	EL表达式：${name }<br/>
	<!-- 从指定域对象中获取数据 
			pageScope
			requestScope
			sessionScope
			applicationScope
	-->
	EL表达式：${pageScope.name }
	
</body>
</html>