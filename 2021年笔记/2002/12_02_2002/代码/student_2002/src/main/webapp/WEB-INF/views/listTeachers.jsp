<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title> Bootstrap </title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.3.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<table class="table table-striped">
    <tr>
        <td>id</td>
        <td>名字</td>
        <td>性别</td>
        <td>职称</td>
        <td>生日</td>
        <td>薪水</td>
        <td>教授课程</td>
        <td>编辑</td>
    </tr>
    
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="">删除</a>
                <a href="">修改</a>
            </td>
        </tr>
    
</table>
<div class="row">
    <div class="col-md-6">
        第${pageInfo.pageNum}页，共${pageInfo.pages}页，共${pageInfo.total}条记录
    </div>
    <div class="col-md-6 offset-md-4">
        <nav aria-label="Page navigation example">
            <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/teacher/list?page=1">首页</a></li>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/teacher/list?page=${pageInfo.pageNum-1}">上一页</a></li>
                </c:if>
                <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                    <c:if test="${page==pageInfo.pageNum}">
                        <li class="page-item active"><a class="page-link" href="#">${page}</a></li>
                    </c:if>
                    <c:if test="${page!=pageInfo.pageNum}">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/teacher/list?page=${page}">${page}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${pageInfo.hasNextPage}">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/teacher/list?page=${pageInfo.pageNum+1}">下一页</a></li>
                </c:if>
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/teacher/list?page=${pageInfo.pages}">末页</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
</div>
</body>
</html>
