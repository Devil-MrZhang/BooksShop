<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/admin/css/Style.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/jquery/jquery.js"></script>
<script type="text/javascript">
	
	function checkAll() {
		
		var flag=document.getElementById("ckAll").checked;
	
		var ids=document.getElementsByName("ids");
		for (var i = 0; i < ids.length; i++) {
			ids[i].checked=flag;
		}
	}
	
	function delAllBooks(){
		var ids=document.getElementsByName("ids");
		var str="";
		for (var i = 0; i < ids.length; i++) {
			if (ids[i].checked) {
				str+="ids="+ids[i].value+"&";
			}
		}
		if(str!=""){
			
			if(confirm("是否要删除所选中的书籍?")){
				str=str.substring(0,str.length-1);
				location.href="${pageContext.request.contextPath}/admin/AdminAction_delAll?"+str;
			}
			
		}else{
			alert("请选择要删除的书籍")
		}
		
		
		
		
	}
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="./AdminAction_check"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查
							询 条 件</strong>
					</td>
				</tr>
				<tr>
					<td>
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									商品编号</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="cid" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									类别：</td>
								<td class="ta_01" bgColor="#ffffff"><select name="bookid"
									id="category">
										<option value="1" selected="selected">--选择商品类加--</option>
										<option value="1" >文学</option>
										<option value="2">生活</option>
										<option value="3">计算机</option>
										<option value="4">外语</option>
										<option value="5">经营</option>
										<option value="6">励志</option>
										<option value="7">社科</option>
										<option value="8">学术</option>
										<option value="9">少儿</option>
										<option value="10">艺术</option>
										<option value="11">原版</option>
										<option value="12">科技</option>
										<option value="13">考试</option>
										<option value="14">生活百科</option>
								</select></td>
							</tr>

							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									商品名称：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="cname" size="15" value="" id="Form1_userName" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									价格区间(元)：</td>
								<td class="ta_01" bgColor="#ffffff"><input type="text"
									name="minprice" size="10" value="" />- <input type="text"
									name="maxprice" size="10" value="" /></td>
							</tr>

							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									class="ta_01"></td>
								<td class="ta_01" bgColor="#ffffff"><font face="宋体"
									color="red"> &nbsp;</font>
								</td>
								<td align="right" bgColor="#ffffff" class="ta_01"><br>
									<br></td>
								<td align="right" bgColor="#ffffff" class="ta_01">
									<button type="submit" id="search" name="search"
										value="&#26597;&#35810;" class="button_view">
										&#26597;&#35810;</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									
									 <a type="" href="AdminAction_execute">重置</a>
								</td>
							</tr>
						</table>
					</td>
</form><a href="aa"></a>
	<form id="Form2" name="Form2" action="#" method="post">
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</TD>
				</tr>
				<tr>
					<td class="ta_01" align="right">
					<button type="button" id="add" name="add" value="批量删除"
							class="button_add" onclick="delAllBooks()">批量删除
						</button>
						<input type="button" onclick="window.location.href='products/add.jsp'" value="添加"/>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="10%"><input type="checkbox" id="ckAll" onclick="checkAll()"/>全选/反选 </td>
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品数量</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>

								<td width="8%" align="center">删除</td>
							</tr>

						<s:iterator value="books" var="book">
						
							<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23"><input type="checkbox" name="ids" value="${book.id}"/></td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="23">${book.id }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${book.name }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${book.price }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="8%">${book.pnum }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center">${book.category}</td>
									
									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="admin/AdminAction_toUpdate.action?id=${book.id}">
											<img
											src="${pageContext.request.contextPath}/admin/images/i_edit.gif"
											border="0" style="CURSOR: hand"> </a>
									</td>

									<td align="center" style="HEIGHT: 22px" width="7%"><a
										href="${pageContext.request.contextPath}/admin/AdminAction_delBook?cid=${book.id }">
											<img
												src="${pageContext.request.contextPath}/admin/images/i_del.gif" 
											width="16" height="16" border="0" style="CURSOR: hand">
											
									</a>
									</td>
								</tr>
						  
						</s:iterator>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

