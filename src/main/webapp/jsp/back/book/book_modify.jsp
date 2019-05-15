<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>修改信息</title>
                   <link rel="stylesheet" href="layui/css/layui.css"  media="all">
          <link href="jsp/css/style.css" rel="stylesheet" type="text/css"/>
	       <script language="JavaScript" src="jsp/js/jquery.js"></script>
           <script src="layer/layer.js"></script>
           <script src="layui/layui.js" charset="utf-8"></script>
   
    </head>
	<body>
		
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">书籍列表</a></li>
        <li><a href="#">修改信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改信息</span></div>
     <form action="${pageContext.request.contextPath}/book/modifyBookSubmit" id="modForm"method="post">
    <ul class="forminfo">
     
      <li><label>书籍名</label><input name="name" id="name" type="text" value="${bookCustom.name }" class="dfinput"/></li>
      <li><label>lsbn编号</label><input name="lsbn" id="lsbn" type="text" onBlur = "vilidateLsbn()" value="${bookCustom.lsbn }" class="dfinput"/></li>
      <li><label>作者</label><input name="author" id="author" type="text" value="${bookCustom.author }" class="dfinput"/></li>
      <li><label>书籍类型</label>
           <select id="type" name="type" class="dfinput" >
        		<c:forEach items="${typeList }" var="type">
        			<option value="${type.name }" 
        				<c:if test="${type.name eq bookCustom.type}">selected</c:if>>
        			${type.name }</option>
        		</c:forEach>
           </select>
      </li>
      <li><label>原价</label><input name="price" id="price" type="text" value="${bookCustom.price }" class="dfinput"/></li>
      <li><label>出售价</label><input name="currprice" id="currprice" type="text" value="${bookCustom.currprice }" class="dfinput"/></li>
      <li><label>出版社</label><input name="press" id="press" type="text" value="${bookCustom.press }" class="dfinput"/></li>
      <li><label>出版时间</label><input name="publishtime" id="publishtime" type="text" value="${bookCustom.publishtime }" class="dfinput"/></li>
      <li><label>版次</label><input name="edition" id="edition" type="text" value="${bookCustom.edition }" class="dfinput"/></li>
      <li><label>页数</label><input name="pagenum" id="pagenum" type="text" value="${bookCustom.pagenum }" class="dfinput"/></li>
      <li><label>字数</label><input name="wordnum" id="wordnum" type="text" value="${bookCustom.wordnum }" class="dfinput"/></li>
      <li><label>纸质</label><input name="paper" id="paper" type="text" value="${bookCustom.paper }" class="dfinput"/></li>
      <li><label>印刷时间</label><input name="printtime" id="printtime" type="text" value="${bookCustom.printtime }" class="dfinput"/></li>
      <li><label>大小</label><input name="booksize" id="booksize" type="text" value="${bookCustom.booksize }" class="dfinput"/></li>
      <li><label>图片</label><img src="${pageContext.request.contextPath}/book_img/${bookCustom.imageb }"  height="200"></li>
      <li><label>&nbsp;</label><input name="image" id="image" type="file" class="dfinput"/></li>
      <li><label>书籍介绍</label>
        <textarea rows="5" cols="20" class="dfinput" id="description" name="description">${bookCustom.description }</textarea>
		</li>
      <%-- <input type="hidden" id="type" value="${bookInfo.bookTypeIsbn}"/> --%>
        <li><label>&nbsp;</label><input name="save" id="save" type="submit" class="btn" value="保存" id="save"/></li>
    </ul>
    </form>
</div>
	</body>
	
		<script language="javascript">
		function vilidateLsbn(){
		   var lsbn = document.getElementById("lsbn").value
		   if(lsbn.length<10){
		      alert("请输入正确的lsbn编号(至少10位)!");
		      return;
		   }
		}
		</script>
</html>