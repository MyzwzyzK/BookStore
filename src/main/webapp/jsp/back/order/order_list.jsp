<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
<head>

		<base href="${basePath}">
		<meta charset="UTF-8">
		<title>H5模版:</title>
		<link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="jsp/js/jquery.js"></script>
<script type="text/javascript">
$(function() {
	/* var sel=document.getElementById(".status");
	sel.onchange = function(){
		alert("change");
	}  */
	//搜索栏订单类型下拉选框设置监听
	$("#orderStatus").change(function() {
		 var selected=$(this).children('option:selected').val();
		 window.location.href="${pageContext.request.contextPath }/order/queryOrderByStatus?status="+selected;
	});
	 //给所有订单状态的下拉选框设置监听事件
	 $(".status").change(function() {
		alert("确定要修改该订单状态吗？");
		 var selected=$(this).children('option:selected').val();
		 var id = $(this).attr("id");
		 //alert(id);
		 id = id.substring(0, id.length-6);
		// alert(id);
		 sendUpdateStatus(Number(id),selected);
	});  
});
//请求服务器，修改订单状态
function sendUpdateStatus(id, status) {
	var params = {
			"id":id,
			"status":status
	    };
	$.ajax({
	       type:"POST",
	       ansyc:false,
	       url: "${pageContext.request.contextPath}/order/updateStatus",
	       dataType:"json",
	       contentType : 'application/json;charset=UTF-8',
	       data: JSON.stringify(params),
		success:function(data) {
			if(data.flag){
				alert("修改成功！");
			}else{
				alert("出错啦！");
			}
		}
	});
}
</script>  
</head>
    
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">订单列表</a></li>
    </ul>
    </div>

	<c:if test="${identity eq 'admin'}">
     <div class="tools">
    	  <ul class="seachform">
    
	    <form action="order/queryOrderByOrderid" method="POST" >
			    
	             <li><label>&nbsp;&nbsp;订单类型：</label>
	                <select id="orderStatus" name="orderStatus" class="scinput">
	                	<option value="全部">全部</option>
	                <c:forEach items="${orderStatusList}" var="curstatus">
	                	<option value="${curstatus}" <c:if test="${selectedStatus!=null && selectedStatus eq curstatus}">selected</c:if>>${curstatus}</option>
	                </c:forEach>
	                </select>
	             </li>
	             <li><label>订单号：</label><input name="orderid_input" id="orderid_input" type="text" class="scinput" placeholder="订单号"/></li>
			    <li><label>&nbsp;</label><input  type="submit" class="scbtn" id="sel" value="查询订单"/></li>
	    </form>   
	    </ul>     
    </div>
    </c:if>
    
  
    
    
    <table class="tablelist">
    	<thead>
    	<tr style="text-align:center">
    	<th style="text-align:center">&nbsp;</th>
        <th style="text-align:center">订单号</th>
        <th style="text-align:center">订单时间</th>
        <th style="text-align:center">订单状态</th>
        <th style="text-align:center">总金额</th>
        <th style="text-align:center">下单者</th>
        </tr>
        </thead>
        <tbody id="tbody">
        
       <c:forEach items="${orderList}" var="order" varStatus="vs">
                <c:set var="index" value="${index+1}" />
          <tr style="text-align:center">
          			<td width="5%">${index }</td>
                    <td width="35%">${order.orderid }</td>
                    <td width="20%"><fmt:formatDate value='${order.ordertime }' type='date' pattern='yyyy年MM月dd HH:mm:ss'/></td>
                    <td width="20%">
                    	<select id="${order.id }status" class="scinput status" 
                    		<c:if test="${orderType eq 'purchase' }">disabled="disabled"</c:if>>
	                    	<c:forEach items="${orderStatusList}" var="curstatus">
		                	<option value="${curstatus}" <c:if test="${order.status eq curstatus}">selected</c:if> >${curstatus}</option>
		                	</c:forEach>
                    	</select>
                    </td>
                    <td width="10%">${order.total  }</td>
                    <td width="10%">${order.username }</td>
                </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr style="text-align:center">           
        <td colspan="8"><div id="demo7"></div></td>
                    </tr>
        </tfoot>
       
    </table>


	</body>
</html>