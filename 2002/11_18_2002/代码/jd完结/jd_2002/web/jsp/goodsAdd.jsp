<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lnboxue.service.goods.impl.GoodsTypeServiceImpl" %>
<%@ page import="com.lnboxue.entity.GoodsType" %>
<%@ page import="java.util.List" %>
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
		GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> goodsTypeList = goodsTypeService.goodsTypeAllSelect();
		//将集合数据保存到域对象中
		pageContext.setAttribute("goodsTypeList",goodsTypeList);
	%>
	<form action="${pageContext.request.contextPath}/GoodsAddServlet"
	method="post" >
		商品名称:<input type="text" name="name" value="" /><br/>
		商品类别:<select name="gtId">
					<c:forEach var="goodsType" items="${goodsTypeList}">
						<option value="${goodsType.id}">${goodsType.name}</option>
					</c:forEach>
			  	</select>
		<br/>
		商品单价:<input type="text" name="price" value="" /><br/>
		商品库存:<input type="text" name="stock" value="" /><br/>
		商品描述:
			   <textarea name="remarks" rows="5" cols="15"></textarea>
		<br/>
		<input type="submit"  value="提交" />
	</form>
</body>
</html>