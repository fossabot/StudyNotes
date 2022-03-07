<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<body>
   <input type="button" value="Emp转JSON"/><p>

   <input type="button" value="List<Emp>转JSON"/><p>

   <input type="button" value="Map<String,Object>转JSON"/><p>

   <!-- Emp转JSON -->
   <script type="text/javascript">
      $(":button:first").click(function () {
         //请求URL
         var url = "${pageContext.request.contextPath}/emp/beantojson.action";
         //传递的参数
         var sendData = null;
         $.post(url,sendData,function (data,textStatus,jqXHR) {
            var hiredate = data.hiredate;
            //alert(hiredate);
            var date = new Date(hiredate);
            alert(date.getFullYear() + "-" + (date.getMonth()+1) + "-" + (date.getDate()));
         });
      });
   </script>

   <!-- List<Emp>转JSON -->
   <script type="text/javascript">
      $(":button:eq(1)").click(function () {
         //请求URL
         var url = "${pageContext.request.contextPath}/emp/listbeantojson.action";
         //传递的参数
         var sendData = null;
         $.post(url,sendData,function (data,textStatus,jqXHR) {
            $.each(data,function (index,value) {
               alert(value['id']);
               alert(value['username']);
               var date = new Date(value['hiredate']);
               alert(date.getFullYear() + "-" + (date.getMonth()+1) + "-" + (date.getDate()));
            })
         });
      });
   </script>

   <!-- Map<String,Object>转JSON -->
   <script type="text/javascript">

   </script>
</body>
</html>
