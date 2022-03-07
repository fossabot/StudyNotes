<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.3.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

</head>

<body >
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/check" method="post">
    <div class="form-group" align="center">
        <div class="form-group" align="center">
            <label  class="col-sm-6 control-label" style="font-size: 28px; color:black; font-family: 华文楷体;" >学生管理系统登陆界面</label>
        </div>
    </div>
    <div class="form-group">
        <label for="username" class="col-sm-2 control-label" style=" color:black;">名字</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" name="username" id="username" placeholder="请输入名字">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label" style=" color:black;">密码</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <td class="s2">
                    <label style=" color:black;">
                        登录身份:
                    </label>

                </td>
                <td>
                    <select id="type" name="type">
                        <option value="-1">
                            --请选择--
                        </option>
                        <option value="0">
                            学生
                        </option>
                        <option value="1">
                            教师
                        </option>
                        <option value="2">
                            管理员
                        </option>
                    </select>
                </td>
                <td height="37" colspan="2" align="right">
                    &nbsp;<button type="submit" id="submit" name="submit" value="登陆">登陆</button>
                    &nbsp;<button type="reset" id="reset" name="reset" style="background-color:transparent;border: 0;" ></button>
                </td>
            </div>
        </div>
    </div>
</form>
</body>
</html>
