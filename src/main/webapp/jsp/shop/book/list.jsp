<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/search/css/normalize.css'/>">
	<link rel="stylesheet" href="<c:url value='/jsp/search/css/font-awesome.min.css'/>">
	<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/jsp/search/css/demo.css'/>"> --%>
	<link rel="stylesheet" href="<c:url value='/jsp/search/css/style.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/ranking.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/top.css?version=20180329'/>">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/shop/css/book/list.css?version=20180328'/>">
	<script type="text/javascript" src="<c:url value='/jsp/shop/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/shop/js/book/list.js'/>"></script>

	
	
  </head>
  
  <body>
<div class="listmain">
	<div class="listTop" style="font-size: 10pt;">
		<div class="current">&nbsp;当前位置：
			<a href="${pageContext.request.contextPath}/bookShop/toBookList" style="color:#6E6E6E;">书店</a> &gt;      
			<a href="${pageContext.request.contextPath}/bookShop/toBookList" style="color:#6E6E6E;">图书列表</a>
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
					      您好：<a href="<c:url value='/user/frontToBack'/>" title="点击跳转到后台管理系统...">${sessionScope.user.username }</a>&nbsp;&nbsp;|&nbsp;&nbsp;
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
	<div class="search d1" >
	  <form id="searchForm" action="${pageContext.request.contextPath}/bookShop/queryBook">
	  		<%-- <a href="javascript:document.getElementById('form1').submit();"><img align="top" border="0" src="../shop/images/btn.bmp"/></a>
    		<a href="<c:url value='/shop/gj.jsp'/>" style="font-size: 10pt; color: #404040;" target="body">高级搜索</a> --%>
		  <input id="lsbn_name_type" name="lsbn_name_type" type="text" placeholder=" lsbn/类型/书名..." value="${lsbn_name_type }" />
		  <button type="submit"></button>
	  </form>
	</div>
	<div id="listright" >
	<div>
		<ul>
		<c:forEach items="${bookList }" var="book">
		  <li>
		  <div class="inner">
		   <a class="pic" href="${pageContext.request.contextPath}/bookShop/getBookItems?lsbn=${book.lsbn }"><img src="${pageContext.request.contextPath}/book_img/${book.imageb }" border="0"/></a>
		    <p class="price">
				<span class="price_n">&yen;${book.currprice }</span>
				<span class="price_r">&yen;${book.price }</span>
				(<span class="price_s">${book.discount }折</span>)
			</p>
			<p><a id="bookname" title="${book.name }" href="<c:url value='#'/>">${book.name }</a></p>
			<%-- url标签会自动对参数进行url编码 --%>
			<c:url value="#" var="authorUrl">
				<c:param name="author" value="${book.author }"/>
			</c:url>
			<c:url value="#" var="pressUrl">
				<c:param name="press" value="${book.press }"/>
			</c:url>
			<p><a href="#" name='P_zz' title='${book.author }'>${book.author }</a></p>
			<p class="publishing">
				<span>出 版 社：</span><a href="${pressUrl }">${book.press }</a>
			</p>
			<p class="publishing_time"><span>出版时间：</span>${book.publishtime }</p>
			<p class="price_s"><span>发布者： ${book.username }</span></p>
		  </div>
		  </li>
		</c:forEach>
		
		</ul>
	</div>
	<div class="page" >
		<table style="font-family:FZYaoti;font-size:14px;width:100%;">
	    	<tr style="height:30px;float:right">
				<td width="40"><a href = "javascript:toBookListByPage(1)" >首页</a></td>
				<td width="50"><a href = "javascript:toBookListByPage(${pageNumNow-1 })" >上一页 </a></td>
			<c:forEach items="${requestScope.pageList }" var="pageNum">
				<c:choose>
				<c:when test="${pageNumNow eq pageNum }">
					<td width="20" ><a style="color:#000000" href = "javascript:toBookListByPage(${pageNum })" >${pageNum }</a></td>
				</c:when>
				<c:otherwise>
					<td width="20" ><a href = "javascript:toBookListByPage(${pageNum })" >${pageNum }</a></td>
				</c:otherwise>
				</c:choose>
			</c:forEach>
				<td width="50"><a href = "javascript:toBookListByPage(${pageNumNow+1 })" >下一页</a></td>
				<td width="50"><a href = "javascript:toBookListByPage(${pageNumTotal })" >尾页</a></td>
				<td>第${pageNumNow }页/共${requestScope.pageNumTotal }页 </td>
			</tr>	
		</table>
	</div>
	
	</div>
	
	<div id="listleft"> 
		<!-- <br><br><br><br><br><br><br><br><br><br><br>图书分类/公告......
		<br><br><br><br><br><br><br><br><br><br><br>图书分类/公告......
		<br><br><br><br><br><br><br><br><br><br><br>图书分类/公告......
		<br><br><br><br><br><br><br><br><br><br><br>图书分类/公告......		 -->
		<div class="ranking">
		<div class="box2" id="book_rank">
			  <h2><a href="#" class="more">更多</a>销售排行榜</h2>
			  <div class="rankinner">
			    <ul class="rank_list">
			        <li class="top3"><em>1</em><a title="Java Web整合开发实战"  href="#">
			Java Web整合开发实</a><span>621</span></li>
				    <li class="top3"><em>2</em><a title="OSGi实战" href="#">
			OSGi实战</a><span>589</span></li>
					<li class="top3"><em>3</em><a title="Java核心技术：卷Ⅰ基础知识（原书第8版）"   href="#">
			Java核心技术：卷Ⅰ基础知识（原书第8版）</a><span>532</span></li>
					<li  ><em>4</em><a title="Java7入门经典"   href="#">
			Java7入门经典</a><span>456</span></li>
					<li  ><em>5</em><a title="Java深入解析——透析Java本质的36个话题"   href="#">
			Java深入解析——透析Java本质的36个话题</a><span>431</span></li>
					<li  ><em>6</em><a title="Struts2技术内幕：深入解析Struts架构设计与实现原理"   href="#">
			Struts2技术内幕：深入解析Struts架构设计与实现原理</a><span>387</span></li>
					<li  ><em>7</em><a title="Tomcat与Java Web开发技术详解（第2版）"   href="#">
			Tomcat与Java Web开发技术详解（第2版）</a><span>335</span></li>
					<li  ><em>8</em><a title="基于MVC的JavaScript Web富应用开发"   href="#">
			基于MVC的JavaScript Web富应用开发</a><span>256</span></li>
					<li  ><em>9</em><a title="HTML5+JavaScript动画基础"   href="#">
			HTML5+JavaScript动画基础</a><span>153</span></li>
					<li  ><em>10</em><a title="深入浅出Ext JS(第3版)"   href="#">
			深入浅出Ext JS(第3版)</a><span>78</span></li>
			    </ul>
			  </div>
			</div>
			</div>
			
			<br>
			
			<div class="ranking">
		<div class="box2" id="book_rank">
			  <h2><a href="#" class="more">更多</a>人气排行榜</h2>
			  <div class="rankinner">
			    <ul class="rank_list">
			    	<li class="top3"><em>1</em><a title="Tomcat与Java Web开发技术详解（第2版）"   href="#">
			Tomcat与Java Web开发技术详解（第2版）</a><span>335</span></li>
			        <li class="top3"><em>2</em><a title="Java Web整合开发实战"   href="#">
			Java Web整合开发实</a><span>621</span></li>
					<li class="top3"><em>3</em><a title="基于MVC的JavaScript Web富应用开发"   href="#">
			基于MVC的JavaScript Web富应用开发</a><span>256</span></li>
				    <li  ><em>4</em><a title="Struts2技术内幕：深入解析Struts架构设计与实现原理"   href="#">
			Struts2技术内幕：深入解析Struts架构设计与实现原理</a><span>387</span></li>
					<li ><em>5</em><a title="Java核心技术：卷Ⅰ基础知识（原书第8版）"   href="#">
			Java核心技术：卷Ⅰ基础知识（原书第8版）</a><span>532</span></li>
					<li  ><em>6</em><a title="深入浅出Ext JS(第3版)"   href="#">
			深入浅出Ext JS(第3版)</a><span>78</span></li>
					<li  ><em>7</em><a title="Java深入解析——透析Java本质的36个话题"   href="#">
			Java深入解析——透析Java本质的36个话题</a><span>431</span></li>
					<li  ><em>8</em><a title="Java7入门经典"   href="#">
			Java7入门经典</a><span>456</span></li>
					<li  ><em>9</em><a title="HTML5+JavaScript动画基础"   href="#">
			HTML5+JavaScript动画基础</a><span>153</span></li>
					<li ><em>10</em><a title="OSGi实战"   href="#">
			OSGi实战</a><span>589</span></li>
					
			    </ul>
			  </div>
			</div>
			</div>
		</div>
</div>	

  </body>
 
 <script type="text/javascript">
 	//按条件搜索后翻页问题
 	function toBookListByPage(pageNum){
 		var lsbn_name_type = $('#lsbn_name_type').val();
 		if(lsbn_name_type==""){//先判断搜索框内是否有搜索条件，无则直接翻页
 			window.location.href = "${pageContext.request.contextPath}/bookShop/toBookList?pageNumNow="+pageNum
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

