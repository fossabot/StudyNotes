<%@ page contentType="text/html;charset=UTF-8"  language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书馆首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <script src="${pageContext.request.contextPath}/static/js/js.cookie.js"></script>
    <style>
        #login{
           height: 50%;
            width: 28%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
            position: center;
        }
        .form-group {
            margin-bottom: 0;
        }
        * {
            padding:0;
            margin:0;
        }
    </style>
</head>
<body background="${pageContext.request.contextPath}/static/img/timg.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<h2 style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">图 书 馆</h2>

<div class="panel panel-default" id="login">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">请登录</h3>
    </div>
    <div class="panel-body">
        <div class="form-group">
            <label for="id">账号</label>
            <input type="text" class="form-control" id="id" placeholder="请输入账号">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" placeholder="请输入密码">
        </div>
        <div class="checkbox text-left">
            <label>
                <input type="checkbox" id="remember">记住密码
            </label>
        </div>

        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
        <button id="loginButton"  class="btn btn-primary  btn-block">登陆
        </button>
    </div>
	</div>
		<script>
			//向该input控件挂在按键抬起事件 not a number=>NaN
            $("#id").keyup(function () {
                //判断账号是否为数字
                if (isNaN($("#id").val())){
                    //给出提示信息
                    $("#info").text("提示：账号只能为数字")
                } else {
                    //清空提示信息
                    $("#info").text("");
                }
            });

            //提交请求数据
            $("#loginButton").click(function () {
                //获取账号内容
                var id = $("#id").val();
                //获取密码内容
                var password = $("#password").val();
                //判断请求数据的合法性
                if (id==""){
                    //给出提示信息
                    $("#info").text("提示：账号不能为空");
                } else if (password==''){
                    $("#info").text("提示：密码不能为空")
                } else if(isNaN(id)){
                    $("#info").text("提示：账号必须为数字");
                } else {
                    //使用ajax请求服务器
                    $.ajax({
                        //请求类型
                        type:"POST",
                        //请求的URL
                        url:"${pageContext.request.contextPath}/loginCheck",
                        //请求数据到服务器端的数据（JSON）
                        data:{
                            id:id,
                            password:password
                        },
                        //指定服务器端返回的数据类型
                        dataType:"json",
                        //响应数据处理方法
                        success:function (data) {
                            //判断角色进行页面跳转
                            if (data.stateCode.trim()=="0"){
                                //给出提示信息
                                $("#info").text("提示：账号或密码错误！");
                            } else if(data.stateCode.trim()=="1"){
                                //给出提示信息
                                $("#info").text("提示：登录成功，跳转中...");
                                //跳转到管理员主页面
                                window.location.href = "${pageContext.request.contextPath}/admin_main.html";
                            }
                        }
                    });
                }
            });
		</script>
	</div>
</body>
</html>
