<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		 
	  $("#imgs").click(function(){	   
	   if($("#name").val()==""){
		   alert("请输入所查询书名字！ ");
	   }
	   if($("#name").val()!=""){
		   $("#froms").submit();
	   }
	  });
	});
</script>



<div id="divmenu">
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=1">文学</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=2">生活</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=3">计算机</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=4">外语</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=5">经管</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=6">励志</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=7">社科</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=8">学术</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=9">少儿</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=10">艺术</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=11">原版</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=12">科技</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=13">考试</a>
	<a
		href="${pageContext.request.contextPath}/product/findAction_findAllcategory.action?category2=14">生活百科</a>
	<a href="${pageContext.request.contextPath}/product/findAction_findAllweb.action" style="color:#FFFF00">全部商品目录</a>
		
</div>
<div id="divsearch">
	<form action="${pageContext.request.contextPath}/product/findAction_findPname.action" method="post" id="froms">
		
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input type="text" name="name" class="inputtable" onkeyup="searchName();"id="name"  /> 
					<img id="imgs" src="${pageContext.request.contextPath}/images/serchbutton.gif" border="0" style="margin-bottom:-4px">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
				</td>
			</tr>
		</table>

	</form>
</div>
<div id="content"
	style="background-color:white;width:128px; text-align:left;margin-left:945px;color:black;float:left;margin-top: -20px;display: none">
</div>