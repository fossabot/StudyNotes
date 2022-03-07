<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2021/11/22
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${message}<br/>
    success.jsp<br/>
    成功<br/>
    ${requestScope.message}<br/>
    ${username}<br/>
    ${salary}<br/>
    <!-- 格式化日期 -->
    <fmt:formatDate value="${user.hiredate}" type="date"/>
</body>
</html>
