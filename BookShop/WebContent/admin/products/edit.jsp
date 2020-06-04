<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<script type="text/javascript">
</script>
<style type="text/css">
#category{
	position:absolute;
	left:66%;
	/* right:340px; */
	top:66px;
}
</style>
<body>
	

	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/admin/AdminAction_update.action">
	
		<input type="hidden" name="id" value="${pr.id}"/>
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="p.name" class="bg" value="${pr.name}" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="p.price" class="bg"   value="${pr.price}"/></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="p.pnum" class="bg"  value="${pr.pnum}" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff">
				<s:select  list="#{'1':'文学','2':'生活','3':'计算机','4':'外语','5':'经营','6':'励志','7':'社科',
				'8':'学术','9':'少儿','10':'艺术','11':'原版','12':'科技','13':'考试','14':'生活百科'}" name="category" id="category" />
				<%-- <select name="p.category" id="category" value="">
						<option value="0">--选择商品类别--</option>
						<option value="1">文学</option>
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
				</select> --%>
				
				</td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file"  size="30" name="p.img_url"  value="${pr.img_url}" /></td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
						name="p.description" cols="30" rows="3" style="WIDTH: 96%">${pr.description}</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
		
	</form>




</body>
</HTML>