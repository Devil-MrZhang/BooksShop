<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function fun(){
    
   
	        alert("sadas");
	        var vas = document.getElementById("pwdd").value;
			var vas1 = document.getElementById("pwd").value;	
			alert(vas);
			if(vas!=vas1){
			alert("两次密码输入不一致");
			}else{
				$('#tijiao').removeAttr("disabled");
			}
		
			}
	/* --------------------------- */
	

</script>

<script type="text/javascript">
	$(function(){
		

		$('#ypwd').blur(function(){
			
			 var params = {
						ypwd :document.getElementById("ypwd").value,
					};
			 
			$.post("ajax.action" , params, function(data){
				
				var jsonObject = eval("(" + data + ")");
				
				if (jsonObject != null) {
					var song = jsonObject.songList;
						if(song==1)	{
							alert("验证过关");
							
							
						}
						else{
							alert("输入正确的密码");
						
						}
				}
				
				
				
				
			}) ;
		});
	}) ;
 
 
</script>

<body class="main">



	<jsp:include page="head.jsp" />

	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd"><img src="images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/modifyuserinfo.jsp">用户信息修改</a>
							</td>
						</tr>
						<tr>
							<td class="listtd"><img src="images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="${pageContext.request.contextPath }/modifyuserinfo2.jsp">用户密码修改</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/orderlist.jsp">订单查询</a>
							</td>
						</tr>

						<tr>
							<td class="listtd"><img src="images/miniicon.gif" width="9"
								height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/product/UserAction_writeoff.action">用戶退出</a></td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="${pageContext.request.contextPath }/index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;<a
							href="myAccount.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>





					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<form action="${pageContext.request.contextPath }/product/UserAction_modiry" method="post">
									<input type="hidden" name="id" value="${user.id}"/>
									<table width="100%" border="0" cellspacing="2" class="upline">
										<tr>
											<td style="text-align:right; width:20%">会员邮箱：</td>
											<td><input type="text" name="lname" disabled="disabled" value="${user.email} "/></p></td>
											
											<td>&nbsp;</td>


										</tr>
										<tr>
											<td style="text-align:right">会员名：</td>
											<td><input type="text" name="lname" disabled="disabled" value="${user.username} "/></p></td>
											
											<td>&nbsp;</td>
										</tr>
										
										<tr>
											<td style="text-align:right">性别：</td>
											<td colspan="2">&nbsp;&nbsp;<input type="radio"
												name="gender" value="男"  />
												男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="gender" value="女"/> 女</td>
										</tr>
										<tr>
											<td style="text-align:right">联系方式：</td>
											<td colspan="2"><input name="telephone" type="text"
												value="" class="textinput" /></td>
										</tr>

										<tr>
											<td style="text-align:right">&nbsp;</td>
											<td>&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>





									<p style="text-align:center">

										<input id="tijiao" type="image"   src="images/botton_gif_025.gif" border="0">
										
									</p>
									<p style="text-align:center">&nbsp;</p>
								</form>
							</td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
