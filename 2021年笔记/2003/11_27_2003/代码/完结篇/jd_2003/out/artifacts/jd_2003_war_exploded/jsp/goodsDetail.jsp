<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品添加页面</title>
</head>
<body>
	商品编号:${goodsTable.id}<br/>
	商品名称:${goodsTable.name}<br/>
	商品类别:${goodsTable.gtName}<br/>
	商品单价:${goodsTable.price}<br/>
	商品库存:${goodsTable.stock}<br/>
	商品描述:${goodsTable.remarks}<br/>
</body>
</html>