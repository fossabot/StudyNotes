<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<!-- 引入外部js文件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.js"></script>
</head>
<body>
	<table id="goodsTable" border="1">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>名称</th>
			<th>单价</th>
			<th>库存</th>
		</tr>
	</table>
	<script type="text/javascript">
		//网页中的素有DOM文档结构绘制完毕后即可执行，可能与DOM元素关联的内容并没有加载完
		$(function () {
			//调用函数
			getGoodsList();
		});

		//获取商品数据
		function getGoodsList() {
			$.ajax({
				//请求类型
				type:"GET",
				//服务器预期返回的类型
				dataType:"json",
				//请求URL
				url:"${pageContext.request.contextPath}/ShowAjaxGoodsServlet?time=" + new Date().getTime(),
				//从ajax异步对象中获取服务器响应的html数据
				success:function (data,textStatus,jqXHR) {
					//清空原table中的数据，以备实现更新数据
					$("table tr:gt(0)").remove();
					//动态的为table添加元素
					$.each(data,function (index,value) {
						//手动拼接表格
						var $newTr = $("<tr><td>"
								+ (index+1) + "</td><td>"
								+ value['id'] + "</td><td>"
								+ value['name'] + "</td><td>"
								+ value['price'] + "</td><td>"
								+ value['stock'] + "</td></tr>"
						);
						//将tr标签插入到表格中
						$("#goodsTable").append($newTr);
					});
				},
				error:function (data) {
					alert("请求失败！");
				}
			});
		}
	</script>
</body>
</html>