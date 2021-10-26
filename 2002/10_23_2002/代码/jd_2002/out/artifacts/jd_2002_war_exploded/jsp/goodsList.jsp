<%@ page import="com.lnboxue.entity.UserTable" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lnboxue.entity.GoodsTable" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	.context{
		background-color: gray;
	}
</style>
</head>
<body>
	<p>欢迎您，<strong>${sessionScope.userTable.name}</strong></p><br/>
	<hr/>
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr class="title">
			<th>序号</th>
			<th>编号</th>
			<th>名称</th>
			<th>单价</th>
			<th>库存</th>
			<th>相关操作</th>
		</tr>
		<c:forEach var="goodsTable" items="${goodsList}" varStatus="vs">
			<tr
				<c:if test="${vs.count%2==0}">class="context" </c:if>
			>
				<td>${vs.count}</td>
				<td>${goodsTable.id}</td>
				<td>
					<c:url var="url" value="GoodsDetailServlet">
						<c:param name="id" value="${goodsTable.id}"/>
					</c:url>
					<a href="${url}">${goodsTable.name}</a>
				</td>
				<td>${goodsTable.price}</td>
				<td>${goodsTable.stock}</td>
				<td><a href="${pageContext.request.contextPath}/GoodsUpdateInitServlet?id=${goodsTable.id}">修改
				</a><a href="${pageContext.request.contextPath}/GoodsDeleteServlet?id=${goodsTable.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 用于展示页码 -->
	<p style="text-align: center;">
		<c:forEach var="i" begin="1" end="${maxPageNo}">
			<a href="${pageContext.request.contextPath}/ShowGoodsServlet?pageNo=${i}">${i}</a>
		</c:forEach>

		<%-- <%
			//获取最大页码（总页数）
			int maxPageNo = (Integer)request.getAttribute("maxPageNo");
			for (int i=1;i<=maxPageNo;i++){
		%>
				<a href="<%=request.getContextPath()%>/ShowGoodsServlet?pageNo=<%=i%>"><%=i%></a>
		<%
			}
		%> --%>
	</p>
	<a href="${pageContext.request.contextPath}/jsp/goodsAdd.jsp">添加</a>
</body>
</html>