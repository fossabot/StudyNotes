<%@ page import="com.lnboxue.service.goods.impl.GoodsTypeServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lnboxue.entity.GoodsType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		pageContext.setAttribute("goodsTypeList",goodsTypeList);
	%>
	<form action="${pageContext.request.contextPath}/GoodsAddServlet"
	method="post" >
		商品名称:<input type="text" name="name" value="" /><span></span><br/>
		商品类别:<select name="gtId">
					<c:forEach items="${goodsTypeList}" var="goodsType">
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

	<script type="text/javascript">
		//在添加商品文本框绑定失去焦点事件
		$("input[name=name]").blur(function () {
			//去掉该文本框中的首尾空格
			var name = $.trim($(this).val());
			//判断商品名称是否为空
			if (name!=""){
				//使用ajax请求服务器端
				$.ajax({
					//请求URL
					url:"${pageContext.request.contextPath}/NameCheckAjaxServlet",
					//请求类型
					type:"POST",
					//请求的参数
					data:{name:name},
					//服务器预期返回的类型
					dataType:"json",
					//请求成功
					success:getJsonData,
					//请求失败
					error:sendErrorMsg
				});
			}
		});

		function getJsonData(data,textStatus,jqXHR) {
			//判断商品名称是否重复
			if (data.result==true){
				//在span标签中显示商品名称重复（该字体颜色为红色）
				$("span").text("商品名称重复").css("color","red");
				//将该表单的提交按钮置灰（该按钮不可用）
				//$("input[type=submit]").attr("disabled","disabled");
				$("input[type=submit]").attr("disabled",true);
			} else {
				//将span标签中的内容清空
				$("span").text("");
				//将按钮重置为可用状态
				$("input[type=submit]").removeAttr("disabled");
			}
		}

		function sendErrorMsg(data,textStatus,jqXHR) {
			alert("请求失败！");
		}
	</script>
</body>
</html>