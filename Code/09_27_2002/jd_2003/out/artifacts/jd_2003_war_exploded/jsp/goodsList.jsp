<%@ page import="com.lnboxue.entity.UserTable" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lnboxue.entity.GoodsTable" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style type="text/css">
	.title{
		background-color: orange;
		font-size: 24px;
		color: black;
	}
	table{
		line-height: 30px;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<%
		//获取用户信息
		UserTable userTable =  (UserTable)session.getAttribute("userTable");
		//获取商品列表
		List<GoodsTable> goodsList = (List<GoodsTable>)request.getAttribute("goodsList");
	%>
	<p><strong>欢迎您，<%=userTable.getName()%></strong></p><br/>
	<hr/>
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr class="title">
			<th>编号</th>
			<th>名称</th>
			<th>单价</th>
			<th>库存</th>
			<th>相关操作</th>
		</tr>
		<%
			for(GoodsTable goodsTable : goodsList){
		%>
			<tr>
				<td><%=goodsTable.getId()%></td>
				<td><%=goodsTable.getName()%></td>
				<td><%=goodsTable.getPrice()%></td>
				<td><%=goodsTable.getStock()%></td>
				<td><a href="#">修改
				</a><a href="#">删除</a>
				</td>
			</tr>
		<%
			}
		%>
	</table>
	<a href="<%=request.getContextPath()%>/jsp/goodsAdd.jsp">添加</a>
</body>
</html>