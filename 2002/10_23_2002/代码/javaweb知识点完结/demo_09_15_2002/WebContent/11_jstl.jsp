<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="app05.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	 <hr/>
	 <!-- choose标签+when标签+otherwise标签：处理条件判断 -->
	 <c:set var="score" value="56"/>
	 <c:choose>
	 	<c:when test="${score>=90 && score<=100 }">
	 		优秀
	 	</c:when>
	 	<c:when test="${score>=80 && score<90 }">
	 		良好
	 	</c:when>
	 	<c:when test="${score>=70 && score<80 }">
	 		一般
	 	</c:when>
	 	<c:when test="${score>=60 && score<70 }">
	 		及格
	 	</c:when>
	 	<c:otherwise>
	 		不及格
	 	</c:otherwise>
	 </c:choose>
	 <hr/>
	 <%
	 	//实例化集合对象
	 	List<Student> list = new ArrayList<Student>();
	 	//向集合中添加元素
	 	list.add(new Student("wenwei",20));
	 	list.add(new Student("dechen",19));
	 	list.add(new Student("jiangxin",18));
	 	//将集合对象放入到域对象中
	 	pageContext.setAttribute("list", list);
	 	
	 	//实例化集合对象
	 	Map<String,Object> map = new HashMap<String,Object>();
	 	map.put("101", new Student("yanze",20));
	 	map.put("102", new Student("hongjun",19));
	 	map.put("103", new Student("minghao",18));
	 	//将集合对象放入到域对象中
	 	pageContext.setAttribute("map", map);
	 %>
	 <c:forEach items="${list }" var="student" varStatus="vs">
	 	序号：${vs.count } - 姓名：${student.name } - 年龄：${student.age }<br/>
	 </c:forEach>
	 <hr/>
	 <c:forEach items="${map }" var="entry">
	 	${entry.key } - 姓名：${entry.value.name } - 年龄：${entry.value.age }<br/>
	 </c:forEach>
	 <hr/>
	 <%
	 	//实例化时间对象
	 	Date d = new Date();
	 	//将时间对象放入到域对象中
	 	pageContext.setAttribute("now", d);
	 %>
	 <%-- ${now } --%>
	 <!-- 将时间格式化 yyyy-MM-dd HH:mm:ss -->
	 <%-- <fmt:formatDate value="${now }" type="both"/> --%>
	 <fmt:formatDate value="${now }" type="date"/>
</body>
</html>