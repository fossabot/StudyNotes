<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap </title>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.3.1.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<form action="" method="post" class="form-control">
    姓名：<input name="name"  class="form-control" type="text" value="">
    密码：<input name="password"  class="form-control" type="password" value="">
    性别：<div>
    <label class="radio-inline">
        <input type="radio" name="sex" id="optionsRadios3" value="0" checked/> 男
    </label>
    <label class="radio-inline">
        <input type="radio" name="sex" id="optionsRadios4"  value="1" /> 女
    </label>
    </div>
    班级：<input name="clazz"  class="form-control" type="text" value="">
    <div class="form-group">
        <label for="dtp_input2" class="col-md-2 control-label">生日</label>
        <div class="input-group date form_date col-md-5" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
            <input class="form-control" size="16" type="text" name="birthday" value="" readonly>
            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
        </div>
        <input type="hidden" id="dtp_input2" value="" /><br/>
    </div>
<div class="form-group">
    <input  class="col-lg-4" value="add student" type="submit">
</div>
</form>
</body>
<script src="${pageContext.request.contextPath}/bootstrap/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

</script>
</html>
