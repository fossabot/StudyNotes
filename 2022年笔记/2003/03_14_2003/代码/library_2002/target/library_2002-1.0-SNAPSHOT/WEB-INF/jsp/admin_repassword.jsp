<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更改密码</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('${pageContext.request.contextPath}/admin_header.html');
        });
    </script>
</head>
<body background="${pageContext.request.contextPath}/static/img/book2.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 100px"></div>
<div style="position: relative">
    <c:if test="${!empty success}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${success}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${error}
        </div>
    </c:if>
</div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary ">
        <div class="panel-heading">
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
            <form method="post" action="" class="form-inline" id="repassword">
                <div class="input-group">
                    <input type="password" id="oldPassword" name="oldPassword" placeholder="输入旧密码" class="form-control"
                           class="form-control">
                    <input type="password" id="newPassword" name="newPassword" placeholder="输入新密码" class="form-control"
                           class="form-control">
                    <input type="password" id="reNewPassword" name="reNewPassword" placeholder="再次输入新密码"
                           class="form-control" class="form-control">
                    <em id="warning" style="color: red"></em>
                    <br/>
                    <span>
                            <input type="submit" value="提交" class="btn btn-default">
                    </span>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    
</script>
</body>
</html>
