<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL标签库</title>
</head>
<body>
	<!-- set标签 
			var:为变量命名
			value：变量的值
			scope：存储的范围，如：request、session...
	-->
	<c:set var="name" value="encong" scope="request"/>
	<%-- ${name }<br/> --%>
	${requestScope.name }<br/>
	<%
		String msg = "siying";
		//String msg = null;
		pageContext.setAttribute("msg", msg);
	%>
	${msg }<br/>
	<!-- 
		out标签：
			value：用于从域对象中取出数据
			default：如果取出的数据为空，则显示该默认值
	 -->
	<c:out value="${msg }" default="没有获取到数据"></c:out>
	<hr/>
	<!-- 
		if标签：
			test属性：用于设置判断的条件
	 -->
	 <c:if test="${!empty msg }">
	 	条件成立
	 </c:if>
</body>
</html>