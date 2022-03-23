<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${}的主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('${pageContext.request.contextPath}/reader_header.html');
        });
    </script>
</head>
<body background="${pageContext.request.contextPath}/static/img/wolf.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>

</body>
</html>
