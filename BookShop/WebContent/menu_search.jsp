<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js">
	
</script>
<script type="text/javascript">
<!--
	function fillNameValue(subDiv) {
		document.getElementById("name").value = subDiv.innerHTML;
		
		document.getElementById("content").style.display="none";
	}

	function searchName() {
		var nameElement = document.getElementById("name");
		//获取输入的信息
		var nameValue = nameElement.value;

		var div = document.getElementById("content");
		div.innerHTML = "";
		//1.获取XMLHttpRequest对象
		var xmlhttp = getXMLHttpRequest();

		//2.绑定回调函数
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				var jsonObj = eval("(" + xmlhttp.responseText + ")");
				
				if(jsonObj.length>0){
					document.getElementById("content").style.display="block";
					for ( var i = 0; i < jsonObj.length; i++) {
						div.innerHTML += "<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"
								+ jsonObj[i] + "</div>"
					}
				}

			}
		};
		//3.open
		xmlhttp.open("GET",
				"${pageContext.request.contextPath}/findProductName?name="
						+ window.encodeURIComponent(nameValue, "utf-8")
						+ "&time=" + new Date().getTime());
		//4.send
		xmlhttp.send(null);
	};
	
	function changeBackground_over(div){
		div.style.background="gray";
	}
	
	function changeBackground_out(div){
		div.style.background="white";
	}
//-->

</script>

<div id="divmenu">
	<a
		href="product/findAction_findAllcategory.action?category2=aaa">文学</a>
	<a
		href="product/findAction_findAllcategory.action?category2=aaa">生活</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">计算机</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">外语</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">经管</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">励志</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">社科</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">学术</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">少儿</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">艺术</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">原版</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">科技</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">考试</a>
	<a
		href="product/findAction_findAllcategory.action?category2=计算机">生活百科</a>
	<a href="product/findAction_findAllweb.action" style="color:#FFFF00">全部商品目录</a>
		
</div>
<div id="divsearch">
	<form action="product/findAction_findPname.action" method="post">
		
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input type="text" name="name" class="inputtable" onkeyup="searchName();"id="name" /> 
					<input type="image" src="${pageContext.request.contextPath}/images/serchbutton.gif" border="0" style="margin-bottom:-4px">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
				</td>
			</tr>
		</table>

	</form>
</div>
<div id="content"
	style="background-color:white;width:128px; text-align:left;margin-left:945px;color:black;float:left;margin-top: -20px;display: none">
</div>