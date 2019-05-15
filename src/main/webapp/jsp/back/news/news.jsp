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
<style type="text/css">
.intro{width:100%;height:30px;overflow:hidden;text-overflow:ellipsis;white-space:norwap;}
.img{width:180px; height:130px;}

</style>
        <base href="${basePath}">
        <meta charset="UTF-8">
        <title>H5模版:</title>
         <link rel="stylesheet" href="layui/css/layui.css"  media="all">
        <link href="jsp/css/style.css" rel="stylesheet" type="text/css" />
       <script type="text/javascript" src="jsp/js/jquery.js"></script>
         <script src="layer/layer.js"></script>
        <script src="layui/layui.js" charset="utf-8"></script>
    </head>
   
    <body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
     <div class="tools">
        <ul class="seachform">
        <form action="news/toModifyPage" method="POST">
      <li><label>编号</label><input name="id" id="id"type="text" class="scinput" /></li>
      <li><label>&nbsp;</label><input name="" type="button" class="scbtn" id="sel" value="查询"/></li>
      <li><label>&nbsp;</label><input name="" type="button" id="add" class="scbtn" value="增加"/></li>
      <li><label>&nbsp;</label><input name="" type="button" id="del" class="scbtn" value="删除"/></li>
      <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="修改"/></li>    
         </form>
            </ul>
    </div>
    <ul class="imglist" id="tbody">
 
       <c:forEach items="${list}" var="dogType" varStatus="vs">
                <c:set var="index" value="${index+1}" /> 
    <li class="selected">
    <span style="text-align=center;"><img  class="img" src="news/${news.newsImg }" /></span>
    <h2><a href="javascript:void(0);">&nbsp;&nbsp;&nbsp;&nbsp;标题:${news.newsTitle }</a></h2>
    <h2><a href="javascript:void(0);">&nbsp;&nbsp;&nbsp;&nbsp;编号:${news.id }</a></h2>
    </li>
    </c:forEach>
    </ul>
       <div class="pagin">
        <div class="message"></div>
        <ul class="paginList" id="demo7">
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    <input type="hidden" id="count" value="${count}"/>
    <script type="text/javascript">
     $(function(){
        layui.use(['laypage', 'layer'], function(){
              var laypage = layui.laypage
              ,layer = layui.layer;
              
            
          laypage({
                cont: 'demo7'
                ,pages:$("#count").val()
                ,skip: true
                ,jump: function(obj, first){
                    toLimitit(obj.curr);
                    layer.msg('第 '+ obj.curr +' 页');
                     
                }
              });
          
          
        });
        
         
         
     });
    </script>
   <script type="text/javascript">
      $(function(){
          
          $("#add").on('click',function(){
              
              layer.open({
                  type: 2,
                  area: ['700px', '530px'],
                  fixed: false, //不固定
                  maxmin: true,
                  content: 'jsp/news_add.jsp'
                });
              
              
          });
          $("#sel").on('click',function(){
      		var id=$("#id").val();
     		 $.ajax({
   		       type:"POST",
   		       ansyc:false,
   		       url: "new/getSignalNews",
   		       data:{id:id
   		       },
   		       dataType:"json",
   		       contentType:"application/x-www-form-urlencoded;charset=utf-8",
   		       success:function(data){
   		    	   var info="编号:"+data.news.id+"<br>";
   		    	   info=info+"上传时间:"+data.news.postTime+"<br>";
   		    	   info=info+"<textarea rows=10 cols=30>"+data.news.newsContent+"</textarea><br>";
   		    	   info=info+'图片:<img height=60 width=120 src=news/'+data.news.newsImg+'>';
   		    	   layer.open({
   		    		   type: 0,
   		    		   shade: false,
   		    		   title: false, //不显示标题
   		    		   content: info //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
   		    		 });
   		       }
   		});
      	});
        	$("#del").on('click',function(){
        		var id=$("#id").val();
        		layer.confirm('是否删除该条信息？', {
        			  btn: ['是','否'] //按钮
        			}, function(){
        				 $.ajax({
        				       type:"POST",
        				       url: "news/delNewsById",
        				       data:{id:id
        				       },
        				       dataType:"json",
        				       contentType:"application/x-www-form-urlencoded;charset=utf-8",
        				       success:function(data){
        				    	   if(data.flag){
        				    		   layer.msg('删除成功！', {icon: 1});
        				    		   setTimeout(function(){
        				    			   toLimitit(1);
        				    			 }, 2000);
        				    	   }
        				    	   else{
        				    		   layer.msg('删除失败!');
        				    	   }
        				       }
        				}); 
        			
        			});
        	});
      });
    function toLimitit(tag){
         $.ajax({
               type:"POST",
               url: "news/toTargetNewsPage",
               data:{Page:tag,
               },
               dataType:"json",
               contentType:"application/x-www-form-urlencoded;charset=utf-8",
               success:function(data){
                   $("#tbody").html("");//清空原来的表格，重新生成表格
                   document.getElementById("count").value=data.count;
                   for(var i=0;i<data.list.length;i++)
                     {  
                        $("#tbody").append('<li class=selected id='+i+'>'); 
                        $("#"+i).append('<span><img  class=img  src=news/'+data.list[i].newsImg+'></span>');
                        $("#"+i).append('<h2><a href=javascript:void(0);>&nbsp;&nbsp;&nbsp;&nbsp;名称:'+data.list[i].newsTitle+'</a></h2>');
                        $("#"+i).append('<h2><a href=javascript:void(0);>&nbsp;&nbsp;&nbsp;&nbsp;编号:'+data.list[i].id+'</a></h2></li>');
                     }
                   
               }
        }); 
    } 
   </script> 
    
    
    
    
    </div>


    </body>
</html>