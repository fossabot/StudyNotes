<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取数据</title>
</head>
<body>
	page域：<%=pageContext.getAttribute("message") %><br/>
	request域：<%=request.getAttribute("message") %><br/>
	session域：<%=session.getAttribute("message") %><br/>
	application域：<%=application.getAttribute("message") %>
</body>
</html>