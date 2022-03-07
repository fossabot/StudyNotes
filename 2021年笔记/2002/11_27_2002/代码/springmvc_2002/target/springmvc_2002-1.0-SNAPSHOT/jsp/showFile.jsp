<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<td>编号</td>
			<td>文件名</td>
			<td>操作</td>
		</tr>
		<c:forEach var="file" items="${fileList}" varStatus="vs">
			<tr>
				<td>${vs.count}</td>
				<td>${file.name}</td>
				<td>

					<a href="">下载</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
