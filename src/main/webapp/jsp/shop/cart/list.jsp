<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>cartlist.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<c:url value='/jsp/shop/jquery/jquery-1.5.1.js'/>"></script>
	<script src="<c:url value='/jsp/shop/js/round.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/cart/list.css?version=2018052715'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/top.css?version=20180411'/>">
<style type="text/css">
body{
	margin:0px;
}	
</style>
	
<script type="text/javascript">


	
$(function() {
	showTotal();//计算总计	
	//给全选checkbox添加click事件
	$("#selectAll").click(function() {
		//获取全选状态
		var bool = $("#selectAll").attr("checked");
		//让所有checkbox状态与全选checkbox保持一致
		setItemCheckBox(bool);
		//让结算按钮与全选checkbox保持一致
		setJieSuan(bool);
		//重新计算总计
		showTotal();
	});
	//给所有条目的复选框添加click事件
	$(":checkbox[name=cartitemid]").click(function() {
		var all = $(":checkbox[name=cartitemid]").length;//所有条目的个数
		var select = $(":checkbox[name=cartitemid][checked=true]").length;//获取所有被选择条目的个数

		if(all == select) {//全都选中了
			$("#selectAll").attr("checked", true);//勾选全选复选框
			setJieSuan(true); //让结算按钮有效
		} else if(select == 0) {//谁都没有选中
			$("#selectAll").attr("checked", false);//取消全选
			setJieSuan(false);//让结算失效
		} else {
			$("#selectAll").attr("checked", false);//取消全选
			setJieSuan(true);//让结算有效				
		}
		showTotal();//重新计算总计
	});
	//给减号添加click事件
	$(".jian").click(function() {
		// 获取cartItemId
		var id = $(this).attr("id");
		id = id.substring(0, id.length-4);
		// 获取输入框中的数量
		var quantity = $("#" + id + "Quantity").val();
		// 判断当前数量是否为1，如果为1,那就不是修改数量了，而是要删除了。
		if(quantity == 1) {
			if(confirm("您是否真要删除该条目？")) {
				delCartitem(id,false);
			}
		} else {
			sendUpdateQuantity(id, Number(quantity)-1);
		}
	});
	// 给加号添加click事件
	$(".jia").click(function() {
		// 获取cartItemId
		var id = $(this).attr("id");
		id = id.substring(0, id.length-3);
		// 获取输入框中的数量
		var quantity = $("#" + id + "Quantity").val();
		
		sendUpdateQuantity(id, Number(quantity)+1);
	});
});

// 请求服务器，修改数量。
function sendUpdateQuantity(id, quantity) {
	var params = {
			"cartitemid":id,
			"quantity":quantity
	    };
	$.ajax({
	       type:"POST",
	       ansyc:false,
	       url: "${pageContext.request.contextPath}/cartitem/updateQuantity",
	       dataType:"json",
	       contentType : 'application/json;charset=UTF-8',
	       data: JSON.stringify(params),
		success:function(data) {
			if(data.flag){
				// 修改数量
				$("#" + id + "Quantity").val(quantity);
				//修改小计
				var singlePrice = $("#" + id + "price").text();
				$("#" + id + "Subtotal").text(round(Number(singlePrice)*quantity,2)); 
				//3. 重新计算总计
				showTotal();
			}else{
				alert("出错啦！");
			}
		}
	});
}
//计算总价格
function showTotal() {
	var total = 0;
	//遍历所有选中项
	$(":checkbox[name=cartitemid][checked=true]").each(function() {
		//获取复选框的值
		var id = $(this).val();
		//再通过前缀找到小计元素，获取其文本
		var text = $("#" + id + "Subtotal").text();
		//累加计算
		total += Number(text);
	});
	//把总计显示在总计元素上
	$("#total").text(round(total, 2));//round()函数的作用是把total保留2位
}
//统一设置所有条目的复选按钮
function setItemCheckBox(bool) {
	$(":checkbox[name=cartitemid]").attr("checked", bool);
}
//设置结算按钮样式
function setJieSuan(bool) {
	if(bool) {
		$("#jiesuan").removeClass("kill").addClass("jiesuan");
		$("#jiesuan").unbind("click");//撤消当前元素止所有click事件
	} else {
		$("#jiesuan").removeClass("jiesuan").addClass("kill");
		$("#jiesuan").click(function() {return false;});
	}
	
}
//结算
function jiesuan() {
	// 1. 获取所有被选择的条目的id，放到数组中
	/* var cartItemIdArray = new Array();
	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
	});	
	// 2. 把数组的值toString()，然后赋给表单的cartItemIds这个hidden
	$("#cartItemIds").val(cartItemIdArray.toString());
	// 把总计的值，也保存到表单中
	$("#hiddenTotal").val($("#total").text()); */
	// 3. 提交这个表单
	var select = $(":checkbox[name=cartitemid][checked=true]").length;//获取所有被选择条目的个数
	if(select>0){
		$("#jieSuanForm").submit();
	}
	else{
		alert("您还未选择任何图书！");
	}
}
</script>
  </head>
  <body>
