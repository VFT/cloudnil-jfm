<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="GENERATOR" content="Microsoft FrontPage 6.0">
<meta name="ProgId" content="FrontPage.Editor.Document">
<title>用户登录</title>
<style>
<!--
.errors {clear:both;font-size:12px;color:maroon; line-height:1.5;text-align: center;}
TD {
	FONT-SIZE: 9pt;
	FONT-FAMILY: "宋体", "Times New Roman";
}

BODY {
	SCROLLBAR-FACE-COLOR: #dee3e7;
	SCROLLBAR-HIGHLIGHT-COLOR: #ffffff;
	SCROLLBAR-SHADOW-COLOR: #dee3e7;
	SCROLLBAR-3DLIGHT-COLOR: #d1d7dc;
	SCROLLBAR-ARROW-COLOR: #006699;
	SCROLLBAR-TRACK-COLOR: #efefef;
	SCROLLBAR-DARKSHADOW-COLOR: #98aab1
}

.btn_on {
	CURSOR: hand
}

a:link {
	font-size: 9pt;
	color: #FFFFFF;
	text-decoration: none;
}

a:visited {
	font-size: 9pt;
	color: #FFFFFF;
	text-decoration: none;
}

a:hover {
	font-size: 9pt;
	color: #FCC93E;
	text-decoration: none;
}

a:active {
	font-size: 9pt;
	color: #FCC93E;
	text-decoration: none;
}
-->
</style>
<script type="text/javascript">
function form_submit(){
	document.getElementById("fm1").submit();
}
function form_reset(){
	document.getElementById("username").value="";
	document.getElementById("password").value="";
	document.getElementById("username").focus();
}
</script>
</head>

<body background="${ctx}/images2/bk-5.jpg">

	<table border="0" cellspacing="1" width="100%" id="AutoNumber1"
		height="100%">
		<tr>
			<td width="100%" align="center">
				<table border="1" cellspacing="7" width="512" id="AutoNumber2"
					bordercolor="#999999"
					style="border-right:2px solid #999999; border-bottom:2px solid #999999; border-collapse: collapse"
					bgcolor="#FFFFFF" height="322">
					<tr>
						<td width="509" height="315" bordercolor="#0033CC"
							bgcolor="#EEFFFF">
							<table border="0" width="800" id="AutoNumber3" height="498"
								style="border-style:solid; border-width:1px; padding:0; border-collapse: collapse"
								bordercolor="#3399FF" cellpadding="0"
								background="${ctx}/images2/login2.jpg">
								<tr>
									<td height="223"></td>
								</tr>
								<tr>
									<td height="273" align="center">
									<form:form method="post" id="fm1" cssClass="fm-v clearfix" commandName="${commandName}" htmlEscape="true">
									<form:errors path="*" id="msg" cssClass="errors" element="div" />
										<table border="0" cellspacing="0" cellpadding="4" id="table1"
											width="250">
											<tr>
												<td width="52" align="right"><b>
													<font color="#FFFFFF" size="2">帐 号:</font>
												</b>
												</td>
												<td width="166" colspan="2">
												<spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
												<font color="#FFFFFF" style="font-size: 12px">
														<form:input cssClass="required" cssErrorClass="error" id="username" tabindex="1" style="width: 160px;border:1px solid #CCFFFF;line-height: 100%; font-size: 9pt; margin-top: 0; margin-bottom: 0; background-color:#5FD8F4" accesskey="${userNameAccessKey}" path="username" autocomplete="false" htmlEscape="true" />
												</font>
												</td>
											</tr>
											<tr>
												<td width="52" align="right"><b> <font
														color="#FFFFFF" size="2">密 码:</font>
												</b>
												</td>
												<td width="166" colspan="2">
												<spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
												<font color="#FFFFFF" style="font-size: 12px">
													<form:password cssClass="required" cssErrorClass="error" id="password" tabindex="2" path="password" style="width: 160px;border:1px solid #CCFFFF;line-height: 100%; font-size: 9pt; margin-top: 0; margin-bottom: 0; background-color:#5FD8F4"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
												</font>
												</td>
											</tr>
											<input type="hidden" name="lt" value="${loginTicket}" />
											<input type="hidden" name="execution" value="${flowExecutionKey}" />
											<input type="hidden" name="_eventId" value="submit" />
											<tr>
												<td width="52" align="right" height="24"></td>
												<td width="83" height="24" align="center">
														<img border="0" src="${ctx}/images2/an_1.png" width="59" height="19" class="btn_on" onclick="form_submit()">
												</td>
												<td width="83" height="24" align="center">
													<p align="left">
														<img border="0" src="${ctx}/images2/an_2.png" width="59" height="19" class="btn_on" onclick="form_reset()">
												</td>
											</tr>
										</table>
										</form:form>
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
				<table border="0" cellpadding="0" style="border-collapse: collapse"
					bordercolor="#111111" width="800" id="AutoNumber7" height="42">
					<tr>
						<td width="533" height="42"></td>
					</tr>
				</table></td>
		</tr>
	</table>

</body>

</html>