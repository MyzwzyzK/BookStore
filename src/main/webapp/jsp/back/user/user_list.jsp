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
		<title>后台管理系统</title>
		<link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="jsp/js/jquery.js"></script></head>
    <body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">用户列表</a></li>
    </ul>
    </div>

     <div class="tools">
    
  
    <form action="${pageContext.request.contextPath}/user/queryUser" id="searchForm" method="POST">
    	<table>
    		<tr>
    			<td>
    				<li><label>&nbsp;&nbsp;综合查询</label>
    				<input name="username_loginname" id="username_loginname" type="text" class="scinput" placeholder="用户名/账号"/>
    				</li>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td class="scbtn">
    				<!-- 需要获取表单中输入框的数据，所以提交表单 -->
    				<a type="submit" onclick="document:searchForm.submit()" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;查询用户</a>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td>&nbsp;&nbsp;</td>
    		</tr>
    	</table>
    </form>

        
    </div>
     
    <table class="tablelist">
    	<thead>
    	<tr style="text-align:center">
    	<th style="text-align:center">&nbsp;</th>
    	<th style="text-align:center">用户名</th>
        <th style="text-align:center">账号</th>
        <th style="text-align:center">地址</th>
        <th style="text-align:center">邮编</th>
        <th style="text-align:center">邮箱</th>
        <th style="text-align:center">手机号码</th>
        <th style="text-align:center">权限</th>
        <!-- <th style="text-align:center">&nbsp;</th>
        <th style="text-align:center">&nbsp;</th> -->
        </tr>
        </thead>
        <tbody id="tbody">
        
       <c:forEach items="${userList}" var="user" varStatus="vs">
                <c:set var="index" value="${index+1}" />
          <tr style="text-align:center" >
          	<%-- <td><input type="checkbox" name="userid" value="${user.userid }"/></td> --%>
          	<td>${index}</td>
          	<td>${user.username }</td>
	        <td>${user.loginname }</td>
	        <td>
	        	<c:choose>	
		    		<c:when test="${fn:length(user.address) >= 15}">     		
		        		<span class="spa2" title="${user.address}">${fn:substring(user.address,0,15)}……</span>
		     		</c:when>
			     	<c:otherwise>
			         	<span class="spa2" title="${user.address}">${user.address}</span>
			     	</c:otherwise>
		 		</c:choose>
	        </td>
	        <td>${user.addresscode }</td>
	        <td>${user.email }</td>
	         <td>${user.phone}</td>
	         <td>${user.identity}</td>
	         <!-- <td><a href="#" style="color:#4876FF;">修改</a></td>
	         <td><a href="#" style="color:#6495ED;">删除</a></td> -->
        </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <tr style="text-align:center">           
        <td colspan="8"><div id="demo7"></div></td>
                    </tr>
        </tfoot>
       
    </table>    
    
    <%-- <table style="float:right;">
    	<tr>
			<td width="30"><a href = "${pageContext.request.contextPath}/user/touserList?pageNumNow=1" >首页</a></td>
			<td width="50"><a href = "${pageContext.request.contextPath}/user/touserList?pageNumNow=${pageNumNow-1 }" >上一页 </a></td>
		<c:forEach items="${requestScope.pageList }" var="pageNum">
			<td width="20" ><a href = "${pageContext.request.contextPath}/user/touserList?pageNumNow=${pageNum }" >${pageNum }</a></td>
		</c:forEach>
			<td width="50"><a href = "${pageContext.request.contextPath}/user/touserList?pageNumNow=${pageNumNow+1 }" >下一页</a></td>
			<td width="50"><a href = "${pageContext.request.contextPath}/user/touserList?pageNumNow=${pageNumTotal }" >尾页</a></td>
			<td>第${pageNumNow }页/共${requestScope.pageNumTotal }页 </td>
		</tr>	
	</table> --%>
   
    </div>

	</body>
</html>