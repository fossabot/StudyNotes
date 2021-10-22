<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext对象</title>
</head>
<body>
	<!-- pageContext作用域 -->
	<%
		pageContext.setAttribute("message", "pageContext message");
		request.setAttribute("message", "request message");
		session.setAttribute("message", "session message");
		application.setAttribute("message", "application message");
	%>
	<%
		String message = (String)pageContext.getAttribute("message");
		//打印信息
		out.write(message);
	%>
	<%
		//请求转发
		//request.getRequestDispatcher("/08_pageContext.jsp").forward(request, response);
		//重定向
		response.sendRedirect(request.getContextPath() + "/08_pageContext.jsp");
	%>
</body>
</html>