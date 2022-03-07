<%@ page import="com.lnboxue.service.goods.impl.GoodsTypeServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lnboxue.entity.GoodsType" %>
<%@ page import="com.lnboxue.entity.GoodsTable" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		//将商品类别信息和当前商品信息均放入域对象中
		pageContext.setAttribute("goodsTypeList",goodsTypeList);
		pageContext.setAttribute("goodsTable",goodsTable);
	%>
	<form action="${pageContext.request.contextPath}/GoodsUpdateServlet"
		method="post" >
		商品编号<input  readonly="readonly" type="text" name="id" value="${goodsTable.id}" /><br />
		商品名称:<input type="text" name="name" value="${goodsTable.name}" /><br/>
		商品类别:<select name="gtId">
			<c:forEach var="goodsType" items="${goodsTypeList}">
				<c:choose>
					<c:when test="${goodsType.id eq goodsTable.gtId}">
						<option selected="selected"  value="${goodsType.id}">${goodsType.name}</option>
					</c:when>
					<c:otherwise>
						<option value="${goodsType.id}">${goodsType.name}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<%--<%
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
		    %>--%>
		</select>
		<br/>
		商品单价:<input type="text" name="price" value="${goodsTable.price}" /><br/>
		商品库存:<input type="text" name="stock" value="${goodsTable.stock}" /><br/>
		商品描述:
			   <textarea name="remarks" rows="5" cols="15">
				   ${goodsTable.remarks}
			   </textarea>
		<br/>
		<input type="submit"  value="提交" />
	</form>
</body>
</html>