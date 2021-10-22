<%@ page import="com.lnboxue.entity.GoodsTable" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加页面</title>
</head>
<body>
	<%
		GoodsTable goodsTable = (GoodsTable)request.getAttribute("goodsTable");
	%>
	商品编号:<%=goodsTable.getId()%><br/>
	商品名称:<%=goodsTable.getName()%><br/>
	商品类别:<%=goodsTable.getGtName()%><br/>
	商品单价:<%=goodsTable.getPrice()%><br/>
	商品库存:<%=goodsTable.getStock()%><br/>
	商品描述:<%=goodsTable.getRemarks()%><br/>
</body>
</html>