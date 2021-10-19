<%@ page import="com.lnboxue.service.goods.impl.GoodsTypeServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lnboxue.entity.GoodsType" %>
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
		GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> goodsTypeList = goodsTypeService.goodsTypeAllSelect();
		GoodsTable goodsTable = (GoodsTable) request.getAttribute("goodsTable");
	%>
	<form action="<%=request.getContextPath()%>/GoodsUpdateServlet"
		method="post" >
		商品编号<input  readonly="readonly" type="text" name="id" value="<%=goodsTable.getId()%>" /><br />
		商品名称:<input type="text" name="name" value="<%=goodsTable.getName()%>" /><br/>
		商品类别:<select name="gtId">
			<%
				for (GoodsType goodsType : goodsTypeList){
					if(goodsType.getId().intValue()==goodsTable.getGtId().intValue()){
			%>
						<option selected="selected"  value="<%=goodsType.getId()%>"><%=goodsType.getName()%></option>
				<%
					}else {
				%>
						<option value="<%=goodsType.getId()%>"><%=goodsType.getName()%></option>
		    <%
					}
				}
		    %>
		</select>
		<br/>
		商品单价:<input type="text" name="price" value="<%=goodsTable.getPrice()%>" /><br/>
		商品库存:<input type="text" name="stock" value="<%=goodsTable.getStock()%>" /><br/>
		商品描述:
			   <textarea name="remarks" rows="5" cols="15">
				   <%=goodsTable.getRemarks()%>
			   </textarea>
		<br/>
		<input type="submit"  value="提交" />
	</form>
</body>
</html>