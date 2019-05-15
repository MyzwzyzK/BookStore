<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<title>书籍类型</title>
<link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jsp/js/jquery.js"></script></head>

    <body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">书籍类型列表</a></li>
    </ul>
    </div>

     <div class="tools">
    
    	 
    <form id="typeSearchForm" action="${pageContext.request.contextPath}/type/queryType" method="POST">
    	<table>
    		<tr>
    			<td>
    				<li><label>&nbsp;&nbsp;综合查询&nbsp;</label><input name="name_desc" id="name_desc" type="text" class="scinput" placeholder="类名/描述"/></li>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td class="scbtn">
    				<a type="submit" onclick="document:typeSearchForm.submit()" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;查询类型</a>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td class="scbtn">
    				<a href="${pageContext.request.contextPath}/type/addType" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;添加类型</a>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    		</tr>
    	</table>

    </form>
        
    </div>
     
    <table class="tablelist">
    	<thead>
    	<tr style="text-align:center">
    	<th style="text-align:center">&nbsp;</th>
        <!-- <th style="text-align:center">编号</th> -->
        <th style="text-align:center">书籍类名</th>
        <th style="text-align:center">描述</th>
        <th style="text-align:center">&nbsp;</th>
        <th style="text-align:center">&nbsp;</th>
        </tr>
        </thead>
        <tbody id="tbody">
        
       <c:forEach items="${typeList}" var="type" varStatus="vs">
                <c:set var="index" value="${index+1}" />
          <tr style="text-align:center" >
          	<%-- <td><input type="checkbox" name="id" value="${type.id }"/></td> --%>
          	<td width="3%">${8*(pageNumNow-1)+index }</td>
          	<%-- <td>${type.id }</td> --%>
	        <td width="22%">${type.name }</td>
	         <td width="55%">
	         <!-- 实现字数过多是自动用.....代替，鼠标移过去显示全部 -->
		         <c:choose>	
		    		<c:when test="${fn:length(type.description) >= 40}">     		
		        		<span class="spa2" title="${type.description}">${fn:substring(type.description,0,40)}……</span>
		     		</c:when>
			     	<c:otherwise>
			         	<span class="spa2" title="${type.description}">${type.description}</span>
			     	</c:otherwise>
		 		</c:choose>
	         </td>         
	         <td width="10%"><a href="javascript:modifyType(${type.id })" style="color:#4876FF;">修改</a></td>
	         <td width="10%"><a href="javascript:delType(${type.id })" style="color:#6495ED;">删除</a></td>
        </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr style="text-align:center">           
        <td colspan="8"><div id="demo7"></div></td>
                    </tr>
        </tfoot>
       
    </table>    
    
    <table style="float:right;">
    	<tr>
			<td width="30"><a href = "${pageContext.request.contextPath}/type/toTypeList?pageNumNow=1" >首页</a></td>
			<td width="50"><a href = "${pageContext.request.contextPath}/type/toTypeList?pageNumNow=${pageNumNow-1 }" >上一页 </a></td>
		<c:forEach items="${requestScope.pageList }" var="pageNum">
			<td width="20" ><a href = "${pageContext.request.contextPath}/type/toTypeList?pageNumNow=${pageNum }" >${pageNum }</a></td>
		</c:forEach>
			<td width="50"><a href = "${pageContext.request.contextPath}/type/toTypeList?pageNumNow=${pageNumNow+1 }" >下一页</a></td>
			<td width="50"><a href = "${pageContext.request.contextPath}/type/toTypeList?pageNumNow=${pageNumTotal }" >尾页</a></td>
			<td>第${pageNumNow }页/共${requestScope.pageNumTotal }页 </td>
		</tr>	
	</table>
   
    </div>

	</body>
	
	<script type="text/javascript">
	  function modifyType(param){
			  document.location="${pageContext.request.contextPath}/type/modifyType?id="+param
	  }
	
	  function delType(param){
		 if(window.confirm("您确定要删除该类型吗？"))
			  document.location="${pageContext.request.contextPath}/type/deleteType?id="+param
	  }
	  </script>
</html>