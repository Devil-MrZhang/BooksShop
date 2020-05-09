<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
  
   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css" type="text/css" />
	
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共种${5*pageResults.pageCount}商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img
										src="#"
										width="100%" height="38" />
								</div>
                     <s:iterator value="books" var="book">
								<table cellspacing="0" class="booklist">
									<tr>
										
										<td>

												<div class="divbookpic">
													<p>
														<a href="#"><img
															src="${book.img_url}"
															width="115" height="129" border="0" /> </a>
													</p>
												</div>

												<div class="divlisttitle">
													<a
														href="#">书名:${book.name}<br />售价:${book.price}</a>
												</div>
											</td>
										
									</tr>
								</table>
                            
                            
                            </s:iterator>


								<div class="pagination">
									<ul>

                                     
										<li class="disablepage"><a
											href="admin/findAction_findAllcategory.action?pageNo=${pageResults.currentPage-1}&category2=${book.category}">&lt;&lt;上一页</a>
										</li>


										<li>第  ${pageResults.currentPage}页/共${pageResults.pageCount}页</li>

										<li class="nextPage"><a
											href="admin/findAction_findAllcategory.action?pageNo=${pageResults.pageNo}&category2=${book.category}">&lt;&lt;下一页</a>
										</li>
									

									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
