<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>《${book.name}》</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('${pageContext.request.contextPath}/reader_header.html');
        });
    </script>
</head>
<body background="${pageContext.request.contextPath}/static/img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《》</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="15%">书名</th>
                    <td></td>
                </tr>
                <tr>
                    <th>作者</th>
                    <td></td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td></td>
                </tr>
                <tr>
                    <th>ISBN</th>
                    <td></td>
                </tr>
                <tr>
                    <th>简介</th>
                    <td></td>
                </tr>
                <tr>
                    <th>语言</th>
                    <td></td>
                </tr>
                <tr>
                    <th>价格</th>
                    <td></td>
                </tr>
                <tr>
                    <th>出版日期</th>
                    <td></td>
                </tr>
                <tr>
                    <th>分类号</th>
                    <td></td>
                </tr>
                <tr>
                    <th>状态</th>
                    <c:if test="">
                        <td>在馆</td>
                    </c:if>
                    <c:if test="">
                        <td>借出</td>
                    </c:if>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