<div class="listmain">
	<div class="listTop" style="font-size: 10pt;">
		<div class="current">&nbsp;当前位置：
			<a href="${pageContext.request.contextPath}/bookShop/toBookList" style="color:#6E6E6E;">书店</a> &gt;      
			<a href="#" style="color:#6E6E6E;">购物车</a>
			<!-- <a href="#" style="float:right;margin-right:10px">退出</a> -->
			<div style="float:right;margin-right:5px">
			<%-- 根据用户是否登录，显示不同的链接 --%>
			<c:choose>
				<c:when test="${empty sessionScope.user }">
					  <%-- <a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">会员登录</a> |&nbsp; 
					  <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册会员</a>	 --%>
					  <a href="${pageContext.request.contextPath}/jsp/shop/body.jsp" >登录</a> |&nbsp; 
					  <a href="#" >注册</a>	
				</c:when>
				<c:otherwise>
					      您好：${sessionScope.user.username }&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="${pageContext.request.contextPath}/cartitem/getCartitem" >
					  			我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="<c:url value='/order/toOrderList'/>" >我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
					  <a href="${pageContext.request.contextPath}/user/loginout" >退出</a>&nbsp;&nbsp;&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</div>
		</div>
		
		
		
		<h1 style="text-align: center;">二手旧书网</h1>
	</div>

<c:choose>
	<c:when test="${empty itemList }">
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
	<form id="jieSuanForm" action="<c:url value='/order/createNewOrder'/>" method="post">
<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<input type="checkbox" id="selectAll"/><label for="selectAll">全选</label>
		</td>
		<td colspan="2">商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>



<c:forEach items="${itemList }" var="cartDetails">
	<tr align="center">
	<c:choose>
		<c:when test="${cartDetails.cartitemid eq selectCartitemid}">
			<td align="left">
			<input value="${cartDetails.cartitemid }" type="checkbox" name="cartitemid" id="cartitemid" checked/>
			</td>
		</c:when>
		<c:otherwise>
			<td align="left">
			<input value="${cartDetails.cartitemid }" type="checkbox" name="cartitemid" id="cartitemid"/>
			</td>
		</c:otherwise>
	</c:choose>
		<td align="left" width="70px">
			<a class="linkImage" href="<c:url value='/bookShop/getBookItems?lsbn=${cartDetails.lsbn }'/>"><img border="0" width="54" align="top" src="${pageContext.request.contextPath}/book_img/${cartDetails.imageb }"/></a>
		</td>
		<td align="left" width="400px">
		    <a href="<c:url value='/bookShop/getBookItems?lsbn=${cartDetails.lsbn }'/>"><span>${cartDetails.name }</span></a>
		</td>
		<td><span>&yen;<span class="currPrice" id="${cartDetails.cartitemid }price" >${cartDetails.currprice }</span></span></td>
		<td>
			<a class="jian" id="${cartDetails.cartitemid }Jian"></a><input class="quantity" readonly="readonly" id="${cartDetails.cartitemid }Quantity" type="text" value="${cartDetails.num }"/><a class="jia" id="${cartDetails.cartitemid }Jia"></a>
		</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartDetails.cartitemid }Subtotal">${cartDetails.total }</span></span>
		</td>
		<td>
			<a href="javascript:delCartitem(${cartDetails.cartitemid },true)">删除</a>
		</td>
	</tr>
</c:forEach>


	<tr>
		<td colspan="4" class="tdBatchDelete">
			<a href="javascript:batchDeleteCartitem();">批量删除</a>
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href="javascript:jiesuan();" id="jiesuan" class="jiesuan"></a>
		</td>
	</tr>
</table>
	
		<input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="total" id="hiddenTotal"/>
		<input type="hidden" name="method" value="loadCartItems"/>
	</form>

	</c:otherwise>
</c:choose>
</div>
  </body>
  <script type="text/javascript">
	  function delCartitem(param,showAlert){
		  if(showAlert){
			  if(window.confirm("您确定要删除该商品吗？"))
			     document.location="${pageContext.request.contextPath}/cartitem/deleteCartitem?cartitemid="+param
	  	  }else
	  		document.location="${pageContext.request.contextPath}/cartitem/deleteCartitem?cartitemid="+param
	  }
	  
	  /*
	   * 批量删除
	   */
	  function batchDeleteCartitem() {
		var select = $(":checkbox[name=cartitemid][checked=true]").length;//获取所有被选择条目的个数
		if(select>0){
	  	if(window.confirm("您确定要删除这些商品吗？")){
		  	var cartItemIdArray = new Array();
		  	$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
		  		cartItemIdArray.push($(this).val());//把复选框的值添加到数组中
		  	});
		  	location = "${pageContext.request.contextPath}/cartitem/batchDeleteCartitem?cartitemids=" + cartItemIdArray;
	 	 }
		}else{
			alert("您还未选择任何商品！");
		}
	  }
  </script>
</html>
