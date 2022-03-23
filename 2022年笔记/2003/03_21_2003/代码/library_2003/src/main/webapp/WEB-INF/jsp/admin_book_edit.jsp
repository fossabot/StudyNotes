<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑《${book.name}》</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('${pageContext.request.contextPath}/admin_header.html');
        });
    </script>
</head>
<body background="${pageContext.request.contextPath}/static/img/book2.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header" style="padding-bottom: 80px"></div>

<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《${book.name}》</h3>
        </div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/bookUpdate.html?bookId=${book.bookId}" method="post" id="addbook">
                <div class="input-group">
                    <span  class="input-group-addon">书名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${book.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="author" id="author" value="${book.author}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="publish" id="publish"  value="${book.publish}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">ISBN</span>
                    <input type="text" class="form-control" name="ISBN" id="ISBN"  value="${book.ISBN}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">简介</span>
                    <input type="text" class="form-control" name="introduction" id="introduction"  value="${book.introduction}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">语言</span>
                    <input type="text" class="form-control" name="language" id="language" value="${book.language}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="price"  id="price" value="${book.price}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版日期</span>
                    <input type="date" class="form-control" name="pubDate" id="pubDate" value="<fmt:formatDate value='${book.pubDate}' type='date'/>"/>
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="classId" id="classId" value="${book.classId}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">数量</span>
                    <input type="text" class="form-control" name="number"  id="number" value="${book.number}">
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
            </form>
        </div>
    </div>
</div>

<script>
    //表单验证（jQuery）
    $("#addbook").submit(function () {
        //判断文本框中的每个值是否为空
        if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#ISBN").val()==''
            ||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubDate").val()==''
            ||$("#classId").val()==''||$("#number").val()==''){
            alert("请填入完整图书信息！");
            return false;
        }
        return true;
    });
</script>
</body>
</html>
