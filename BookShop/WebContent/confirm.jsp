<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p:user />
	<!-- 确认支付form -->
	<form action="https://www.yeepay.com/app-merchant-proxy/node"
		method="get">
		<h3>订单号：</h3>
		<input type="hidden" name="pd_FrpId" value="" /> <input
			type="hidden" name="p0_Cmd" value="" /> <input
			type="hidden" name="p1_MerId" value="" /> <input
			type="hidden" name="p2_Order" value="" /> <input
			type="hidden" name="p3_Amt" value="" /> <input
			type="hidden" name="p4_Cur" value="" /> <input
			type="hidden" name="p5_Pid" value="" /> <input
			type="hidden" name="p6_Pcat" value="" /> <input
			type="hidden" name="p7_Pdesc" value="" /> <input
			type="hidden" name="p8_Url" value="" /> <input
			type="hidden" name="p9_SAF" value="" /> <input
			type="hidden" name="pa_MP" value="" /> <input type="hidden"
			name="pr_NeedResponse" value="" /> <input
			type="hidden" name="hmac" value="" /> <input type="submit"
			value="确认支付" />
	</form>
</body>
</html>