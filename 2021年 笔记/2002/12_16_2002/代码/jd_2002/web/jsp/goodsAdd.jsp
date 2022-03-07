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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
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
		商品名称:<input type="text" name="name" value="" /><span></span><br/>
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
		<input type="submit"  value="提交"/>
	</form>

	<script type="text/javascript">
		//为input元素绑定失去焦点事件
		$("input[name=name]").blur(function () {
			//获取商品名称并去除首尾空格
			var name = $.trim($(this).val());
			//判断商品名称是否为空
			if (name!=""){
				//向服务器端发送ajax请求（ajax完整写法）
				$.ajax({
					//请求URL
					url:"${pageContext.request.contextPath}/NameCheckAjaxServlet",
					//请求类型
					type:"POST",
					//向服务器端传递的参数
					data:{name:name},
					//服务器预期返回的数据类型
					dataType:"json",
					success:getJsonData,
					error:sendErrorMsg
				});
			}
		});

		function getJsonData(data,textStatus,jqXHR) {
			//判断当前商品名称是否存在
			if (data.result==true){
				//在span标签中显示商品名称已存在（文字为空色）
				$("span").text("该商品名称已存在").css("color","red");
				//将按钮置灰
				//$("input[type=submit]").attr("disabled","disabled");
				$("input[type=submit]").attr("disabled",true);
			} else {
				//将按钮变成可用状态
				$("input[type=submit]").removeAttr("disabled");
				//将span元素中的内容清空
				$("span").text("");
			}
		}

		function sendErrorMsg(data,textStatus,jqXHR) {
			alert("请求失败！")
		}
	</script>
</body>
</html>