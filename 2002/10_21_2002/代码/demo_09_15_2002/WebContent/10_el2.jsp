<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="app05.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	<!-- 
		1)EL输出对象属性
		${student.name }等价于调用getXXX()方法
	 -->
	 <%
	 	//实例化学生对象
	 	Student student = new Student("encong",20);
	 	//将该对象放入域对象中
	 	pageContext.setAttribute("student", student);
	 	
	 	//List集合
	 	List<Student> list = new ArrayList<Student>();
	 	//向集合中加入元素
	 	list.add(new Student("haoyue",20));
	 	list.add(new Student("baiyang",19));
	 	list.add(new Student("yudi",18));
	 	//将集合对象放入域对象中
	 	pageContext.setAttribute("list", list);
	 %>
	 <!-- 使用EL表达式获取对象 -->
	 ${student.name } - ${student.age }
	 <hr/>
	 <!-- 使用EL表达式获取List对象 -->
	 ${list[0].name } - ${list[0].age }
</body>
</html>