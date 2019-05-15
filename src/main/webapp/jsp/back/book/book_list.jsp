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
		<title>H5模版:</title>
<link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jsp/js/jquery.js"></script></head>
    <body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">书籍列表</a></li>
    </ul>
    </div>

     <div class="tools">
    
  
    <form action="${pageContext.request.contextPath}/book/queryBook" id="searchForm" method="POST">
    	<table>
    		<tr>
    			<td>
    				<li><label>&nbsp;&nbsp;综合查询</label>
    				<input name="lsbn_name_type" id="lsbn_name_type" type="text" class="scinput" placeholder="lsbn编号/书名/图书类型" value="${lsbn_name_type }"/>
    				</li>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td class="scbtn">
    				<!-- 需要获取表单中输入框的数据，所以提交表单 -->
    				<a type="submit" onclick="document:searchForm.submit()" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;查询书籍</a>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<td class="scbtn">
    				<a href="${pageContext.request.contextPath}/book/addBook" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;添加书籍</a>
    			</td>
    			<td>&nbsp;&nbsp;</td>
    			<!-- <td class="scbtn">
    				<a href="#" 
    				target="rightFrame" style="color:#FFFFFF;font-size:15px;">&nbsp;&nbsp;&nbsp;删除书籍</a>
    			</td> -->
    		</tr>
    	</table>
    </form>

        
    </div>
     
    <table class="tablelist">
    	<thead>
    	<tr style="text-align:center">
    	<th style="text-align:center">&nbsp;</th>
        <th style="text-align:center">书籍编号</th>
        <th style="text-align:center">书籍类型</th>
        <th style="text-align:center">书籍名</th>
        <th style="text-align:center">作者</th>
        <th style="text-align:center">原价</th>
        <th style="text-align:center">现价</th>
        <th style="text-align:center">&nbsp;</th>
        <th style="text-align:center">&nbsp;</th>
        </tr>
        </thead>
        <tbody id="tbody">
        
       <c:forEach items="${bookList}" var="book" varStatus="vs">
                <c:set var="index" value="${index+1}" />
          <tr style="text-align:center" >
          <%-- onclick="parent.location='${pageContext.request.contextPath}/book/getBookItems?lsbn=${book.lsbn }'" --%>
          	<%-- <td width="5%"><input type="checkbox" name="lsbn" value="${book.lsbn }"/></td> --%>
          	<td width="3%">${8*(pageNumNow-1)+index }</td>
	        <td width="16%">
	        	<c:choose>	
		    		<c:when test="${fn:length(book.lsbn) >= 15}">     		
		        		<span class="spa2" title="${book.lsbn}">${fn:substring(book.lsbn,0,15)}……</span>
		     		</c:when>
			     	<c:otherwise>
			         	<span class="spa2" title="${book.lsbn}">${book.lsbn}</span>
			     	</c:otherwise>
		 		</c:choose>
	        </td>
	        <td width="10%">${book.type }</td>
	         <td width="31%">
	         <!-- 实现字数过多是自动用.....代替，鼠标移过去显示全部 -->
		         <c:choose>	
		    		<c:when test="${fn:length(book.name) >= 25}">     		
		        		<span class="spa2" title="${book.name}">${fn:substring(book.name,0,25)}……</span>
		     		</c:when>
			     	<c:otherwise>
			         	<span class="spa2" title="${book.name}">${book.name}</span>
			     	</c:otherwise>
		 		</c:choose>
	         </td>         
	        <td width="12%">
	        	<c:choose>	
		    		<c:when test="${fn:length(book.author) >= 7}">     		
		        		<span class="spa2" title="${book.author}">${fn:substring(book.author,0,7)}……</span>
		     		</c:when>
			     	<c:otherwise>
			         	<span class="spa2" title="${book.author}">${book.author}</span>
			     	</c:otherwise>
		 		</c:choose></td>
	        <td width="9%">${book.price }</td>
	         <td width="9%">${book.currprice}</td>
	         <td width="5%"><a href="${pageContext.request.contextPath}/book/modifyBook?lsbn=${book.lsbn }" style="color:#4876FF;">修改</a></td>
	         <td width="5%"><a href="${pageContext.request.contextPath}/book/deleteBook?lsbn=${book.lsbn }" style="color:#6495ED;">删除</a></td>
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
			<td width="30"><a href = "javascript:toBookListByPage(1)" >首页</a></td>
			<td width="50"><a href = "javascript:toBookListByPage(${pageNumNow-1 })" >上一页 </a></td>
		<c:forEach items="${requestScope.pageList }" var="pageNum">
			<td width="20" ><a href = "javascript:toBookListByPage(${pageNum })" >${pageNum }</a></td>
		</c:forEach>
			<td width="50"><a href = "javascript:toBookListByPage(${pageNumNow+1 })" >下一页</a></td>
			<td width="50"><a href = "javascript:toBookListByPage(${pageNumTotal })" >尾页</a></td>
			<td>第${pageNumNow }页/共${requestScope.pageNumTotal }页 </td>
		</tr>	
	</table>
   
    </div>

	</body>
	
	<script type="text/javascript">
	  function modifyBook(param){
			  document.location="${pageContext.request.contextPath}/book/modifyBook?lsbn="+param
	  }
	
	  function delBook(param){
		 if(window.confirm("您确定要删除这本书吗？"))
			  document.location="${pageContext.request.contextPath}/book/deleteBook?lsbn="+param
	  }
	  
	//按条件搜索后翻页问题
	 function toBookListByPage(pageNum){
	 	var lsbn_name_type = $('#lsbn_name_type').val();
	 	if(lsbn_name_type==""){//先判断搜索框内是否有搜索条件，无则直接翻页
	 		window.location.href = "${pageContext.request.contextPath}/book/toBookList?pageNumNow="+pageNum
	 	}else{//有条件，先追加页码参数，后提交搜索框的form
	 		var searchForm=$('#searchForm'); //得到form对象
	         var tmpInput=$("<input type='text' name='pageNumNow'/>");
	         tmpInput.attr("value", pageNum);
	         searchForm.append(tmpInput);
	         searchForm.submit();
	 		/* document.getElementById("searchForm").action="${pageContext.request.contextPath}/bookShop/queryBook?pageNumNow="+pageNum+"&lsbn_name_type="+lsbn_name_type
	 		debugger
	 		document.getElementById("searchForm").submit(); */
	 	}
	 }
	  </script>
	  
	  
</html>